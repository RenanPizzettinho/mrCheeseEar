package com.estagiario.mrcheese.model;

import javax.persistence.*;

@Entity
@Table(name = "QUEIJOS")
@SequenceGenerator(name = "SEQ_QUEIJOS", sequenceName = "SEQ_QUEIJOS")
public class Queijo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_QUEIJOS")
    private Long id;

    @Column(name = "PESO")
    private Double peso;

    @Column(name = "VALOR")
    private Double valor;

    @Column
    private Boolean vendido;

    public Queijo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }

    public Boolean getVendido() {
        return vendido;
    }
}
