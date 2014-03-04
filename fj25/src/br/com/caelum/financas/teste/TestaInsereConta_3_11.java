package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta_3_11 {
	public static void main(String[] args) {
//		long inicio = System.currentTimeMillis(); 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("controlefinancas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Itau");
		conta.setBanco("Itau");
		conta.setNumero("12345-X");
		conta.setAgencia("0039");
		
		long inicio = System.currentTimeMillis(); 
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Executando em: " + (fim - inicio));
	}

}
