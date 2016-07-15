package com.rldevel.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rldevel.Entities.Articulo;

@Repository
@Transactional
public class ArticuloDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insertArticulo(Articulo articulo){
		this.sessionFactory.getCurrentSession().save(articulo);
	}
	
	public void updateArticulo(Articulo articulo){
		this.sessionFactory.getCurrentSession().update(articulo);
	}
	
	public void deleteArticulo(Articulo articulo){
		this.sessionFactory.getCurrentSession().delete(articulo);
	}
}
