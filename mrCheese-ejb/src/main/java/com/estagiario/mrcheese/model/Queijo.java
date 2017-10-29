package com.estagiario.mrcheese.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QUEIJOS")
@SequenceGenerator(name = "SEQ_QUEIJOS", sequenceName = "SEQ_QUEIJOS")
public class Queijo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_QUEIJOS")
    private Long id;

    @Column(name = "PESO", length = 15, scale = 2)
    private BigDecimal peso;

    @Column(name = "LOTE")
    private String lote;

    public Queijo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
}
