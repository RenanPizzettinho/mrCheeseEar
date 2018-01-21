package com.estagiario.mrcheese.service;

import com.estagiario.mrcheese.model.Item;
import com.estagiario.mrcheese.model.Pedido;
import com.estagiario.mrcheese.model.SituacaoPedido;
import com.estagiario.mrcheese.repository.PedidoRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static com.estagiario.mrcheese.model.QPedido.pedido;
import static com.estagiario.mrcheese.model.SituacaoPedido.*;

public class HomeService {

    @Inject
    private EntityManager entityManager ;

    @Inject
    private PedidoRepository pedidoRepository;

    public Dash dash() {

        Dash dash = new Dash();

        dash.setEmAberto(selectCount(pedido.situacao.eq(EM_ABERTO)));
        dash.setAprovado(selectCount(pedido.situacao.eq(APROVADO)));
        dash.setEntregue(selectCount(pedido.situacao.eq(ENTREGUE)));
        dash.setTotal(dash.getEmAberto() + dash.getAprovado() + dash.getEntregue());

        dash.setEmAberto30Dias(selectCount(getWhereSituacaoDias(EM_ABERTO)));
        dash.setAprovado30Dias(selectCount(getWhereSituacaoDias(APROVADO)));
        dash.setEntregue30Dias(selectCount(getWhereSituacaoDias(ENTREGUE)));
        dash.setTotal30Dias(dash.getAprovado30Dias() + dash.getEmAberto30Dias() + dash.getEntregue30Dias());

        return dash;

    }

    private BooleanExpression getWhereSituacaoDias(SituacaoPedido situacao) {

        LocalDate localDate = LocalDate.now().minusDays(30);

        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return pedido.situacao.eq(situacao)
                .and(pedido.data.after(date));

    }

    private long selectCount(Predicate where) {

        return select(where)
                .fetchCount();

    }

    private JPAQuery<?> select(Predicate where) {
        return new JPAQueryFactory(entityManager)
                .from(pedido)
                .where(where);
    }

    public Dash date(Date dateIni, Date dateFim) {

        Dash dash = new Dash();
        Double valorTotal = 0d;

        BooleanExpression where = pedido.data.between(dateIni, dateFim);

        List<Pedido> pedidos = pedidoRepository.select(where);

        dash.setTotal(pedidos.stream()
                .filter(pedido -> !pedido.getSituacao().equals(CANCELADO))
                .count()
        );

        Stream<Pedido> pedidoStream = pedidos.stream()
                .filter(pedido -> pedido.getSituacao().equals(ENTREGUE));

        dash.setEntregue(pedidoStream.count());

//        dash.setValorTotal(pedidoStream.flatMap(pedido -> pedido.getItens().stream())
//                .map(Item::getValor)
//                .filter(Objects::nonNull)
//                .reduce(valorTotal, (x, y) -> x + y));

        return dash;

    }

}
