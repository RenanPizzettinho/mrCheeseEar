package com.estagiario.mrcheese.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARQUIVOS")
public class Arquivo {

    @Id
    private Long id;


}
