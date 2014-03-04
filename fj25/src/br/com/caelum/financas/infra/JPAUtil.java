package br.com.caelum.financas.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("controlefinancas");
	
	static public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
