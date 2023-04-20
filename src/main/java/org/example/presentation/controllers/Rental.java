package org.example.presentation.controllers;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dtos.customer.CustomerDto;
import org.example.dtos.inventory.InventoryRentalDto;
import org.example.dtos.payment.PaymentDto;
import org.example.dtos.rental.RentalDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.RentalService;

import java.util.List;


@Path("rents")
public class Rental {
    RentalService rentalService = new RentalService();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllRentals(@Context UriInfo uriInfo) {
        List<RentalDto> rentals = rentalService.getAllRentals();
        GenericEntity entity = new GenericEntity<List<RentalDto>>(rentals) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).links(self).build();
    }

    @GET
    @Path("{oid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getRentalById(@PathParam("oid") int id, @Context UriInfo uriInfo) {

        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link getAll = Link.fromPath(uriInfo.getBaseUri().toString().concat("rents")).build();
        RentalDto rental = rentalService.getRentalById(id);
        return Response.ok(rental).link(self.getUri(), "self").link(getAll.getUri(), "getAll").build();
    }


    @PUT
    @Path("return/{oid}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void returnRent(@PathParam("oid") int id) throws InvalidDataException {


        rentalService.returnRent(id);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addRental(RentalDto rentalDto) throws InvalidDataException {

        rentalService.addRental(rentalDto);
    }

    @GET
    @Path("{id}/customer")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCustomerByRental(@PathParam("id")int id) {

        CustomerDto customerDto = rentalService.getCustomerByRental(id);
        return Response.ok(customerDto).build();
    }

    @GET
    @Path("{id}/inventory")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getInventoryByRent(@PathParam("id")int id) {
        InventoryRentalDto inventoryByRental = rentalService.getInventoryByRental(id);
        return Response.ok(inventoryByRental).build();
    }

}
