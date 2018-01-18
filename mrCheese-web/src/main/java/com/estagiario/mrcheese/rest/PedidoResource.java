package com.estagiario.mrcheese.rest;

import com.estagiario.mrcheese.model.Pedido;
import com.estagiario.mrcheese.model.SituacaoPedido;
import com.estagiario.mrcheese.model.SituacaoQueijo;
import com.estagiario.mrcheese.repository.PedidoRepository;
import com.estagiario.mrcheese.service.PedidoService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/pedido")
@RequestScoped
@Produces(APPLICATION_JSON)
public class PedidoResource {

    @Inject
    private PedidoRepository repository;

    @Inject
    private PedidoService pedidoService;

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") final Long id) {

        return Response.ok(repository.find(id)).build();

    }

    @GET
    public Response findAll() {

        return Response.ok(repository.findAll()).build();

    }



    @GET
    @Path("/status")
    public Response status(@QueryParam("status") final SituacaoPedido situacaoPedido){

        return Response.ok(repository.byStatus(situacaoPedido)).build();

    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") final Long id){

        final Pedido pedido = repository.find(id);

        pedidoService.excluir(pedido);

        return Response.noContent().build();

    }

    @POST
    @Path("/efetuar")
    public Response efetuar(final Pedido pedido) {

        return Response.ok(pedidoService.efetuar(pedido)).build();

    }

    @PUT
    @Path("/efetuar/{id}")
    public Response alterar(@PathParam("id") final Long id, final Pedido pedido) {

        final Pedido efetuar = pedidoService.merge(pedido);

        return Response.ok(efetuar).build();

    }

    @PUT
    @Path("{id}/cancelar")
    public Response cancelar(final Pedido pedido) {

        final Pedido cancelar = pedidoService.cancelar(pedido);

        return Response.ok(cancelar).build();

    }

    @PUT
    @Path("{id}/aprovar")
    public Response aprovar(final Pedido pedido) {

        final Pedido aprovar = pedidoService.aprovar(pedido);

        return Response.ok(aprovar).build();

    }

    @PUT
    @Path("{id}/entregar")
    public Response entregar(final Pedido pedido) {

        final Pedido entregar = pedidoService.entregar(pedido);

        return Response.ok(entregar).build();

    }

}
