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
        return Response.ok(repository.findOne()).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, ConfiguracaoPreco configuracaoPreco){
        return Response.ok(repository.merge(configuracaoPreco)).build();
    }
}
