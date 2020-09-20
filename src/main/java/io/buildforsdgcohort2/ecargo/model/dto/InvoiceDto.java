package io.buildforsdgcohort2.ecargo.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.buildforsdgcohort2.ecargo.model.base.BaseDto;
import io.buildforsdgcohort2.ecargo.model.entity.Invoice;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoiceDto extends BaseDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("total")
    private Double total;

    @JsonProperty("sub_total")
    private Double subTotal;

    @JsonProperty("paid")
    private Double paid;

    @JsonProperty("discount")
    private Double discount;

    @JsonProperty("service_tax")
    private Double tax;

    @JsonProperty("service_tax_discount")
    private Double taxDiscount;

    @JsonProperty("is_tac_exempt")
    private int is_tax_exempt;

    @JsonProperty("payment_method")
    private int payment_method;

    @JsonProperty("client")
    private UserDto client;

    @JsonProperty("driver")
    private UserDto driver;

    @JsonProperty("shipment_order")
    private ShipmentOrderDto shipmentOrder;


    public static InvoiceDto toDto(Invoice invoice){
        UserDto client = UserDto.toUserDto(invoice.getClient());
        UserDto driver = UserDto.toUserDto(invoice.getDriver());
        ShipmentOrderDto shipmentOrder= ShipmentOrderDto.toDto(invoice.getShipmentOrder());

        return new InvoiceDto(invoice.getId(),invoice.getStatus(), invoice.getTotal(), invoice.getSubTotal(),
                invoice.getPaid(), invoice.getDiscount(), invoice.getTax(), invoice.getTaxDiscount(),
                invoice.getIs_tax_exempt(), invoice.getPayment_method(), client, driver, shipmentOrder);
    }

    public static List<InvoiceDto> toDto(List<Invoice> invoices){

        List<InvoiceDto> invoiceDtos = new ArrayList<>();

        for (Invoice invoice : invoices){
            invoiceDtos.add(InvoiceDto.toDto(invoice));
        }
        return invoiceDtos;
    }
}
