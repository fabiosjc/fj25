
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
    private String agencia;
    private String numero;
    private String banco;

    public Long getId() {
        return this.id;
    }

    public Conta setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBanco() {
        return this.banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

}
