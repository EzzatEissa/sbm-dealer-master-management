package com.sbm.dealer.common.exception;

import lombok.Data;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Data
public class GenericExceptionMapper extends Exception implements
        ExceptionMapper<GenericExceptionMapper> {

    private String msg;
    private Integer code;
    private String type = "error";

    public GenericExceptionMapper() {
        super("unknown Error");
    }

    public GenericExceptionMapper(String message) {
        super(message);
    }

    public GenericExceptionMapper(String message, Integer code) {
        super(message);
        this.code = code;
        this.msg = message;
        this.type = "error";
    }

    @Override
    public Response toResponse(GenericExceptionMapper ex) {
          if(ex.code == null)
            return Response.status(500).entity(new ErrorResponse(ex.getMessage(), 500))
                .type(MediaType.APPLICATION_JSON).build();
        else
            return Response.status(ex.code).entity(new ErrorResponse(ex.getMessage(), ex.code))
                    .type(MediaType.APPLICATION_JSON).build();
    }
}
