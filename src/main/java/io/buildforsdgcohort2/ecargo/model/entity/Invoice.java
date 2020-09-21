package io.buildforsdgcohort2.ecargo.model.entity;

import io.buildforsdgcohort2.ecargo.model.base.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "invoices")
@NoArgsConstructor
@AllArgsConstructor
public class Invoice extends AuditableEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String status;
    private Double total;
    private Double subTotal;
    private Double paid;
    private Double discount;
    private Double tax;
    private Double taxDiscount;
    private int is_tax_exempt;
    private int payment_method;
    private User client;
    private User driver;
    private ShipmentOrder shipmentOrder;
}
