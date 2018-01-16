package com.estagiario.mrcheese.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "CONF_PRECO")
@SequenceGenerator(name = "SEQ_CONF_PRECO", sequenceName = "SEQ_CONF_PRECO", allocationSize = 1)
public class ConfiguracaoPreco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CONF_PRECO")
    private Long id;

    @Column(name = "VALOR")
    private Double valor;

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
}
