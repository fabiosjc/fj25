package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

/**
 * Testa a persistencia da Movimentacao sem uma conta associada
 * @author fabio
 */
public class TestaInsereMovimentacao_5_6 {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Itau");
		conta.setBanco("Itau");
		conta.setNumero("12345-6");
		conta.setAgencia("0038");
		
		Movimentacao  mov = new Movimentacao();
		mov.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		mov.setDate(new Date());
		mov.setDescricao("Pagamento");
		mov.setValor(new BigDecimal("678.00"));
		mov.setConta(conta);
		
		em.getTransaction().begin();
//		em.persist(conta);
		em.persist(mov);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Movimentacao gravada com sucesso!");
	}

}