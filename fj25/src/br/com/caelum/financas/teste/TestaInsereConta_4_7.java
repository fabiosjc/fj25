package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

/**
 * Usando {@link ContaDAO} ao invés do {@link EntityManager} diretamente.
 * @author fabio
 *
 */
public class TestaInsereConta_4_7 {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO dao = new ContaDAO(em);
		
		Conta conta = new Conta();
		conta.setTitular("Itau");
		conta.setBanco("Itau");
		conta.setNumero("12345-6");
		conta.setAgencia("0038");
		
		em.getTransaction().begin();
		dao.adiciona(conta);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Conta gravada com sucesso!");
	}

}
