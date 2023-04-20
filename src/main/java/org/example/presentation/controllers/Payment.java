package org.example.presentation.controllers;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dtos.RentalDto;
import org.example.dtos.Staff.StaffDto;
import org.example.dtos.customer.CustomerDto;
import org.example.dtos.film.FilmDto;
import org.example.dtos.inventory.InventoryRentalDto;
import org.example.dtos.payment.PaymentDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.PaymentService;

import java.math.BigDecimal;
import java.util.List;


@Path("payment")
public class Payment {
    PaymentService paymentService = new PaymentService();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllPayments(@Context UriInfo uriInfo) {
        List<PaymentDto> allPayments = paymentService.getAllPayments();
        GenericEntity entity = new GenericEntity<List<PaymentDto>>(allPayments) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).links(self).build();
    }

    @GET
    @Path("{oid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getPaymentById(@PathParam("oid") int id, @Context UriInfo uriInfo) {

        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link getAll = Link.fromPath(uriInfo.getBaseUri().toString().concat("payment")).build();
        PaymentDto payment = paymentService.getPaymentById(id);
        return Response.ok(payment).link(self.getUri(), "self").link(getAll.getUri(), "getAll").build();
    }


    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updatePayment(PaymentDto paymentDto) {


        paymentService.updatePayment(paymentDto);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addPayment(PaymentDto paymentDto) throws InvalidDataException {

        paymentService.addPayment(paymentDto);
    }

    @GET
    @Path("{id}/customer")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

    public Response getCustomerByPayment(@PathParam("id") int id) {
        CustomerDto customerDto = paymentService.getCustomerByPayment(id);
        return Response.ok(customerDto).build();

    }


    @GET
    @Path("{id}/rents")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

    public Response getRentalByPayment(@PathParam("id") int id) {
        RentalDto rentalDto = paymentService.getRentalByPayment(id);
        return Response.ok(rentalDto).build();

    }

    @GET
    @Path("maxPayment")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public BigDecimal getMaxPayment() {
        return paymentService.getMaxPayment();
    }

    @GET
    @Path("{id}/staff")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})


    public Response getStaffByPayment(@PathParam("id") int id) {


        StaffDto staffDto = paymentService.getStaffByPayment(id);
        return Response.ok(staffDto).build();
    }
}
