package com.estagiario.mrcheese.service;

import com.estagiario.mrcheese.model.Item;
import com.estagiario.mrcheese.model.Pedido;
import com.estagiario.mrcheese.model.SituacaoPedido;
import com.estagiario.mrcheese.repository.PedidoRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static com.estagiario.mrcheese.model.QPedido.pedido;
import static com.estagiario.mrcheese.model.SituacaoPedido.*;

@Stateless
public class PedidoService {

    @Inject
    private QueijoService queijoService;

    @Inject
    private PedidoRepository pedidoRepository;

    @Inject
    private ItemPedidoService itemPedidoService;

    @Inject
    private EntityManager entityManager;

    public Pedido efetuar(final Pedido pedido) {

        pedido.setItens(itemPedidoService.calcularValorItens(pedido.getItens()));

        pedido.setSituacao(EM_ABERTO);
        Pedido persist = pedidoRepository.persist(pedido);
        persist.getItens().stream()
                .map(Item::getQueijo)
                .forEach(queijoService::emPedido);

        return persist;

    }

    public Pedido cancelar(final Pedido pedido) {

        pedido.setSituacao(CANCELADO);

        pedido.getItens().stream()
                .map(Item::getQueijo)
                .forEach(queijoService::disponivel);

        pedido.getItens().stream()
                .map(Item::getId)
                .forEach(itemPedidoService::remove);

        pedido.getItens().clear();

        return pedidoRepository.merge(pedido);

    }

    public Pedido aprovar(final Pedido pedido) {

        pedido.setSituacao(APROVADO);
        Pedido merge = pedidoRepository.merge(pedido);
        pedido.getItens().stream()
                .map(Item::getQueijo)
                .forEach(queijoService::vendido);

        return merge;

    }


    public Pedido entregar(final Pedido pedido) {

        pedido.setSituacao(ENTREGUE);
        Pedido merge = pedidoRepository.merge(pedido);
        pedido.getItens().stream()
                .map(Item::getQueijo)
                .forEach(queijoService::entregue);

        return merge;

    }

    public void excluir(final Pedido pedido) {

        pedido.getItens().stream()
                .map(Item::getQueijo)
                .forEach(queijoService::disponivel);

        pedidoRepository.remove(pedido.getId());

    }

    public Pedido merge(final Pedido pedido) {

        this.verificaQueijosRemovidos(pedido);

        pedido.setItens(itemPedidoService.calcularValorItens(pedido.getItens()));

        pedido.setSituacao(EM_ABERTO);
        Pedido persist = pedidoRepository.merge(pedido);
        persist.getItens().stream()
                .map(Item::getQueijo)
                .forEach(queijoService::emPedido);

        return persist;

    }

    private void verificaQueijosRemovidos(final Pedido entity) {

        final Pedido pedido = pedidoRepository.find(entity.getId());

        if (pedido.getItens().isEmpty()){

            return;

        }

        if(entity.getItens().containsAll(pedido.getItens())){

            return;

        }

        pedido.getItens().forEach(item -> {

            if (!entity.getItens().contains(item)){

                queijoService.disponivel(item.getQueijo());

            }

        });

    }

}

