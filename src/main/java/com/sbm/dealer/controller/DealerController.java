package com.sbm.dealer.controller;

import com.sbm.dealer.common.exception.GenericExceptionMapper;
import com.sbm.dealer.dto.DealerDto;
import com.sbm.dealer.dto.ResultDto;
import com.sbm.dealer.service.DealerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api("Dealers")
@Component
@Path("/dealer")
@ApiResponses({
        @ApiResponse(code = 400, message = "Bad request", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = GenericExceptionMapper.class),
        @ApiResponse(code = 401, message = "Unauthorized", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }),
        @ApiResponse(code = 403, message = "Forbidden", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = GenericExceptionMapper.class),
        @ApiResponse(code = 404, message = "Not found", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }),
        @ApiResponse(code = 405, message = "Method Not Allowed", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = GenericExceptionMapper.class),
        @ApiResponse(code = 406, message = "Not Acceptable", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }),
        @ApiResponse(code = 415, message = "Unsupported Media Type", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }),
        @ApiResponse(code = 429, message = "Too Many Requests", responseHeaders = { @ResponseHeader(name = "Retry-After", description = "Number in seconds to wait", response = Integer.class),
                @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }),
        @ApiResponse(code = 500, message = "Internal Server Error", responseHeaders = {
                @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = GenericExceptionMapper.class),
        @ApiResponse(code = 503, message = "Service Unavailable", responseHeaders = {
                @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = GenericExceptionMapper.class), })
public class DealerController {


    @Autowired
    private DealerService dealerService;

    @ApiOperation(value = "Get All Dealers", notes = "Get All Dealers")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get All Dealers", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response getAllDealers(
    		@ApiParam(value = "pagination page numbers", required = false) @DefaultValue("0") @QueryParam("page") int page, 
    		@ApiParam(value = "pagination size per page", required = false) @DefaultValue("10") @QueryParam("size") int size) {
    	
    	ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Done");
        resultDto.setType("success");
        resultDto.setValue(dealerService.getAllDealers(page, size));
        
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation(value = "Create Dealer details", notes = "Create Dealer details")
    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Dealer Created Successfully", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response createDealer(@ApiParam(value = "dealer object used to be inserted", required = false) @Valid  DealerDto dealerDto) throws GenericExceptionMapper{
        dealerService.saveDealer(dealerDto);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("201");
        resultDto.setMsg("Dealer is created successfully");
        resultDto.setType("success");
        return Response.status(201).entity(resultDto).build();
    }

    @ApiOperation(value = "Get Dealer By Id", notes = "Get Dealer By Id")
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get Dealer Info By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response getDealerById(@ApiParam(value = "id", required = true) @PathParam("id") Long id) throws GenericExceptionMapper{
    	
    	ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Done");
        resultDto.setType("success");
        resultDto.setValue(dealerService.getDealerById(id));
        
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation(value = "Update Dealer By Id", notes = "Update Dealer By Id")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{id}")
    @ApiResponses({ @ApiResponse(code = 200, message = "Update Dealer Info By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response updateDealer(@ApiParam(value = "id", required = true) @PathParam("id") Long id,@ApiParam(value = "dealer object used to update dealer info", required = false) DealerDto dealerDto) throws GenericExceptionMapper{
        dealerDto.setId(id);
        dealerService.updateDealer(dealerDto);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Dealer is updated successfully");
        resultDto.setType("success");
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation(value = "Delete Dealer By Id", notes = "Delete Dealer By Id")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{id}")
    @ApiResponses({ @ApiResponse(code = 204, message = "Delete Dealer By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = ResultDto.class) }, response = ResultDto.class) })
    public Response deleteDealer(@ApiParam(value = "id", required = true) @PathParam("id") Long id) throws GenericExceptionMapper {
        dealerService.deleteDealer(id);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Dealer is deleted successfully");
        resultDto.setType("success");
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation(value = "Search For Dealers By Any Fields", notes = "Search For Dealers By Any Fields")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    @ApiResponses({ @ApiResponse(code = 200, message = "Search For Dealers By Any Fields", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response getDealersByFields(@ApiParam(value = "search by dealer_name", required = false) @QueryParam("dealer_name") String dealerName,
    		@ApiParam(value = "search by dealer_code", required = false) @QueryParam("dealer_code") String dealerCode,
    		@ApiParam(value = "search by preferred_dealer", required = false) @QueryParam("preferred_dealer") String preferredDealer,
    		@ApiParam(value = "search by sales_partner", required = false) @QueryParam("sales_partner") String salesPartner,
    		@ApiParam(value = "search by used_category", required = false) @QueryParam("used_category") Boolean usedCategory
                                        ) throws GenericExceptionMapper {
        DealerDto dealerDto = new DealerDto();
        dealerDto.setDealerName(dealerName);
        dealerDto.setDealerCode(dealerCode);
        dealerDto.setPreferredDealer(preferredDealer);
        dealerDto.setSalesPartner(salesPartner);;
        dealerDto.setUsedCategory(usedCategory);

        List<DealerDto> dealersDto = dealerService.getDealersByFields(dealerDto);
        
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Done");
        resultDto.setType("success");
        resultDto.setValue(dealersDto);
        
        return Response.status(200).entity(resultDto).build();
    }
}
