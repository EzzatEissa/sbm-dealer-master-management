package com.sbm.dealer.dto;

import com.sbm.dealer.common.dto.BaseDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class DealerDto extends BaseDto {

    @Size(min = 1, max = 30)
    @NotBlank
    private String dealerName;

    @Size(min = 1, max = 30)
    @NotBlank
    private String dealerCode;

    @Size(min = 1, max = 15)
    @NotBlank
    private String language;

    @Size(min = 1, max = 100)
    private String preferredDealer;

    @Size(min = 1, max = 100)
    private String salesPartner;

    private Boolean usedCategory;
}
