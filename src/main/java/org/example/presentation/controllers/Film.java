package org.example.presentation.controllers;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dtos.PaymentDto;
import org.example.dtos.RentalDto;
import org.example.dtos.StoreDto;
import org.example.dtos.customer.CustomerDto;
import org.example.dtos.film.FilmDto;
import org.example.presistance.entities.Actor;
import org.example.presistance.entities.Category;
import org.example.presistance.entities.Language;
import org.example.presistance.enums.Rate;
import org.example.services.FilmService;

import java.util.List;

@Path("film")

public class Film {
    FilmService filmService = new FilmService();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll(@Context UriInfo uriInfo) {
        List<FilmDto> filmDtos = filmService.getAllFilms();
        GenericEntity entity = new GenericEntity<List<FilmDto>>(filmDtos) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).links(self).build();
    }

    @GET
    @Path("{oid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getFilmById(@PathParam("oid") int id, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link getAll = Link.fromPath(uriInfo.getBaseUri().toString().concat("customer")).build();
        FilmDto filmDto = filmService.getFilmById(id);
        return Response.ok(filmDto).link(self.getUri(), "self").link(getAll.getUri(), "getAll").build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addFilm(FilmDto film) {
        FilmService filmService = new FilmService();
        filmService.add(film);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateFilm(FilmDto film) {
        FilmService filmService = new FilmService();
        filmService.update(film);
    }


    public List<Actor> getFilmActors(int id) {
        return null;
    }


    public List<Category> getFilmCategory(int id) {
        return null;
    }


    public Language getFilmLanguage(int id) {
        return null;
    }


    @GET
    @Path("{id}/CheckFilmInInventory")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

    public Response CheckFilmInventory(@PathParam("id")int id) {
        boolean filmExist=filmService.CheckFilmInventory(id);
        if(filmExist)
            return Response.ok("film exist in inventory").build();
        else
            return Response.ok("film does not exist in inventory").build();
    }


    @GET
    @Path("{id}/filmsCountInInventory")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getNumberOfFilmsInInventory(@PathParam("id")int id) {
        return Response.ok("number of films in inventory= " +filmService.getNumberOfFilmsInInventory(id)).build();
    }


    @GET
    @Path("{id}/stores")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getFilmStores(@PathParam("id")int id) {
        List<StoreDto> storeDtos = filmService.getFilmStores(id);
        GenericEntity entity = new GenericEntity<List<StoreDto>>(storeDtos) {
        };
        return Response.ok(entity).build();
    }


    @GET
    @Path("{id}/rate")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getFilmRate(@PathParam("id")int id) {
        return Response.ok("rate= " +filmService.getFilmRate(id)).build();
    }


    @GET
    @Path("{id}/rentals")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<RentalDto> getFilmRentals(@PathParam("id")int id) {
        return filmService.getFilmRentals(id);
    }
}
