package br.com.caelum.experimentos.touch.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by fabio on 12/11/15.
 */
@Entity(name = "touch_estabelecimento")
public class Estabelecimento {

    @Id
    @GeneratedValue
    private Long id;
    private String nomeComercial;

    public Estabelecimento() {
    }

    public Estabelecimento(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }
}
