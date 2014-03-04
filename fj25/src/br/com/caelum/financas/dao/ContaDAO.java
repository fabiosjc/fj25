package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDAO {
	// Composição: usamos um objeto dao para ganhar acesso a seus métodos.
	private final DAO<Conta> dao;
	
	public ContaDAO(EntityManager em) {
		dao = new DAO<Conta>(em , Conta.class);
	}
	
	public void adiciona(Conta conta){
		dao.adiciona(conta);
	}
	
	public Conta busca(Long id){
		return dao.busca(id);
	}
	
	public List<Conta> lista(){ 
		return dao.lista();
	}
	
	public void remove(Conta conta){
		dao.remove(conta);
	}
}
