package com.estagiario.mrcheese.repository;

import com.estagiario.mrcheese.model.Pedido;

import java.util.List;

public class PedidoRepository extends BasicRepository<Pedido, Long> {

    public PedidoRepository() {
        super(Pedido.class);
    }

    public List<Pedido> findAll() {
        return super.findAll("SELECT p FROM Pedido ORDER BY p.id");
    }
}
