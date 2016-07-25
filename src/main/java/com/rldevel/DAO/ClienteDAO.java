package com.rldevel.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rldevel.DAO.Interfaces.ICommonDAO;
import com.rldevel.Entities.Articulo;
import com.rldevel.Entities.Cliente;

@Repository
@Transactional
public class ClienteDAO{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public boolean insert(Cliente cliente){
		try{
			this.getSessionFactory().getCurrentSession().save(cliente);
		}catch(HibernateException ex){
			return false;
		}
		return true;
	}
	
	
	public boolean update(Cliente cliente){
		try{
			this.getSessionFactory().getCurrentSession().update(cliente);			
		}catch(HibernateException ex){
			return false;
		}
		return true;
	}

	
	public boolean delete(Cliente cliente){
		try{
			this.getSessionFactory().getCurrentSession().delete(cliente);			
		}catch(HibernateException ex){
			return false;
		}
		return true;
	}
	
	
	public List<Cliente> getItemCollection(){
		return this.getSessionFactory().getCurrentSession().createQuery("from Cliente").list();
	}
	

	public List<Cliente> getItemCollection(Object... criteria){
			return this.getSessionFactory().getCurrentSession().createCriteria(Cliente.class)
			.add(Restrictions.like("nombre", criteria[0].toString())).list();
	}
}
