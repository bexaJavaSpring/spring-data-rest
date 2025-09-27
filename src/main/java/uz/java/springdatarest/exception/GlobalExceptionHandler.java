package uz.java.springdatarest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.java.springdatarest.dto.ResponseDto;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class, Throwable.class})
    public final ResponseEntity<Object> handleCustomException(Exception ex) {
        String message = getLastCause(ex);
        log.error(message, ex);
        if (message.equalsIgnoreCase("EntityRepresentationModel not found"))
            return new ResponseEntity<>(new ResponseDto(ResponseDto.States.ERROR, 404, "Entity not found"), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(new ResponseDto(ResponseDto.States.ERROR, 500, message), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getLastCause(Throwable throwable) {
        return throwable.getCause() == null ? (throwable.getLocalizedMessage() == null ? throwable.getMessage()
                : throwable.getLocalizedMessage()) : getLastCause(throwable.getCause());
    }
}
