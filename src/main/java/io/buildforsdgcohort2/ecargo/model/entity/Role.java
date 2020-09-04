package io.buildforsdgcohort2.ecargo.model.entity;

import com.sun.istack.NotNull;
import io.buildforsdgcohort2.ecargo.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    public Role(long id, String name){
        this.setId(id);
        this.name = name;
    }


    public static Role toEntity(Role roleDto) {
        return new Role(roleDto.getName());
    }
}
