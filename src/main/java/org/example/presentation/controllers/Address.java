package org.example.presentation.controllers;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dtos.StaffDto;
import org.example.dtos.StoreDto;
import org.example.dtos.address.AddressDto;
import org.example.dtos.address.AddressEditDto;
import org.example.dtos.customer.CustomerDto;
import org.example.services.AddressService;

import java.util.List;

@Path("address")
public class Address {
    AddressService addressService = new AddressService();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll(@Context UriInfo uriInfo) {

        List<AddressDto> addresses = addressService.getAllAddresses();
        GenericEntity entity = new GenericEntity<List<AddressDto>>(addresses) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).links(self).build();
    }

    @GET
    @Path("{oid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAddressById(@PathParam("oid") int id, @Context UriInfo uriInfo) {

        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link getAll = Link.fromPath(uriInfo.getBaseUri().toString().concat("address")).build();
        AddressDto addressDto = addressService.getAddressById(id);
        return Response.ok(addressDto).link(self.getUri(), "self").link(getAll.getUri(), "getAll").build();
    }

    @GET
    @Path("{id}/customers")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCustomerByAddress(@PathParam("id") int id) {
        List<CustomerDto> customerDtos = addressService.getCustomerByAddress(id);
        GenericEntity entity = new GenericEntity<List<CustomerDto>>(customerDtos) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Path("{id}/staff")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStaffByAddress(@PathParam("id") int id) {
        List<StaffDto> staffDtos = addressService.getStaffByAddress(id);
        GenericEntity entity = new GenericEntity<List<StaffDto>>(staffDtos) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Path("{id}/stores")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStoreByAddress(@PathParam("id") int id) {
        List<StoreDto> storeDtos = addressService.getStoreByAddress(id);
        GenericEntity entity = new GenericEntity<List<StoreDto>>(storeDtos) {
        };
        return Response.ok(entity).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addAddress(AddressEditDto addressDto) {
        AddressService addressService = new AddressService();
        addressService.addAddress(addressDto);

    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateAddress(AddressEditDto addressDto) {

        AddressService addressService = new AddressService();
        addressService.updateAddress(addressDto);

    }


}
