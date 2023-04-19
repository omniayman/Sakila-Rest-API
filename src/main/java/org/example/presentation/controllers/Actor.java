package org.example.presentation.controllers;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dtos.actor.ActorDto;
import org.example.dtos.film.FilmDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.ActorService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("actor")
public class Actor {
    ActorService actorService = new ActorService();

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getAllActors( @Context UriInfo uriInfo) {
        List<ActorDto> actorDtos=actorService.getAllActors();


        GenericEntity entity = new GenericEntity<List<ActorDto>>(actorDtos){};
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();


        return Response.ok(entity).links(self).build();

    }

    @GET
    @Path("{oid}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getActorById(@PathParam("oid") int id ,@Context UriInfo uriInfo) {
        ActorDto actorDto=actorService.getActorById(id);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link link = Link.fromPath(uriInfo.getBaseUri().toString().concat("actor")).build();
        List<Link> links=new ArrayList<>();
        links.add(self);
        links.add(link);
        actorDto.setLinks(links);
        return Response.ok(actorDto).link(self.getUri(),"self").link(link.getUri(),"getAllActors").build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response updateActor(@PathParam("id") Integer id,ActorDto actorDto,@Context UriInfo uriInfo) {

        actorService.updateActor(actorDto);
        Link link = Link.fromPath(uriInfo.getBaseUri().toString().concat("actor/").concat(id.toString())).build();
        return Response.ok().link(link.getUri(),"showUpdatedActor").build();
    }

    @POST

    public Response addActor(@FormParam("firstName") String firstName, @FormParam("lastName")String lastName
    ,@Context UriInfo uriInfo) throws InvalidDataException {
        System.out.println("name=="+firstName);
        ActorDto actorDto=new ActorDto();
        actorDto.setFirstName(firstName);
        actorDto.setLastName(lastName);
        actorService.addActor(actorDto);
        Link link = Link.fromPath(uriInfo.getBaseUri().toString().concat("actor/")).build();
        return Response.ok().link(link.getUri(),"showAllActors").build();

    }

    @GET
    @Path("{id}/films")
    public List<FilmDto> getFilmsByActorId(@PathParam("id") int id) {

        return actorService.getFilmsByActorId(id);

    }

    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<ActorDto> getActorsByName(@PathParam("name")String name) {

        System.out.println(name);
        return actorService.getActorsByName(name);
    }

}

