package com.rldevel.DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.rldevel.Entities.Cliente;

@Repository
@Transactional
public class ClienteDAO implements Serializable{

	private static final long serialVersionUID = 1L;

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
	
	@SuppressWarnings("unchecked")	
	public List<Cliente> getItemCollection(){
		return this.getSessionFactory().getCurrentSession().createQuery("from Cliente").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getItemCollection(Object... criteria){
		return this.getSessionFactory().getCurrentSession()
				.getNamedQuery("ClienteByName").setString("nombre", "%"+criteria[0].toString()+"%")
				.list();
	}
}
