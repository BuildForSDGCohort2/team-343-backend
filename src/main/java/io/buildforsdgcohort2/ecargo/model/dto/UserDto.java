package io.buildforsdgcohort2.ecargo.model.dto;


import io.buildforsdgcohort2.ecargo.model.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private  long id;
    private String email;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String activation_code;
    private boolean isActivated;
    private LocalDate isActivatedAt;
    private LocalDate lastLogin;
    private LocalDate createAt;
    private LocalDate updateAt;
    private LocalDate lastSeenAt;
    private boolean isDriver;
    private boolean isEmployer;
    private boolean isClient;
    private List<RoleDto> roles;

    public UserDto(String email, String username, String password, String first_name, String last_name, String activation_code,
                   boolean activated, LocalDate isActivatedAt, LocalDate createAt, LocalDate lastLogin, LocalDate updateAt,
                   LocalDate lastSeenAt, List<RoleDto> toDto) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.activation_code = activation_code;
        this.isActivated = isActivated;
        this.isActivatedAt = isActivatedAt;
        this.lastLogin = lastLogin;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.lastSeenAt = lastSeenAt;
        this.roles = roles;
    }


    public static UserDto toUserDto(User user){
        return new UserDto(user.getEmail(), user.getUsername(), user.getPassword(), user.getFirst_name(),
                user.getLast_name(), user.getActivation_code(), user.getIsActivatedAt(), user.getCreateAt(), user.getLastLogin(),
                user.getUpdateAt(), user.getLastSeenAt(), user.isActivated(), RoleDto.toDto(user.getRoles()));
    }

    public static List<UserDto> toDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
            userDtos.add(UserDto.toUserDto(user));

        }

        return userDtos;
    }
}
