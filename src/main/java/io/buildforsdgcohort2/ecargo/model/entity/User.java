package io.buildforsdgcohort2.ecargo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class User {

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String first_name;

    @Column(name = "lastName")
    private String last_name;

    @Column(name = "activationCode")
    private String activation_code;

    @Column
    private boolean isActivated;

    @Column
    private LocalDate isActivatedAt;

    @Column
    private LocalDate lastLogin;

    @Column
    private LocalDate createAt;

    @Column
    private LocalDate updateAt;

    @Column
    private LocalDate lastSeenAt;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER) // cascade = {CascadeType.ALL}
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
            )
    private List<Role> roles;
}
