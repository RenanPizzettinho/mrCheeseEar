package com.estagiario.mrcheese.repository;

import com.estagiario.mrcheese.model.ConfiguracaoPreco;

import javax.ejb.Stateless;

@Stateless
public class ConfiguracaoPrecoRepository extends BasicRepository<ConfiguracaoPreco, Long> {

    public ConfiguracaoPrecoRepository() {
        super(ConfiguracaoPreco.class);
    }

    public ConfiguracaoPreco findOne() {
        return super.findOne("SELECT c FROM ConfiguracaoPreco c ORDER BY c.id");
    }
}
