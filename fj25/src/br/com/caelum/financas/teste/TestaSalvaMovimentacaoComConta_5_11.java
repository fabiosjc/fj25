
package br.com.caelum.financas.teste;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;


/**
 * Testa a persistencia da Movimentacao com uma conta associada, usando o dao de movimentação.
 * 
 * @author fabio
 */
public class TestaSalvaMovimentacaoComConta_5_11 {

    public static void main(String[] args) {

        new JPAUtil();
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        MovimentacaoDAO dao = new MovimentacaoDAO(em);

        Conta conta = new Conta();
        conta.setTitular("Itau");
        conta.setBanco("Itau");
        conta.setNumero("12345-6");
        conta.setAgencia("0038");

        Movimentacao mov = new Movimentacao();
        mov.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        mov.setDate(new Date());
        mov.setDescricao("Pagamento");
        mov.setValor(new BigDecimal("678.00"));
        mov.setConta(conta);

        // em.persist(conta);
        dao.adiciona(mov);

        em.getTransaction().commit();
        em.close();

        System.out.println("Movimentacao gravada com sucesso!");
    }
}
