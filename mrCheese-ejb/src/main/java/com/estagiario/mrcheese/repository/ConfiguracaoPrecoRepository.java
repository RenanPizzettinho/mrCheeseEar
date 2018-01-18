package com.estagiario.mrcheese.repository;

import com.estagiario.mrcheese.model.ConfiguracaoPreco;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import static com.estagiario.mrcheese.model.QConfiguracaoPreco.configuracaoPreco;

@Stateless
public class ConfiguracaoPrecoRepository extends BasicRepository<ConfiguracaoPreco, Long> {

    @Inject
    private EntityManager entityManager;

    public ConfiguracaoPrecoRepository() {
        super(ConfiguracaoPreco.class);
    }

    public ConfiguracaoPreco atual() {

        return new JPAQueryFactory(entityManager)
                .selectFrom(configuracaoPreco)
                .orderBy(configuracaoPreco.id.desc())
                .fetchFirst();

    }

}
