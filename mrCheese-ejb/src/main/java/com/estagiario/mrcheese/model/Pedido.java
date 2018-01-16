package com.estagiario.mrcheese.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.estagiario.mrcheese.model.SituacaoPedido.EM_ABERTO;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA")
    private Date data;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "ID_PEDIDO", foreignKey = @ForeignKey(name = "FK_PEDIDOS_ITENS"))
    private Set<Item> itens = new HashSet<>();

    @Column(name = "SITUACAO")
    private SituacaoPedido situacao = EM_ABERTO;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }
}
