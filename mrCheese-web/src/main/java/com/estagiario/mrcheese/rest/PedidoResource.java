package com.estagiario.mrcheese.rest;

import com.estagiario.mrcheese.repository.PedidoRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pedido")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    private PedidoRepository repository;

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id) {

        return Response.ok(repository.find(id)).build();

    }

    @GET
    public Response findAll() {

        return Response.ok(repository.findAll()).build();

    }

}
