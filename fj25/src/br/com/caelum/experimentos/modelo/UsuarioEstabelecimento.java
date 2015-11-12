package br.com.caelum.experimentos.modelo;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabio on 12/11/15.
 */
@Entity
public class UsuarioEstabelecimento extends EntityId {

    @ManyToMany(targetEntity = Usuario.class)
    @JoinTable(name = "UsuarioEstabelecimento", joinColumns = {@JoinColumn(name = "usuario_id")}, inverseJoinColumns = { @JoinColumn(name = "id", insertable = false, nullable = false)})
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    @ManyToMany(targetEntity = Estabelecimento.class)
    @JoinColumn(name = "estabelecimento_id")
    @JoinTable(name = "UsuarioEstabelecimento", joinColumns = {@JoinColumn(name = "estabelecimento_id")}, inverseJoinColumns = { @JoinColumn(name = "id", insertable = false, nullable = false)})
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
