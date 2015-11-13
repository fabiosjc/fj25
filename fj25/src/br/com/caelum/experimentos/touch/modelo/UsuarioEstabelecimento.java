package br.com.caelum.experimentos.touch.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabio on 12/11/15.
 */
@Entity(name = "touch_usuarioestabelecimento")
public class UsuarioEstabelecimento {

    private Long id;
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

    public UsuarioEstabelecimento addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return this;
    }

    public UsuarioEstabelecimento addEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimentos.add(estabelecimento);
        return this;
    }

    @ManyToMany
    @JoinTable(name = "UsuarioEstabelecimento", joinColumns = {@JoinColumn(name = "usuario_id")}, inverseJoinColumns = { @JoinColumn(name = "id")})
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @ManyToMany
    @JoinTable(name = "UsuarioEstabelecimento", joinColumns = {@JoinColumn(name = "estabelecimento_id")}, inverseJoinColumns = { @JoinColumn(name = "id")})
    public List<Estabelecimento> getEstabelecimentos() {
        return estabelecimentos;
    }

    public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
        this.estabelecimentos = estabelecimentos;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
