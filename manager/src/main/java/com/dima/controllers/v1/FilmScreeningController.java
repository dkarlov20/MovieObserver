package com.dima.controllers.v1;

import com.dima.models.FilmScreening;
import com.dima.services.FilmScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@Path("/manager/v1/film-screenings")
public class FilmScreeningController {
    @Autowired
    private FilmScreeningService filmScreeningService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFilmScreening(FilmScreening filmScreening) {
        return Response.status(200).entity(filmScreeningService.createFilmScreening(filmScreening)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFilmScreenings() {
        return Response.status(200).entity(filmScreeningService.getAllFilmScreenings()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmScreeningById(@PathParam("id") int id) {
        return Response.status(200).entity(filmScreeningService.getFilmScreeningById(id)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFilmScreening(@PathParam("id") int id, FilmScreening filmScreening) {
        return Response.status(200).entity(filmScreeningService.updateFilmScreening(id, filmScreening)).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFilmScreening(@PathParam("id") int id) {
        return Response.status(200).entity(filmScreeningService.deleteFilmScreening(id)).build();
    }
}