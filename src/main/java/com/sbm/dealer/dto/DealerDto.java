package com.sbm.dealer.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sbm.dealer.common.dto.BaseDto;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonClassDescription("Dealer Data transfer object")
public class DealerDto extends BaseDto {

	@JsonProperty(required = true)
	@JsonPropertyDescription("dealerName has value of length from 1 to 30")
    @Size(min = 1, max = 30)
    @NotBlank
    private String dealerName;

	@JsonProperty(required = true)
	@JsonPropertyDescription("dealerCode has value of length from 1 to 30")
    @Size(min = 1, max = 30)
    @NotBlank
    private String dealerCode;

	@JsonProperty(required = true)
	@JsonPropertyDescription("language has value of length from 1 to 25")
    @Size(min = 1, max = 25)
    @NotBlank
    private String language;

	@JsonProperty(required = false)
	@JsonPropertyDescription("preferredDealer has value of length from 1 to 100")
    @Size(min = 1, max = 100)
    private String preferredDealer;

	@JsonProperty(required = false)
	@JsonPropertyDescription("salesPartner has value of length from 1 to 100")
    @Size(min = 1, max = 100)
    private String salesPartner;

	@JsonProperty(required = false)
	@JsonPropertyDescription("usedCategory for used category")
    private Boolean usedCategory;
}
