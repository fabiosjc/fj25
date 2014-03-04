package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta_3_10 {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("controlefinancas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Itau");
		conta.setBanco("Itau");
		conta.setNumero("12345-X");
		conta.setAgencia("0039");
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Conta gravada com sucesso!");
	}

}
