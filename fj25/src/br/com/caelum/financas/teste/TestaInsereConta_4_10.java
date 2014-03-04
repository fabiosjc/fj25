package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Transient;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

/**
 * Usando {@link ContaDAO} ao invés do {@link EntityManager} diretamente.
 * @author fabio
 *
 */
public class TestaInsereConta_4_10 {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO dao = new ContaDAO(em);
		
		Conta conta = new Conta();
		conta.setTitular("Itau");
		conta.setBanco("Itau");
		conta.setNumero("12345-6");
		conta.setAgencia("0038");
		
		EntityTransaction t1 = em.getTransaction();
		t1.begin();
		dao.adiciona(conta);
		t1.commit();
		
		EntityTransaction t2 = em.getTransaction();
		t2.begin();
		conta.setTitular("Manolo");
		t2.commit();
		
		em.close();
		
		em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		conta.setTitular("Monolitos");
		Conta c = em.merge(conta);
		
		conta.setAgencia("1111");
		c.setBanco("22222");
		
		em.getTransaction().commit();
		
		System.out.println("Conta gravada com sucesso!");
	}

}
