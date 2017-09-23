package com.estagiario.mrcheese.rest;

import com.estagiario.mrcheese.model.Cliente;
import com.estagiario.mrcheese.repository.ClienteRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cliente")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    private ClienteRepository repository;

    @GET
    @Path("{id}")
    public Response find(@DefaultValue("0") @PathParam("id") Long id) {
        return Response.ok(repository.find(id)).build();
    }

    @GET
    public Response findAll(){
        return Response.ok(repository.findAll()).build();
    }

    @POST
    public Response create(Cliente cliente){
        return Response.ok(repository.persist(cliente)).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Cliente cliente){
        return Response.ok(repository.merge(cliente)).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id){
        repository.remove(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
