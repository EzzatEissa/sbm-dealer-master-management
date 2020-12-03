package com.sbm.dealer.dto;

import com.sbm.dealer.common.dto.BaseDto;
import com.sbm.dealer.model.Dealer;
import lombok.Data;

@Data
public class DealerDto extends BaseDto {

    private String dealerName;

    private String dealerCode;

    private String language;

    private String preferredDealer;

    private String salesPartner;

    private boolean usedCategory;
}
