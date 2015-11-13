import br.com.caelum.experimentos.touch.modelo.Estabelecimento;
import br.com.caelum.experimentos.touch.modelo.Usuario;
import br.com.caelum.experimentos.touch.modelo.UsuarioEstabelecimento;
import br.com.caelum.financas.infra.JPAUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by fabio on 12/11/15.
 */
public class UsuarioEstabelecimentoTest {

    @Test
    public void testSalvaAssociacao() throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Usuario usuario1 =  Usuario.create("paulo");
        Usuario usuario2 =  Usuario.create("afonso");

        Estabelecimento estabelecimentoA =  new Estabelecimento("estabelecimento A");
        Estabelecimento estabelecimentoB =  new Estabelecimento("estabelecimento B");

        em.persist(usuario1);
        em.persist(usuario2);
        em.persist(estabelecimentoA);
        em.persist(estabelecimentoB);

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

    @Ignore
    public void testBuscaAssociacao() throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioEstabelecimento usuarioEstabelecimento = em.find(UsuarioEstabelecimento.class, 21L);

        assertEquals(usuarioEstabelecimento.getEstabelecimentos().size(), 2);
        assertEquals(usuarioEstabelecimento.getUsuarios().size(), 2);
    }
}
