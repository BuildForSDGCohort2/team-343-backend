package io.buildforsdgcohort2.ecargo.model.entity;

import io.buildforsdgcohort2.ecargo.model.base.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "currencies")
@NoArgsConstructor
@AllArgsConstructor
public class Currencies extends AuditableEntity<Long> {

    private static final long serialVersionUID = 1L;

    private String currency_code;
    private String currency_symbol;
    private String decimal_point;
    private String thousand_separator;
}
