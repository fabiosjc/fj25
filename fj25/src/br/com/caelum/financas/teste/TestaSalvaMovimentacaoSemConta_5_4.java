
package br.com.caelum.financas.teste;


import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;


/**
 * Testa a persistencia da Movimentacao sem uma conta associada
 * 
 * @author fabio
 */
public class TestaSalvaMovimentacaoSemConta_5_4 {

    public static void main(String[] args) {

        new JPAUtil();
        EntityManager em = JPAUtil.getEntityManager();

        Movimentacao mov = new Movimentacao();
        mov.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        mov.setData(Calendar.getInstance());
        mov.setDescricao("Pagamento");
        mov.setValor(new BigDecimal("678.00"));

        em.getTransaction().begin();
        em.persist(mov);
        em.getTransaction().commit();
        em.close();

        System.out.println("Movimentacao gravada com sucesso!");
    }

}
