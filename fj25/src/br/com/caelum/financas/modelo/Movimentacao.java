
package br.com.caelum.financas.modelo;


import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Movimentacao {

    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    private Calendar data;
    private BigDecimal valor;

    @ManyToOne
    private Conta conta;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    public TipoMovimentacao getTipoMovimentacao() {
        return this.tipoMovimentacao;
    }

    public Movimentacao setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
        return this;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Movimentacao setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Calendar getData() {
        return this.data;
    }

    public Movimentacao setData(Calendar data) {
        this.data = data;
        return this;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public Movimentacao setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public Conta getConta() {
        return this.conta;
    }

    public Movimentacao setConta(Conta conta) {
        this.conta = conta;
        return this;
    }

}
