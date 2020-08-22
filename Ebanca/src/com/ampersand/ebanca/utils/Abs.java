package com.ampersand.ebanca.utils;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class Abs<T> {
	
	private Class<T> ent;
	protected Session ses;
	

	public Abs(Class<T> entity) {
		this.ent = entity;
	}

	public abstract SessionFactory getSF();
	
	public List<T> get(){
		ses = getSF().getCurrentSession();
		CriteriaQuery cq = ses.getCriteriaBuilder().createQuery();
		cq.select(cq.from(ent));
		return ses.createQuery(cq).getResultList();
		
	}
	
	public T getById(Long id) {
		ses = getSF().getCurrentSession();
		return ses.find(ent, id);
	}
	
	
	public void create(T e) {
		ses = getSF().getCurrentSession();
		ses.save(e);
	}
	
	
	public void update(T u) {
		ses = getSF().getCurrentSession();
		ses.update(u);
	}
	
	public void delete(T d) {
		ses = getSF().getCurrentSession();
		ses.delete(d);
	}
	
	
	
	
	
}

