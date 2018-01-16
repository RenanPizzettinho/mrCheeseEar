package com.estagiario.mrcheese.repository;

import com.estagiario.mrcheese.model.Queijo;
import com.estagiario.mrcheese.model.SituacaoQueijo;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

import static com.estagiario.mrcheese.model.QQueijo.queijo;
import static com.estagiario.mrcheese.model.SituacaoQueijo.DIPONIVEL_PARA_VENDA;

@Stateless
public class QueijoRepository extends BasicRepository<Queijo, Long> {

    @Inject
    private EntityManager entityManager;

    public QueijoRepository() {
        super(Queijo.class);
    }

    public List<Queijo> findAll(){
        return super.findAll("SELECT q FROM Queijo q ORDER BY q.id");
    }

    public List<Queijo> byStatus(SituacaoQueijo situacaoQueijo) {

        return select(queijo.situacao.eq(situacaoQueijo));

    }

    private List<Queijo> select(BooleanExpression eq) {

        return new JPAQueryFactory(entityManager)
                .selectFrom(queijo)
                .where(eq)
                .fetch();

    }

}
