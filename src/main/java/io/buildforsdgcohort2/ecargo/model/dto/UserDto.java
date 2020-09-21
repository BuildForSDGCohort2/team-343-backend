package io.buildforsdgcohort2.ecargo.model.dto;


import io.buildforsdgcohort2.ecargo.model.base.BaseDto;
import io.buildforsdgcohort2.ecargo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {

    private long id;
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
    private boolean isClient;
    private List<RoleDto> roles;

    public UserDto(long id, String email, String username, String password, String first_name, String last_name,
                   String activation_code, boolean isActivated, LocalDate isActivatedAt, LocalDate lastLogin,
                   LocalDate createAt, LocalDate updateAt, LocalDate lastSeenAt, List<RoleDto> roles) {
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


    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getEmail(),user.getUsername(), user.getPassword(), user.getFirst_name(),
                user.getLast_name(), user.getActivation_code(), user.isActivated(), user.getIsActivatedAt(),
                user.getLastLogin(), user.getCreateAt(), user.getUpdateAt(), user.getLastSeenAt(),RoleDto.toDto(user.getRoles()));
    }


    public static List<UserDto> toUserDto(List<User> users) {
        List<UserDto> usersDto = new ArrayList<>();

        for (User user : users) {
            usersDto.add(UserDto.toUserDto(user));

        }

        return usersDto;
    }

}
