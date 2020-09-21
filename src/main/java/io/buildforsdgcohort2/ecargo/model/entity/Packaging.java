package io.buildforsdgcohort2.ecargo.model.entity;

import io.buildforsdgcohort2.ecargo.model.base.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "packagings")
@NoArgsConstructor
@AllArgsConstructor
public class Packaging extends AuditableEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String name;
    private String packaging_description;
    private Integer quantity;
    private Integer weight;
    private Integer height;
    private Integer width;
    private Integer length;
    private Integer num_boxes;
    private Integer num_pallets;
    private String status;

}
