package io.buildforsdgcohort2.ecargo.model.dto;

import io.buildforsdgcohort2.ecargo.model.base.BaseDto;
import io.buildforsdgcohort2.ecargo.model.entity.ShipmentOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentOrderDto extends BaseDto {

    private long id;
    private String status;
    private LocalDate ship_date;
    private LocalTime delivery_time;
    private LocalDate delivery_date;
    private String order_description;
    private PackagingDto packaging;
    private Double price;
    private AddressDto sender_address;
    private AddressDto receiver_address;
    private UserDto driver;
    private UserDto sender;
    private UserDto receiver;
    private CurrenciesDto currency;


    public static ShipmentOrderDto toDto(ShipmentOrder order){

        ShipmentOrderDto shipmentOrderDto = new ShipmentOrderDto();

        if(order.getSender_address() != null){
            shipmentOrderDto.setSender_address(AddressDto.toDto(order.getSender_address()));
        }

        if (order.getReceiver_address() != null){
            shipmentOrderDto.setReceiver_address(AddressDto.toDto(order.getReceiver_address()));
        }

        if (order.getDriver() != null){
            shipmentOrderDto.setDriver(UserDto.toUserDto(order.getDriver()));
        }

        shipmentOrderDto.setId(order.getId());
        shipmentOrderDto.setStatus(order.getStatus());
        shipmentOrderDto.setShip_date(order.getShip_date());
        shipmentOrderDto.setDelivery_time(order.getDelivery_time());
        shipmentOrderDto.setDelivery_date(order.getDelivery_date());
        shipmentOrderDto.setOrder_description(order.getOrder_description());
        shipmentOrderDto.setPrice(order.getPrice());
        shipmentOrderDto.setSender(UserDto.toUserDto(order.getSender()));
        shipmentOrderDto.setReceiver(UserDto.toUserDto(order.getReceiver()));
        shipmentOrderDto.setPackaging(PackagingDto.toDto(order.getPackaging()));
        shipmentOrderDto.setCurrency(CurrenciesDto.toDto(order.getCurrencies()));

        return shipmentOrderDto;
    }

    public static List<ShipmentOrderDto> toDto(List<ShipmentOrder> orders){
        List<ShipmentOrderDto> orderDtos = new ArrayList<>();

        for (ShipmentOrder order : orders){
            orderDtos.add(ShipmentOrderDto.toDto(order));
        }
        return orderDtos;
    }
}
