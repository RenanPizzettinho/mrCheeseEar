package com.estagiario.mrcheese.repository;

import com.estagiario.mrcheese.model.Queijo;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class QueijoRepository extends BasicRepository<Queijo, Long> {

    public QueijoRepository() {
        super(Queijo.class);
    }

    public List<Queijo> findAll(){
        return super.findAll("SELECT q FROM Queijo q ORDER BY q.id");
    }
}
