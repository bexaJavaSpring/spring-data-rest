package uz.java.springdatarest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.java.springdatarest.dto.UserFilter;
import uz.java.springdatarest.dto.UserRequest;
import uz.java.springdatarest.dto.UserResponse;
import uz.java.springdatarest.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody UserRequest request){
        return ResponseEntity.ok(userService.create(request));
    }

    @PostMapping("/attach-role")
    public ResponseEntity<Boolean> attachRole(@RequestParam Long userId, @RequestParam Long roleId){
        return ResponseEntity.ok(userService.attachRole(userId, roleId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(userService.softDelete(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll(UserFilter filter){
        return ResponseEntity.ok(userService.getAll(filter));
    }
}
