
package br.com.caelum.financas.teste;


import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;


public class TestaPesquisaConta_4_7 {

    public static void main(String[] args) {

        new JPAUtil();
        EntityManager em = JPAUtil.getEntityManager();
        ContaDAO dao = new ContaDAO(em);

        em.getTransaction().begin();

        // List<Conta> lista = dao.lista();
        // for (Conta conta : lista) {
        // System.out.println("Conta:" + conta.getId() + "---" + conta.getTitular());
        // }

        Conta conta = dao.busca(37L);
        System.out.println(conta.getTitular());

        em.getTransaction().commit();
        em.close();
    }

}
