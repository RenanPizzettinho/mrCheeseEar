package com.estagiario.mrcheese.repository;

import com.estagiario.mrcheese.model.Pedido;
import com.estagiario.mrcheese.model.QPedido;
import com.estagiario.mrcheese.model.SituacaoPedido;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

import static com.estagiario.mrcheese.model.QPedido.pedido;

public class PedidoRepository extends BasicRepository<Pedido, Long> {

    @Inject
    private EntityManager entityManager;

    public PedidoRepository() {
        super(Pedido.class);
    }

    public List<Pedido> findAll() {

        return super.findAll("SELECT p FROM Pedido p ORDER BY p.id");

    }

    public List<Pedido> byStatus(SituacaoPedido situacaoPedido) {

        return select(pedido.situacao.eq(situacaoPedido));

    }

    public List<Pedido> select(BooleanExpression eq) {

        return new JPAQueryFactory(entityManager)
                .selectFrom(pedido)
                .where(eq)
                .fetch();

    }
}
