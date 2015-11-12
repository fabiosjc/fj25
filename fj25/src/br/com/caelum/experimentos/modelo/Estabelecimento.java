package br.com.caelum.experimentos.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by fabio on 12/11/15.
 */
@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue
    private Long id;
    private String nomeComercial;

    public Estabelecimento(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public Long getId() {
        return id;
    }
}
