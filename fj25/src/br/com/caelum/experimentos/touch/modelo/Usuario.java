package br.com.caelum.experimentos.touch.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by fabio on 12/11/15.
 */
@Entity(name = "touch_usuario")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
