package org.example.presentation.controllers;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dtos.PaymentDto;
import org.example.dtos.RentalDto;
import org.example.dtos.Staff.StaffDto;
import org.example.dtos.StoreDto;
import org.example.dtos.address.AddressDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.StaffService;

import java.util.List;


@Path("staff")
public class Staff {
    StaffService staffService = new StaffService();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllStaff(@Context UriInfo uriInfo) {
        List<StaffDto> staffDtos = staffService.getAllStaff();
        GenericEntity entity = new GenericEntity<List<StaffDto>>(staffDtos) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).links(self).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStaffById(@PathParam("id") int id,@Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link getAll = Link.fromPath(uriInfo.getBaseUri().toString().concat("rents")).build();
        StaffDto staff = staffService.getStaffById(id);
        return Response.ok(staff).link(self.getUri(), "self").link(getAll.getUri(), "getAll").build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateStaff(StaffDto staffDto) {

        staffService.updateStaff(staffDto);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addStaff(StaffDto staffDto) throws InvalidDataException {
        staffService.addStaff(staffDto);
    }

//    public StoreDto getStaffStore(int id) {
//
//        return staffService.getStaffStore(id);
//    }

    @GET
    @Path("{id}/rents")


    public Response getStaffRentals(@PathParam("id") int id) {

        List<RentalDto> RentalDto = staffService.getStaffRentals(id);
        GenericEntity entity = new GenericEntity<List<RentalDto>>(RentalDto) {
        };
        return Response.ok(entity).build();

    }


    @GET
    @Path("{id}/payments")
    public Response getStaffPayments(@PathParam("id")int id) {

        List<PaymentDto> paymentDtos = staffService.getStaffPayments(id);
        GenericEntity entity = new GenericEntity<List<PaymentDto>>(paymentDtos) {
        };
        return Response.ok(entity).build();
    }


    @GET
    @Path("{id}/isManager")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

    public Response checkStaffManager(@PathParam("id")int id) {
        boolean isManager=staffService.checkStaffManager(id);
        if (isManager) {
            return Response.ok("this Staff Member is maneger").build();
        }
        else
            return Response.ok("this Staff Member is not maneger").build();

    }

    @GET
    @Path("active")

    public Response getNumberActiveStaff() {


        return Response.ok("number of active staff= "+staffService.getNumberActiveStaff()).build();
    }

    @GET
    @Path("name/{name}")

    public Response getStaffByName(@PathParam("name")String name) {


        List<StaffDto> staffPayments = staffService.getStaffByName(name);
        GenericEntity entity = new GenericEntity<List<StaffDto>>(staffPayments) {
        };
        return Response.ok(entity).build();

    }

    @GET
    @Path("{id}/address")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

    public Response getStaffAddress(@PathParam("id")int id) {


        AddressDto addressDto = staffService.getStaffAddress(id);

        return Response.ok(addressDto).build();

    }
}
