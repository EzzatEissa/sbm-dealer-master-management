package com.sbm.dealer.dto;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonClassDescription("General Dto for all api response")
public class ResultDto {

	@JsonProperty(value ="type", required = false)
	@JsonPropertyDescription("type to have response type 'error or success'")
    private String type;
	
	@JsonProperty(value ="code", required = false)
	@JsonPropertyDescription("code to have error or success code")
    private String code;
	
	@JsonProperty(value ="msg", required = false)
	@JsonPropertyDescription("msg to have error or success message")
    private String msg;
	
	@JsonProperty(value ="value", required = false)
	@JsonPropertyDescription("value to have response value")
	private Object value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
    
    
}
