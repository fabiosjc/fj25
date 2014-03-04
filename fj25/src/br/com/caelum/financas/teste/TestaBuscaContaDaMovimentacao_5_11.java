package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaBuscaContaDaMovimentacao_5_11 {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO(em);

		Conta conta = new Conta().setBanco("BB").setAgencia("000012")
				.setNumero("1114-X").setTitular("Américo");
		Movimentacao mov = new Movimentacao().setTipoMovimentacao(
				TipoMovimentacao.SAIDA).setDate(new Date()).setDescricao("Pagamento Almoço").setValor(new BigDecimal(14.00));
		mov.setConta(conta);
		
		em.getTransaction().begin();
		dao.adiciona(mov);
		em.getTransaction().commit();
		
//		em.getTransaction().begin();
//		Movimentacao movManaged = dao.busca(new Long(28));
//		dao.remove(movManaged);
//		em.getTransaction().commit();	
//		System.out.println("Movimentacao removida com sucesso! " + movManaged.getDescricao());
		
		em.close();
	}
}
