package com.estagiario.mrcheese.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@XmlRootElement
@Table(name = "PEDIDOS")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", foreignKey = @ForeignKey(name = "FK_PEDIDOS_CLIENTES"))
    private Cliente cliente;

    @Column(name = "DATA")
    private LocalDate data;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "ID_PEDIDO", foreignKey = @ForeignKey(name = "FK_PEDIDOS_ITENS"))
    private Set<Item> itens = new HashSet<>();

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

    public Set<Item> getItens() {
        return itens;
    }

    public void setItens(Set<Item> itens) {
        this.itens = itens;
    }
}
