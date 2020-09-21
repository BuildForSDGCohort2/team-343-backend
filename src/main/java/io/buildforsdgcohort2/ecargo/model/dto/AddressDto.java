package io.buildforsdgcohort2.ecargo.model.dto;

import io.buildforsdgcohort2.ecargo.model.base.BaseDto;
import io.buildforsdgcohort2.ecargo.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto extends BaseDto {

    private long id;
    private String company;
    private int zip;
    private String country;
    private String state;
    private String city;
    private String street_address;
    private String phone;


    public static List<AddressDto> toDto(List<Address> addresses){
        List<AddressDto> addressDtos = new ArrayList<>();

        for (Address address : addresses){
            addressDtos.add(AddressDto.toDto(address));
        }

        return addressDtos;
    }

    public static AddressDto toDto(Address address){
        return  new AddressDto(address.getId(),address.getCompany(),address.getZip(), address.getCountry(), address.getState(),
                address.getCity(), address.getStreet_address(), address.getPhone());
    }


}
