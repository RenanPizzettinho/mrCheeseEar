package com.estagiario.mrcheese.service;

import com.estagiario.mrcheese.model.ConfiguracaoPreco;
import com.estagiario.mrcheese.model.Item;
import com.estagiario.mrcheese.repository.BasicRepository;
import com.estagiario.mrcheese.repository.ConfiguracaoPrecoRepository;
import com.estagiario.mrcheese.repository.ItemRepository;

import javax.inject.Inject;
import java.util.Set;

public class ItemPedidoService {

    @Inject
    private ItemRepository itemRepository;

    @Inject
    private ConfiguracaoPrecoRepository precoRepository;

    public Set<Item> calcularValorItens(Set<Item> itens) {

        ConfiguracaoPreco preco = precoRepository.atual();
        itens.forEach(item -> item.setValor(calculaValorItem(item, preco.getValor())));

        return itens;
    }

    public Double calculaValorItem(Item item, Double preco) {

        return preco * item.getQueijo().getPeso();

    }

    public void remove(final Long id){

        itemRepository.remove(id);

    }

}
