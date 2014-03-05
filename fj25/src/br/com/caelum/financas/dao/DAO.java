package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class DAO<T> {
	private final EntityManager em;
	private final Class<T> entityClass;

	DAO(EntityManager em, Class<T> entityClass){
		this.em = em;
		this.entityClass = entityClass;
	}
	
	void adiciona(T entity){
		this.em.persist(entity);
	}
	
	void remove(T entity){
		this.em.remove(entity);
	}
	
	T busca(Long id){
		return this.em.getReference(entityClass, id);
	}
	
	List<T> lista(){
		return this.em.createQuery("select e from " + entityClass.getName() + " e").getResultList();
	}
}
