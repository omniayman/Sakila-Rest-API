package org.example.presentation.controllers;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dtos.StaffDto;
import org.example.dtos.address.AddressDto;
import org.example.dtos.category.CategoryDto;
import org.example.dtos.film.FilmDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.CategoryService;

import java.util.List;

@Path("category")
public class Category {
    CategoryService categoryService = new CategoryService();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllCategories(@Context UriInfo uriInfo) {
        List<CategoryDto> categories = categoryService.getAllCategories();
        GenericEntity entity = new GenericEntity<List<CategoryDto>>(categories) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).links(self).build();
    }
    @GET
    @Path("{oid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCategoryById(@PathParam("oid") int id, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link getAll = Link.fromPath(uriInfo.getBaseUri().toString().concat("category")).build();
        CategoryDto category = categoryService.getCategoryById(id);
        return Response.ok(category).link(self.getUri(), "self").link(getAll.getUri(), "getAll").build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateCategory(CategoryDto categoryDto) {

        categoryService.updateCategory(categoryDto);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addCategory(CategoryDto categoryDto) throws InvalidDataException {
        categoryService.addCategory(categoryDto);
    }

    @GET
    @Path("{id}/films")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getFilmsByCategoryId(@PathParam("id")int id) {

        List<FilmDto> filmDtos = categoryService.getFilmsByCategoryId(id);
        GenericEntity entity = new GenericEntity<List<FilmDto>>(filmDtos) {
        };
        return Response.ok(entity).build();

    }

    @GET
    @Path("name/{name}")
    public Response getCategoryByName(@PathParam("name")String name) {

        List<CategoryDto> categoryDtos = categoryService.getCategoriesByName(name);
        GenericEntity entity = new GenericEntity<List<CategoryDto>>(categoryDtos) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Path("count/{id}")
    public Response getFilmsCountInCategory(@PathParam("id")int id) {

        return Response.ok("films count = "+categoryService.getFilmsInCategory(id)).build();
    }
}
