package com.rldevel.DAO;

import java.util.List;

import org.hibernate.HibernateException;
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

	public boolean insertArticulo(Articulo articulo){
		try{
			this.sessionFactory.getCurrentSession().save(articulo);
		}catch(HibernateException ex){
			return false;
		}
		return true;
	}
	
	public boolean updateArticulo(Articulo articulo){
		try{
			this.sessionFactory.getCurrentSession().update(articulo);			
		}catch(HibernateException ex){
			return false;
		}
		return true;
	}
	
	public boolean deleteArticulo(Articulo articulo){
		try{
			this.sessionFactory.getCurrentSession().delete(articulo);
		}catch(HibernateException ex){
			return false;
		}
		return true;
	}
	
	public List<Articulo> getArticulos(){
		return this.sessionFactory.getCurrentSession().createQuery("from Articulo").list();
	}
}
