//package uz.java.springdatarest.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import uz.java.springdatarest.model.Library;
//import uz.java.springdatarest.model.Role;
//import uz.java.springdatarest.model.User;
//
//import java.util.List;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class UserResponse {
//    private Long id;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private List<RoleDto> roles;
//    private List<String> libraryList;
//
//    public static UserResponse toDto(User user) {
//        UserResponse userResponse = new UserResponse();
//        userResponse.setId(user.getId());
//        userResponse.setFirstName(user.getFirstName());
//        userResponse.setLastName(user.getLastName());
//        userResponse.setEmail(user.getEmail());
//        if (!user.getRoles().isEmpty())
//            userResponse.setRoles(user.getRoles().stream().map(UserResponse::fromRole).toList());
//        if (!user.getLibraryList().isEmpty())
//            userResponse.setLibraryList(user.getLibraryList().stream().map(Library::getName).toList());
//        return userResponse;
//    }
//
//    private static RoleDto fromRole(Role role) {
//        RoleDto roleDto = new RoleDto();
//        roleDto.setName(role.getName());
//        roleDto.setCode(role.getCode());
//        return roleDto;
//    }
//}
