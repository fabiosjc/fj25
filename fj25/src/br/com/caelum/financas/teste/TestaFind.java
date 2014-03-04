package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;

public class TestaFind {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		long inicio = System.currentTimeMillis();
		Movimentacao mov = em.getReference(Movimentacao.class, new Long(23));
		System.out.println(mov.getDescricao());
		long fim = System.currentTimeMillis();
		System.out.println("Tempo: " + (fim - inicio));
	}
}
