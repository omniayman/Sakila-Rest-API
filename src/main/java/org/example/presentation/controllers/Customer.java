package org.example.presentation.controllers;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dtos.PaymentDto;
import org.example.dtos.RentalDto;
import org.example.dtos.StoreDto;
import org.example.dtos.address.AddressDto;
import org.example.dtos.category.CategoryDto;
import org.example.dtos.customer.CustomerDto;
import org.example.dtos.customer.CustomerEditDto;
import org.example.dtos.film.FilmDto;
import org.example.services.CustomerService;

import java.util.List;


@Path("customer")
public class Customer {
    CustomerService customerService = new CustomerService();
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void add(CustomerEditDto customerDto) {

        customerService.addCustomer(customerDto);

    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void update(CustomerEditDto customerDto) {

        customerService.updateCustomer(customerDto);

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll(@Context UriInfo uriInfo) {
        List<CustomerDto> allCustomer = customerService.getAllCustomer();
        GenericEntity entity = new GenericEntity<List<CustomerDto>>(allCustomer) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).links(self).build();

    }

    @GET
    @Path("{oid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCustomerById(@PathParam("oid") int id, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link getAll = Link.fromPath(uriInfo.getBaseUri().toString().concat("customer")).build();
        CustomerDto customerDto = customerService.getCustomerById(id);
        return Response.ok(customerDto).link(self.getUri(), "self").link(getAll.getUri(), "getAll").build();
    }


    @GET
    @Path("{id}/homeStore")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getHomeStore(@PathParam("id")int id) {
       StoreDto homeStore = customerService.getCustomerHomeStore(id);

        return Response.ok(homeStore).build();
    }

    @GET
    @Path("{id}/address")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCustomerAddress(@PathParam("id")int id) {
        AddressDto addressDto = customerService.getCustomerAddress(id);

        return Response.ok(addressDto).build();
    }

    @GET
    @Path("{id}/rents")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCustomerRents(@PathParam("id")int id) {
        List<RentalDto> rentalDtos = customerService.getCustomerRents(id);
        GenericEntity entity = new GenericEntity<List<RentalDto>>(rentalDtos) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Path("{id}/payments")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

    public Response getCustomerPayments(@PathParam("id")int id) {
        List<PaymentDto> paymentDtos = customerService.getCustomerPayments(id);
        GenericEntity entity = new GenericEntity<List<PaymentDto>>(paymentDtos) {
        };
        return Response.ok(entity).build();
    }

}
