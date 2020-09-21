package io.buildforsdgcohort2.ecargo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.buildforsdgcohort2.ecargo.model.base.BaseDto;
import io.buildforsdgcohort2.ecargo.model.entity.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto extends BaseDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("shipment_order")
    private ShipmentOrderDto shipmentOrder;

    @JsonProperty("driver")
    private UserDto driver;

    @JsonProperty("creation_date")
    private LocalDate date;

    public static RequestDto toDto(Request request) {

        return new RequestDto(request.getId(), request.getStatus(), ShipmentOrderDto.toDto(request.getShipmentOrder()),
                UserDto.toUserDto(request.getDriver()), request.getCreateDate());

    }
    public static List<RequestDto> toDto(List<Request> requests) {
        List<RequestDto> requestsDtos = new ArrayList<>();

        for (Request request : requests) {
            requestsDtos.add(RequestDto.toDto(request));
        }

        return requestsDtos;
    }


}
