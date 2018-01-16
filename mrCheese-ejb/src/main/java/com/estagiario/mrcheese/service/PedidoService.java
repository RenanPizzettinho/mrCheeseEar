package com.estagiario.mrcheese.service;

import com.estagiario.mrcheese.model.Item;
import com.estagiario.mrcheese.model.Pedido;
import com.estagiario.mrcheese.repository.PedidoRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

import static com.estagiario.mrcheese.model.SituacaoPedido.*;

@Stateless
public class PedidoService {

    @Inject
    private QueijoService queijoService;

    @Inject
    private PedidoRepository pedidoRepository;

    @Inject
    private ItemPedidoService itemPedidoService;

    public Pedido efetuar(Pedido pedido) {

        pedido.setItens(itemPedidoService.calcularValorItens(pedido.getItens()));

        pedido.setSituacao(EM_ABERTO);
        Pedido persist = pedidoRepository.persist(pedido);
        persist.getItens().stream()
                .map(Item::getQueijo)
                .forEach(queijoService::emPedido);

        return persist;

    }

    public Pedido cancelar(Pedido pedido) {

        pedido.setSituacao(CANCELADO);
        Pedido merge = pedidoRepository.merge(pedido);
        pedido.getItens().stream()
                .map(Item::getQueijo)
                .forEach(queijoService::disponivel);

        return merge;

    }

    public Pedido aprovar(Pedido pedido) {

        pedido.setSituacao(APROVADO);
        Pedido merge = pedidoRepository.merge(pedido);
        pedido.getItens().stream()
                .map(Item::getQueijo)
                .forEach(queijoService::vendido);

        return merge;

    }


    public Pedido entregar(Pedido pedido) {

        pedido.setSituacao(ENTREGUE);
        Pedido merge = pedidoRepository.merge(pedido);
        pedido.getItens().stream()
                .map(Item::getQueijo)
                .forEach(queijoService::entregue);

        return merge;

    }

    public void excluir(Pedido pedido) {

        pedido.getItens().stream()
                .map(Item::getQueijo)
                .forEach(queijoService::disponivel);

        pedidoRepository.remove(pedido.getId());

    }
}
