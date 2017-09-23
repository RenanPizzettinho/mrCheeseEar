package com.estagiario.mrcheese.repository;

import com.estagiario.mrcheese.model.Cliente;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ClienteRepository extends BasicRepository<Cliente, Long> {

    public ClienteRepository() {
        super(Cliente.class);
    }

    public List<Cliente> findAll(){
        return super.findAll("SELECT c FROM Cliente c ORDER BY c.id");
    }
}