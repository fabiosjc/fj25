package br.com.caelum.experimentos.modelo;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabio on 12/11/15.
 */
@Entity
public class UsuarioEstabelecimento extends EntityId {

    @ManyToMany
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    @ManyToMany
    private List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

    public UsuarioEstabelecimento addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return this;
    }

    public UsuarioEstabelecimento addEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimentos.add(estabelecimento);
        return this;
    }

    public List<Estabelecimento> getEstabelecimentos() {
        return estabelecimentos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
