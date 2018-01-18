package com.estagiario.mrcheese.rest;

import com.estagiario.mrcheese.model.ConfiguracaoPreco;
import com.estagiario.mrcheese.repository.ConfiguracaoPrecoRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/conf-preco")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class ConfiguracaoPrecoResource {

    @Inject
    private ConfiguracaoPrecoRepository repository;

    @GET
    public Response configuracaoPreco(){

        return Response.ok(repository.atual()).build();
    }

    @POST
    public Response create(final ConfiguracaoPreco configuracaoPreco){

        final ConfiguracaoPreco persist = repository.persist(configuracaoPreco);

        return Response.ok(persist).build();

    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, final ConfiguracaoPreco configuracaoPreco){

        final ConfiguracaoPreco merge = repository.merge(configuracaoPreco);

        return Response.ok(merge).build();

    }
}
