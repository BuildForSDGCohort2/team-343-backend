package io.buildforsdgcohort2.ecargo.model.entity;

import com.sun.istack.NotNull;
import io.buildforsdgcohort2.ecargo.model.base.AuditableEntity;
import io.buildforsdgcohort2.ecargo.model.dto.MessageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "messages")
@NoArgsConstructor
@AllArgsConstructor
public class Message extends AuditableEntity<Long> {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "msg")
    private String msg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Message(String msg) {
        this.msg = msg;
    }

    public static Message toEntity(MessageDto messageDto){
        return new Message(messageDto.getMsg());
    }
}
