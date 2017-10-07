package com.estagiario.mrcheese.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ITENS")
@SequenceGenerator(name = "SEQ_ITENS", sequenceName = "SEQ_ITENS")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ITENS")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_ITEM", foreignKey = @ForeignKey(name = "FK_ITENS_QUEIJOS"))
    private Queijo queijo;

    @Column(name = "VALOR", length = 15, scale = 2)
    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
