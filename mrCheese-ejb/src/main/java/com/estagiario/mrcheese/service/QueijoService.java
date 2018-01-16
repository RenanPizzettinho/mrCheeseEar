package com.estagiario.mrcheese.service;

import com.estagiario.mrcheese.model.Queijo;
import com.estagiario.mrcheese.repository.QueijoRepository;

import javax.inject.Inject;

import static com.estagiario.mrcheese.model.SituacaoQueijo.*;

public class QueijoService {

    @Inject
    private QueijoRepository repository;

    public Queijo persist(Queijo queijo) {

        queijo.setSituacao(DIPONIVEL_PARA_VENDA);

        return repository.persist(queijo);

    }

    public Queijo merge(Long id, Queijo queijo) {

        return repository.merge(queijo);

    }

    public void remove(Long id) {

        repository.remove(id);

    }

    public Queijo emPedido(Queijo queijo) {

        queijo.setSituacao(EM_PEDIDO);

        return repository.merge(queijo);

    }

    public Queijo disponivel(Queijo queijo) {

        queijo.setSituacao(DIPONIVEL_PARA_VENDA);

        return repository.merge(queijo);

    }

    public Queijo vendido(Queijo queijo) {

        queijo.setSituacao(VENDIDO);

        return repository.merge(queijo);

    }

    public Queijo entregue(Queijo queijo) {

        queijo.setSituacao(ENTREGUE);

        return repository.merge(queijo);

    }
}
