package io.buildforsdgcohort2.ecargo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.buildforsdgcohort2.ecargo.model.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto extends BaseDto {

    @JsonProperty("error")
    private String error;

    @JsonProperty("error_description")
    private String errorDescription;
}
