package com.sbm.dealer.controller;

import com.sbm.dealer.common.consts.AppConstants;
import com.sbm.dealer.common.exception.GenericExceptionMapper;
import com.sbm.dealer.dto.DealerDto;
import com.sbm.dealer.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/dealer")
public class DealerController {


    @Autowired
    private DealerService dealerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllDealers() {
        return Response.status(200).entity(dealerService.getAllDealers()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.TEXT_PLAIN)
    public Response createDealer(DealerDto dealerDto) throws GenericExceptionMapper{
        dealerService.saveDealer(dealerDto);
        return Response.status(201).entity(AppConstants.HTTP_STATUS_CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getDealerById(@PathParam("id") Long id) throws GenericExceptionMapper{
        return Response.status(200).entity(dealerService.getDealerById(id)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateDealer(@PathParam("id") Long id, @Valid DealerDto dealerDto) throws GenericExceptionMapper{
        dealerDto.setId(id);
        dealerService.updateDealer(dealerDto);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_UPDATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDealer(@PathParam("id") Long id) throws GenericExceptionMapper {
        dealerService.deleteDealer(id);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_DELETED).build();
    }
}
