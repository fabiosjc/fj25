package br.com.caelum.experimentos.touch.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by fabio on 12/11/15.
 */
@Entity
public class Deposito {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    public Deposito(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
}
