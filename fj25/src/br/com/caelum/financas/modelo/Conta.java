package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue
	private Long id;
	private String titular;
	private String banco;
	private String numero;
	private String agencia;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitular() {
		return titular;
	}
	public Conta setTitular(String titular) {
		this.titular = titular;
		return this;
	}
	public String getBanco() {
		return banco;
	}
	public Conta setBanco(String banco) {
		this.banco = banco;
		return this;
	}
	public String getNumero() {
		return numero;
	}
	public Conta setNumero(String numero) {
		this.numero = numero;
		return this;
	}
	public String getAgencia() {
		return agencia;
	}
	public Conta setAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}



}
