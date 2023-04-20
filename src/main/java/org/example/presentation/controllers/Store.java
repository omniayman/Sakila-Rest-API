package org.example.presentation.controllers;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dtos.RentalDto;
import org.example.dtos.Staff.StaffDto;
import org.example.dtos.address.AddressDto;
import org.example.dtos.customer.CustomerDto;
import org.example.dtos.film.FilmDto;
import org.example.dtos.store.StoreDto;
import org.example.dtos.store.StoreEditDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.StoreService;

import java.util.List;


@Path("store")
public class Store {
    StoreService storeService = new StoreService();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllStores(@Context UriInfo uriInfo) {
        List<StoreDto> stores = storeService.getAllStores();
        GenericEntity entity = new GenericEntity<List<StoreDto>>(stores) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).links(self).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStoreById(@PathParam("id") int id, @Context  UriInfo uriInfo) {

        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link getAll = Link.fromPath(uriInfo.getBaseUri().toString().concat("rents")).build();
        StoreDto store = storeService.getStoreById(id);
        return Response.ok(store).link(self.getUri(), "self").link(getAll.getUri(), "getAll").build();
    }
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

    public void updateStore(StoreEditDto storeDto) {


        storeService.updateStore(storeDto);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addStore(StoreEditDto storeDto) throws InvalidDataException {

        storeService.addStore(storeDto);
    }
    @GET
    @Path("{id}/address")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStoreAddress(@PathParam("id")int id) {


        AddressDto addressDto = storeService.getStoreAddress(id);

        return Response.ok(addressDto).build();
    }


    @GET
    @Path("{id}/customers")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStoreCustomers(@PathParam("id")int id) {

        List<CustomerDto> customerDtos = storeService.getStoreCustomers(id);
        GenericEntity entity = new GenericEntity<List<CustomerDto>>(customerDtos) {
        };
        return Response.ok(entity).build();
    }


    @GET
    @Path("{id}/staff")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStoreStaff(@PathParam("id")int id) {

        List<StaffDto> staff = storeService.getStoreStaff(id);
        GenericEntity entity = new GenericEntity<List<StaffDto>>(staff) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Path("{id}/manager")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

    public Response getStoreManager(@PathParam("id")int id) {

        StaffDto staffDto = storeService.getStoreManager(id);

        return Response.ok(staffDto).build();
    }


    @GET
    @Path("{id}/films")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStoreFilms(@PathParam("id")int id) {

        List<FilmDto> films = storeService.getStoreFilms(id);
        GenericEntity entity = new GenericEntity<List<FilmDto>>(films) {
        };
        return Response.ok(entity).build();
    }


    @GET
    @Path("{id}/rents")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStoreRentals(@PathParam("id")int id) {

        List<RentalDto> RentalDto = storeService.getStoreRentals(id);
        GenericEntity entity = new GenericEntity<List<RentalDto>>(RentalDto) {
        };
        return Response.ok(entity).build();
    }
}
