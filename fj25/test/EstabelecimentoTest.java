import br.com.caelum.experimentos.modelo.Estabelecimento;
import br.com.caelum.experimentos.modelo.Usuario;
import br.com.caelum.financas.infra.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fabio on 12/11/15.
 */

public class EstabelecimentoTest {

    @Test
    public void testSalvaEstabelecimento() throws Exception {
        String nomeComercial = "Padoca Clube da Esquina";
        Estabelecimento estabelecimento =  new Estabelecimento(nomeComercial);

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(estabelecimento);
        em.getTransaction().commit();
        em.close();

//        assertEquals(estabelecimento.getNomeComercial(), nomeComercial);
        assertNotNull(estabelecimento.getId());

    }
}