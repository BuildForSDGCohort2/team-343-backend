package io.buildforsdgcohort2.ecargo.model.dto;


import io.buildforsdgcohort2.ecargo.model.base.BaseDto;
import io.buildforsdgcohort2.ecargo.model.entity.Packaging;
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
public class PackagingDto extends BaseDto {

    private long id;
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


    public static PackagingDto toDto(Packaging packaging){
        return new PackagingDto(packaging.getId(),packaging.getName(), packaging.getPackaging_description(), packaging.getQuantity(),
                packaging.getWeight(), packaging.getHeight(), packaging.getWidth(), packaging.getLength(),
                packaging.getNum_boxes(), packaging.getNum_pallets(), packaging.getStatus());
    }

    public static List<PackagingDto> toDto(List<Packaging> packagings){
        List<PackagingDto> packagingDtos = new ArrayList<>();

        for (Packaging packaging : packagings){
            packagingDtos.add(PackagingDto.toDto(packaging));
        }
        return packagingDtos;
    }
}
