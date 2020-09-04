package io.buildforsdgcohort2.ecargo.model.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class AuditableEntity<U> extends BaseEntity {

    @Column(name = "create_by")
    @CreatedBy
    private U createBy;

    @Column(name = "create_date")
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private LocalDate createDate;

    @Column(name = "last_modified_by")
    @LastModifiedBy
    private U lastModifiedBy;

    @Column(name = "last_modified_date")
    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    private LocalDate lastModifiedDate;

}
