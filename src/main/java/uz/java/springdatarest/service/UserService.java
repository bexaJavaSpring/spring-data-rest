package uz.java.springdatarest.service;

import org.springframework.stereotype.Service;
import uz.java.springdatarest.dto.UserFilter;
import uz.java.springdatarest.dto.UserRequest;
import uz.java.springdatarest.dto.UserResponse;
import uz.java.springdatarest.model.Role;
import uz.java.springdatarest.model.User;
import uz.java.springdatarest.repository.RoleRepository;
import uz.java.springdatarest.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserResponse getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        return UserResponse.toDto(user);
    }

    public Long create(UserRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        userRepository.save(user);
        return user.getId();
    }

    public Boolean attachRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id " + userId + " not found"));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("User with id " + userId + " not found"));
        user.getRoles().add(role);
        userRepository.save(user);
        return true;
    }

    public Boolean softDelete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        user.setDeleted(true);
        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
        return true;
    }


    public List<UserResponse> getAll(UserFilter filter) {
        return null;
    }
}
