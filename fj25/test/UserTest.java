import br.com.caelum.experimentos.modelo.Usuario;
import br.com.caelum.financas.infra.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

/**
 * Created by fabio on 12/11/15.
 */

public class UserTest {

    @Test
    public void testSalvaUser() throws Exception {
        Usuario usuario =  Usuario.create("Altair");

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();

        assertEquals(usuario.getLogin(), "Altair");
        assertNotNull(usuario.getId());

    }
}