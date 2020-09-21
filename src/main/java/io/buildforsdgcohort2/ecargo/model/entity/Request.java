package io.buildforsdgcohort2.ecargo.model.entity;

import io.buildforsdgcohort2.ecargo.model.base.AuditableEntity;
import io.buildforsdgcohort2.ecargo.model.dto.RequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "requests")
@NoArgsConstructor
@AllArgsConstructor
public class Request extends AuditableEntity<Long> {

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_order_id")
    private ShipmentOrder shipmentOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private User driver;


    public static Request toEntity(RequestDto requestDto) {
        return new Request();
    }

}
