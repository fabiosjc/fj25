
package br.com.caelum.financas.teste;


import java.math.BigDecimal;
import java.util.Calendar;

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

        Conta conta = new Conta();
        conta.setBanco("BB");
        conta.setAgencia("000012");
        conta.setNumero("1114-X");
        conta.setTitular("Américo");

        Movimentacao mov = new Movimentacao();
        mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        mov.setData(Calendar.getInstance());
        mov.setDescricao("Pagamento Almoço");
        mov.setValor(new BigDecimal(14.00));
        mov.setConta(conta);

        em.getTransaction().begin();
        dao.adiciona(mov);
        em.getTransaction().commit();

        // em.getTransaction().begin();
        // Movimentacao movManaged = dao.busca(new Long(28));
        // dao.remove(movManaged);
        // em.getTransaction().commit();
        // System.out.println("Movimentacao removida com sucesso! " + movManaged.getDescricao());

        em.close();
    }
}
