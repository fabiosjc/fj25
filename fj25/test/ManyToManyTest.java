import br.com.caelum.experimentos.projpa2.modelo.Employee;
import br.com.caelum.experimentos.projpa2.modelo.Project;
import br.com.caelum.financas.infra.JPAUtil;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.*;

/**
 * Created by fabio on 13/11/15.
 */
public class ManyToManyTest {

    private Project p1;
    private Project p2;
    private Employee e1;
    private Employee e2;

    @Before
    public void setUp() throws Exception {
        p1 = new Project("Projeto 1");
        p2 = new Project("Projeto 2");

        e1 = new Employee("João");
        e2  = new Employee("Lucas");
    }

    @Test
    public void testPersistenciaComManyToMany() throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        e1.addProject(p1);
        e1.addProject(p2);

        e2.addProject(p1);

        em.persist(p1);
        em.persist(p2);
        em.persist(e1);
        em.persist(e2);
        em.getTransaction().commit();
        em.close();

    }
}
