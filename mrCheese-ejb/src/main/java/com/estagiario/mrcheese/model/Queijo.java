package com.estagiario.mrcheese.model;

import javax.persistence.*;

@Entity
@Table(name = "QUEIJOS")
public class Queijo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //TODO: ver se eh melhor usar outro type para os campo 0.00
    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "PESO")
    private Double peso;

    public Queijo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
