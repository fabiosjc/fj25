
package br.com.caelum.financas.mb;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;


@ViewScoped
@ManagedBean
public class ContasBean {

    private Conta conta = new Conta();
    private List<Conta> contas;

    private EntityManager em;
    private ContaDAO dao;

    public ContasBean() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new ContaDAO(this.em);
    }

    public void grava() {
        System.out.println("Gravando a conta");
        this.em.getTransaction().begin();

        this.dao.adiciona(this.conta);
        this.contas = this.dao.lista();

        this.em.getTransaction().commit();
        this.em.close();

        this.limpaFormularioDoJSF();
    }

    public void remove() {
        System.out.println("Removendo a conta");
        this.em.getTransaction().begin();

        this.conta = this.dao.busca(this.conta.getId());

        this.dao.remove(this.conta);
        this.contas = this.dao.lista();

        this.em.getTransaction().commit();
        this.em.close();

        this.limpaFormularioDoJSF();

    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Conta> getContas() {
        System.out.println("Listando as contas");
        if (this.contas == null) {
            this.contas = this.dao.lista();
            // this.em.close();
        }

        return this.contas;
    }

    /**
     * Esse método apenas limpa o formulário da forma com que o JSF espera.
     * Invoque-o no momento em que precisar do formulário vazio.
     */
    private void limpaFormularioDoJSF() {
        this.conta = new Conta();
    }
}
