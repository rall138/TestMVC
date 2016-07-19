package com.rldevel.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rldevel.Entities.Cliente;

@Repository
@Transactional
public class ClienteDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean insertCliente(Cliente cliente){
		try{
			this.sessionFactory.getCurrentSession().save(cliente);
		}catch(HibernateException ex){
			return false;
		}
		return true;
	}
	
	public boolean updateCliente(Cliente cliente){
		try{
			this.sessionFactory.getCurrentSession().update(cliente);			
		}catch(HibernateException ex){
			return false;
		}
		return true;
	}

	public boolean deleteCliente(Cliente cliente){
		try{
			this.sessionFactory.getCurrentSession().delete(cliente);			
		}catch(HibernateException ex){
			return false;
		}
		return true;
	}
	
	public List<Cliente> getClientes(String nombre){
		if (!nombre.equals("")){
			return this.sessionFactory.getCurrentSession().createCriteria(Cliente.class)
			.add(Restrictions.like("nombre", nombre)).list();
		}
		return this.sessionFactory.getCurrentSession().createQuery("from Cliente").list();
	}
}
