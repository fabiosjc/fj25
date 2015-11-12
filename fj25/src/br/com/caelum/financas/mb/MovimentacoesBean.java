
package br.com.caelum.financas.mb;


import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;


@ManagedBean
public class MovimentacoesBean {

    private List<Movimentacao> movimentacoes;
    private Movimentacao movimentacao = new Movimentacao();
    private Long contaId;
    private String tags;
    @ManagedProperty(name = "em", value = "#{requestScope.em}")
    private EntityManager em;

    private MovimentacaoDAO movimentacaoDAO;
    private ContaDAO contaDAO;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public MovimentacoesBean() {
        this.movimentacaoDAO = new MovimentacaoDAO(this.em);
        this.contaDAO = new ContaDAO(this.em);
    }

    public void grava() {
        Conta conta = this.contaDAO.busca(this.contaId);
        this.movimentacao.setConta(conta);

        MovimentacaoDAO dao = new MovimentacaoDAO(this.em);
        dao.adiciona(this.movimentacao);

        System.out.println("Fazendo a gravacao da movimentacao");
        this.limpaFormularioDoJSF();
    }

    public void remove() {
        Movimentacao movimentacao = this.movimentacaoDAO.busca(this.movimentacao.getId());
        this.movimentacaoDAO.remove(movimentacao);

        System.out.println("Removendo a movimentacao");
        this.limpaFormularioDoJSF();
    }

    public List<Movimentacao> getMovimentacoes() {
        System.out.println("Listando as movimentacoes");

        this.movimentacoes = this.movimentacaoDAO.lista();

        return this.movimentacoes;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Movimentacao getMovimentacao() {
        if (this.movimentacao.getData() == null) {
            this.movimentacao.setData(Calendar.getInstance());
        }
        return this.movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public Long getContaId() {
        return this.contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    /**
     * Esse método apenas limpa o formulário da forma com que o JSF espera.
     * Invoque-o no momento em que precisar do formulário vazio.
     */
    private void limpaFormularioDoJSF() {
        this.movimentacao = new Movimentacao();
        this.tags = null;
    }

    public TipoMovimentacao[] getTiposDeMovimentacao() {
        return TipoMovimentacao.values();
    }
}
