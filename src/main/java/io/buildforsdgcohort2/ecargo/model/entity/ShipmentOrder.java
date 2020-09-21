package io.buildforsdgcohort2.ecargo.model.entity;

import io.buildforsdgcohort2.ecargo.model.base.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "shipment_orders")
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentOrder extends AuditableEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String status;
    private LocalDate ship_date;
    private LocalTime delivery_time;
    private LocalDate delivery_date;
    private String order_description;
    private Packaging packaging;
    private Double price;
    private Address sender_address;
    private Address receiver_address;
    private User driver;
    private User sender;
    private User receiver;
    private Currencies currencies;
}
