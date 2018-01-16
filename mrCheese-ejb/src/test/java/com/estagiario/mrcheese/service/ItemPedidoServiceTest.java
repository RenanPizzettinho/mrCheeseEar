package com.estagiario.mrcheese.service;

import com.estagiario.mrcheese.model.Item;
import com.estagiario.mrcheese.model.Queijo;
import org.junit.Test;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class ItemPedidoServiceTest {

    @Produces
    @PersistenceContext
    private EntityManager em;

    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    @Produces
    private ItemPedidoService getItemPedidoService;

    @Inject
    private ItemPedidoService itemPedidoService;

    @Test
    public void deveCalcularValorItensCorretamente(){

        Item item = new Item();
        Queijo queijo = new Queijo();
        queijo.setPeso(2.0);

        item.setQueijo(queijo);
        Set<Item> set = new HashSet<>();
        set.add(item);

        itemPedidoService.calcularValorItens(set);

    }

}