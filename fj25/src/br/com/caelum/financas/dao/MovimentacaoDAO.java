package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDAO {

	private DAO<Movimentacao> dao;

	public MovimentacaoDAO(EntityManager em) {
		dao = new DAO<Movimentacao>(em, Movimentacao.class);
	}

	public void adiciona(Movimentacao mov) {
		this.dao.adiciona(mov);
	}
	
	public Movimentacao busca(Long id){
		return this.dao.busca(id);
	}
	
	public void remove(Movimentacao mov){
		this.dao.remove(mov);
	}
	
	public List<Movimentacao> lista(){
		return this.dao.lista(); 
	}
}
