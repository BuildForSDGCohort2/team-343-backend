package io.buildforsdgcohort2.ecargo.model.entity;

import io.buildforsdgcohort2.ecargo.model.base.AuditableEntity;
import io.buildforsdgcohort2.ecargo.model.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AuditableEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Column(name = "company")
    private String company;

    @Column(name = "zip_code")
    private int zip;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street_address;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Address(String company, int zip, String country, String state, String city, String street_address,
                   String phone) {
        super();
        this.company = company;
        this.zip = zip;
        this.country = country;
        this.state = state;
        this.city = city;
        this.street_address = street_address;
        this.phone = phone;
    }


    public static Address toEntity(AddressDto addressDto){
        return new Address(addressDto.getCompany(),addressDto.getZip(),addressDto.getCountry(),addressDto.getState(),
                addressDto.getCity(), addressDto.getStreet_address(),addressDto.getPhone());
    }
}
