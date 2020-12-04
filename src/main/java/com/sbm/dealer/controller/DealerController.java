package com.sbm.dealer.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.dealer.common.exception.GenericExceptionMapper;
import com.sbm.dealer.dto.DealerDto;
import com.sbm.dealer.dto.ResultDto;
import com.sbm.dealer.service.DealerService;

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
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response createDealer(DealerDto dealerDto) throws GenericExceptionMapper{
        dealerService.saveDealer(dealerDto);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("201");
        resultDto.setMsg("Vehicle is created successfully");
        resultDto.setType("success");
        return Response.status(201).entity(resultDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getDealerById(@PathParam("id") Long id) throws GenericExceptionMapper{
        return Response.status(200).entity(dealerService.getDealerById(id)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{id}")
    public Response updateDealer(@PathParam("id") Long id, @Valid DealerDto dealerDto) throws GenericExceptionMapper{
        dealerDto.setId(id);
        dealerService.updateDealer(dealerDto);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Vehicle is updated successfully");
        resultDto.setType("success");
        return Response.status(200).entity(resultDto).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{id}")
    public Response deleteDealer(@PathParam("id") Long id) throws GenericExceptionMapper {
        dealerService.deleteDealer(id);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Vehicle is deleted successfully");
        resultDto.setType("success");
        return Response.status(200).entity(resultDto).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    public Response getVehiclesByFields(@QueryParam("dealerName") String dealerName,
                                        @QueryParam("dealerCode") String dealerCode,
                                        @QueryParam("preferredDealer") String preferredDealer,
                                        @QueryParam("salesPartner") String salesPartner,
                                        @QueryParam("usedCategory") Boolean usedCategory
                                        ) throws GenericExceptionMapper {
        DealerDto dealerDto = new DealerDto();
        dealerDto.setDealerName(dealerName);
        dealerDto.setDealerCode(dealerCode);
        dealerDto.setPreferredDealer(preferredDealer);
        dealerDto.setSalesPartner(salesPartner);;
        dealerDto.setUsedCategory(usedCategory);

        List<DealerDto> dealersDto = dealerService.getDealersByFields(dealerDto);
        return Response.status(200).entity(dealersDto).build();
    }
}
