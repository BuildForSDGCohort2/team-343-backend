package io.buildforsdgcohort2.ecargo.model.entity;

import com.sun.istack.NotNull;
import io.buildforsdgcohort2.ecargo.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role(String name){
        this.name = name;
    }

    public Role(long id, String name){
        this.setId(id);
        this.name = name;
    }

    public static Role toEntity(Role roleDto) {
        return new Role(roleDto.getName());
    }
}
