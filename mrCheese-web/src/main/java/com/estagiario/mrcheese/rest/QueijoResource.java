package com.estagiario.mrcheese.rest;

import com.estagiario.mrcheese.model.Queijo;
import com.estagiario.mrcheese.repository.QueijoRepository;
import com.estagiario.mrcheese.service.QueijoService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/queijo")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class QueijoResource {

    @Inject
    private QueijoRepository repository;

    @Inject
    private QueijoService service;

    @GET
    @Path("{id}")
    public Response find(@DefaultValue("0") @PathParam("id") Long id) {
        return Response.ok(repository.find(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(repository.findAll()).build();
    }

    @POST
    public Response create(Queijo queijo) {
        return Response.ok(service.persist(queijo)).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Queijo queijo) {
        return Response.ok(service.merge(id, queijo)).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        service.remove(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
