package io.buildforsdgcohort2.ecargo.model.entity;

import com.sun.istack.NotNull;
import io.buildforsdgcohort2.ecargo.model.base.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reviews")
@NoArgsConstructor
@AllArgsConstructor
public class Review extends AuditableEntity<Long> {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "review")
    private String review;

    @Column(name = "rating")
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private User driver;
}
