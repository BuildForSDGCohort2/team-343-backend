package io.buildforsdgcohort2.ecargo.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.buildforsdgcohort2.ecargo.model.base.BaseDto;
import io.buildforsdgcohort2.ecargo.model.entity.Message;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDto extends BaseDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("created_date")
    private LocalDate created_date;

    @JsonProperty("updated_date")
    private LocalDate updated_date;

    @JsonProperty("user")
    private UserDto user;



    public static MessageDto toDto(Message message) {
        return new MessageDto(message.getId(), message.getMsg(), message.getCreateDate(), message.getLastModifiedDate(),
                UserDto.toUserDto(message.getUser()));
    }

    public static List<MessageDto> toDto(List<Message> messages) {
        List<MessageDto> messageDtos = new ArrayList<>();

        for (Message message : messages){
            messageDtos.add(MessageDto.toDto(message));
        }
        return messageDtos;
    }


}
