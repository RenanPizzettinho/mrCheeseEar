package com.estagiario.mrcheese.service;

import com.estagiario.mrcheese.model.ConfiguracaoPreco;
import com.estagiario.mrcheese.model.Item;
import com.estagiario.mrcheese.repository.ConfiguracaoPrecoRepository;

import javax.inject.Inject;
import java.util.Set;

public class ItemPedidoService {

    @Inject
    private ConfiguracaoPrecoRepository precoRepository;

    public Set<Item> calcularValorItens(Set<Item> itens) {

        ConfiguracaoPreco preco = precoRepository.findOne();
        itens.forEach(item -> item.setValor(calculaValorItem(item, preco.getValor())));

        return itens;
    }

    public Double calculaValorItem(Item item, Double preco) {

        return preco * item.getQueijo().getPeso();

    }

}
