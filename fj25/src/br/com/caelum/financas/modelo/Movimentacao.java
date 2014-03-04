package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
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
	private Date date;
	private BigDecimal valor;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Conta conta;
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;

	 public Long getId() {
	 return id;
	 }
	 public void setId(Long id) {
	 this.id = id;
	 }

	public String getDescricao() {
		return descricao;
	}

	public Movimentacao setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public Movimentacao setDate(Date date) {
		this.date = date;
		return this;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Movimentacao setValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public Movimentacao setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
		return this;
	}

}
