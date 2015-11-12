import br.com.caelum.experimentos.modelo.Estabelecimento;
import br.com.caelum.experimentos.modelo.Usuario;
import br.com.caelum.experimentos.modelo.UsuarioEstabelecimento;
import br.com.caelum.financas.infra.JPAUtil;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by fabio on 12/11/15.
 */
public class UsuarioEstabelecimentoTest {
    EntityManager em;

    @Before
    public void setUp() throws Exception {
        em = JPAUtil.getEntityManager();
    }

    @Test
    public void testSalvaAssociacao() throws Exception {
        em.getTransaction().begin();

        Usuario usuario1 =  this.em.find(Usuario.class, 19L);
        Usuario usuario2 =  this.em.find(Usuario.class, 20L);

        Estabelecimento estabelecimentoA =  this.em.find(Estabelecimento.class, 9L);
        Estabelecimento estabelecimentoB =  this.em.find(Estabelecimento.class, 14L);

        UsuarioEstabelecimento usuarioEstabelecimento = new UsuarioEstabelecimento();
        usuarioEstabelecimento.addUsuario(usuario1).addUsuario(usuario2);
        usuarioEstabelecimento.addEstabelecimento(estabelecimentoA).addEstabelecimento(estabelecimentoB);

        em.persist(usuarioEstabelecimento);
        em.getTransaction().commit();
        em.close();

        assertEquals(usuarioEstabelecimento.getEstabelecimentos().size(), 2);
        assertEquals(usuarioEstabelecimento.getUsuarios().size(), 2);
        assertTrue(usuarioEstabelecimento.getEstabelecimentos().contains(estabelecimentoA));
        assertTrue(usuarioEstabelecimento.getUsuarios().contains(usuario1));
    }

    @Test
    public void testBuscaAssociacao() throws Exception {
        UsuarioEstabelecimento usuarioEstabelecimento = this.em.find(UsuarioEstabelecimento.class, 21L);

        assertEquals(usuarioEstabelecimento.getEstabelecimentos().size(), 2);
        assertEquals(usuarioEstabelecimento.getUsuarios().size(), 2);
    }
}
