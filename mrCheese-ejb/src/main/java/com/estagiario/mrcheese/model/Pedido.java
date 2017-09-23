package com.estagiario.mrcheese.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@Entity
@XmlRootElement
@Table(name = "PEDIDOS")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    @OneToMany
    private Set<Queijo> queijos = new HashSet<>();

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Queijo> getQueijos() {
        return queijos;
    }

    public void setQueijos(Set<Queijo> queijos) {
        this.queijos = queijos;
    }

}
