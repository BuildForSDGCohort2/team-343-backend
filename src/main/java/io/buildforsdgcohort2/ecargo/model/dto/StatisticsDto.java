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
public class StatisticsDto extends BaseDto {

    @JsonProperty("users_count")
    private long usersCount;

    @JsonProperty("active_users_count")
    private long activeUsersCount;

    @JsonProperty("orders_count")
    private long ordersCount;

    @JsonProperty("addresses_count")
    private long addressesCount;

    @JsonProperty("tickets_count")
    private long ticketsCount;
}
