package io.buildforsdgcohort2.ecargo.model.dto;

import io.buildforsdgcohort2.ecargo.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private String name;

    public static RoleDto toDto(Role role) {
        return new RoleDto(role.getName());
    }

    public static List<RoleDto> toDto(List<Role> roles) {
        List<RoleDto> roleDtoList = new ArrayList<>();

        for (Role role : roles) {
            roleDtoList.add(RoleDto.toDto(role));
        }

        return roleDtoList;
    }
}
