package com.estagiario.mrcheese.service;

import com.estagiario.mrcheese.model.Queijo;
import com.estagiario.mrcheese.repository.QueijoRepository;

import javax.inject.Inject;

public class QueijoService {
    
    @Inject
    private QueijoRepository repository;
    
    public Queijo persist(Queijo queijo){
        return repository.persist(queijo);
    }

    public Queijo merge(Long id, Queijo queijo){
        return repository.merge(queijo);
    }

    public void remove(Long id){
        repository.remove(id);
    }

}
