package br.com.caelum.experimentos.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by fabio on 12/11/15.
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    private String login;

    public static Usuario create(String login) {
        Usuario usuario = new Usuario();
        usuario.login = login;
        return usuario;
    }

    public String getLogin() {
        return login;
    }

    public Long getId() {
        return id;
    }
}
