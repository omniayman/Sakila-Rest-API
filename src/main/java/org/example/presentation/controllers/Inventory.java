package org.example.presentation.controllers;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dtos.address.AddressDto;
import org.example.dtos.film.FilmDto;
import org.example.dtos.inventory.InventoryDto;
import org.example.dtos.inventory.InventoryRentalDto;
import org.example.dtos.store.StoreDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.InventoryService;

import java.util.List;

@Path("inventory")
public class Inventory {
    InventoryService inventoryService = new InventoryService();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll(@Context UriInfo uriInfo) {
        List<InventoryDto> inventoryDtos = inventoryService.getAllInventories();
        GenericEntity entity = new GenericEntity<List<InventoryDto>>(inventoryDtos) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).links(self).build();
    }

    @GET
    @Path("{oid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getInventoryById(@PathParam("oid") int id, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link getAll = Link.fromPath(uriInfo.getBaseUri().toString().concat("customer")).build();
        InventoryRentalDto inventory = inventoryService.getInventoryById(id);
        return Response.ok(inventory).link(self.getUri(), "self").link(getAll.getUri(), "getAll").build();
    }


    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateInventory(InventoryDto inventoryDto) {


        inventoryService.updatePayment(inventoryDto);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addInventory(InventoryDto inventoryDto) throws InvalidDataException {

        inventoryService.addPayment(inventoryDto);
    }

    @GET
    @Path("{id}/filmsCountInInventory")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response checkInventoryInStock(@PathParam("id") int id) throws InvalidDataException {
        boolean inventoryInStock=inventoryService.checkInventoryInStock(id);

        if(inventoryInStock)
            return Response.ok("inventory in stock").build();
        else
            return Response.ok("inventory does not exist in stock").build();
    }

    @GET
    @Path("{id}/films")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getFilmByInventoryId(@PathParam("id") int id) throws InvalidDataException {
        FilmDto filmDto = inventoryService.getFilmByInventoryId(id);

        return Response.ok(filmDto).build();
    }
    @GET
    @Path("{id}/store")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

    public Response getStoreByInventoryId(@PathParam("id") int id) throws InvalidDataException {
        StoreDto storeDto = inventoryService.getStoreByInventoryId(id);

        return Response.ok(storeDto).build();
    }
}
