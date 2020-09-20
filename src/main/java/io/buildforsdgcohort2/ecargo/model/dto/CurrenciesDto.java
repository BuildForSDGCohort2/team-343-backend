package io.buildforsdgcohort2.ecargo.model.dto;

import io.buildforsdgcohort2.ecargo.model.base.BaseDto;
import io.buildforsdgcohort2.ecargo.model.entity.Currencies;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrenciesDto extends BaseDto {

    private long id;
    private String currency_code;
    private String currency_symbol;
    private String decimal_point;
    private String thousand_separator;


    public static CurrenciesDto toDto(Currencies currencies){
        return new CurrenciesDto(currencies.getId(),currencies.getCurrency_code(), currencies.getCurrency_symbol(),
                currencies.getDecimal_point(), currencies.getThousand_separator());
    }

    public static List<CurrenciesDto> toDto(List<Currencies> currenciesList){
        List<CurrenciesDto> currenciesDtos = new ArrayList<>();

        for (Currencies currencies : currenciesList){
            currenciesDtos.add(CurrenciesDto.toDto(currencies));
        }
        return currenciesDtos;
    }

}
