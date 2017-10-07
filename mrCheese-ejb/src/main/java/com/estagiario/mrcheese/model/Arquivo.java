package com.estagiario.mrcheese.model;

import javax.persistence.*;

@Entity
@Table(name = "ARQUIVOS")
@SequenceGenerator(name = "SEQ_ARQUIVOS", sequenceName = "SEQ_ARQUIVOS")
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ARQUIVOS")
    private Long id;

}