package com.rldevel.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rldevel.DAO.Interfaces.ICommonDAO;
import com.rldevel.Entities.Cliente;

@Repository
@Transactional
public class ClienteDAO extends DAO{

	
	public boolean insert(Cliente cliente){
		try{
			super.getSessionFactory().getCurrentSession().save(cliente);
		}catch(HibernateException ex){
			return false;
		}
		return true;
	}
	
	
	public boolean update(Cliente cliente){
		try{
			super.getSessionFactory().getCurrentSession().update(cliente);			
		}catch(HibernateException ex){
			return false;
		}
		return true;
	}

	
	public boolean delete(Cliente cliente){
		try{
			super.getSessionFactory().getCurrentSession().delete(cliente);			
		}catch(HibernateException ex){
			return false;
		}
		return true;
	}
	
	
	public List<Cliente> getItemCollection(){
		return super.getSessionFactory().getCurrentSession().createQuery("from Cliente").list();
	}
	

	public List<Cliente> getItemCollection(Object... criteria){
			return super.getSessionFactory().getCurrentSession().createCriteria(Cliente.class)
			.add(Restrictions.like("nombre", criteria[0].toString())).list();
	}
}
