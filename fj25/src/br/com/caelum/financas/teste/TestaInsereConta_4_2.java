package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta_4_2 {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
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
