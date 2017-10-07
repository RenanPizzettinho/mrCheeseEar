package com.estagiario.mrcheese.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "CLIENTES")
@SequenceGenerator(name = "SEQ_CLIENTES", sequenceName = "SEQ_CLIENTES", allocationSize = 1)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CLIENTES")
    private Long id;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "NOME", length = 255)
    private String nome;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String descricao) {
        this.nome = descricao;
    }
}
