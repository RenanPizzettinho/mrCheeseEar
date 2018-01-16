package com.estagiario.mrcheese.model;

import javax.persistence.*;
import java.math.BigDecimal;

import static com.estagiario.mrcheese.model.SituacaoQueijo.DIPONIVEL_PARA_VENDA;

@Entity
@Table(name = "QUEIJOS")
@SequenceGenerator(name = "SEQ_QUEIJOS", sequenceName = "SEQ_QUEIJOS")
public class Queijo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_QUEIJOS")
    private Long id;

    @Column(name = "PESO", length = 15, scale = 2)
    private Double peso;

    @Column(name = "LOTE")
    private String lote;

    @Column(name = "SITUACAO")
    private SituacaoQueijo situacao = DIPONIVEL_PARA_VENDA;

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

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public SituacaoQueijo getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoQueijo situacao) {
        this.situacao = situacao;
    }
}
