package io.buildforsdgcohort2.ecargo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import io.buildforsdgcohort2.ecargo.model.base.BaseEntity;
import io.buildforsdgcohort2.ecargo.model.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User  extends BaseEntity {

    private static final long serialVersionUID = 1L;

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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Review> reviews;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ShipmentOrder> shipment_orders;

    @OneToMany(mappedBy = "courier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Request> requests;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Message> messages;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Invoice> invoices;

    public static User toEntity(UserDto userDto) {
        return new User();
        // todo complete this
    }


}
