package com.sbm.dealer.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonClassDescription("General Dto for all paging api response")
@Data
public class PageResultDto {
	
	@JsonProperty(required = false)
	@JsonPropertyDescription("returned values")
	private Object contents;
	
	@JsonProperty(required = false)
	@JsonPropertyDescription("current page number'")
	private int currentPage;
	
	@JsonProperty(required = false)
	@JsonPropertyDescription("total number of elements'")
	private long totalElements;
	
	@JsonProperty(required = false)
	@JsonPropertyDescription("total number of pages'")
	private int totalPages;

}
