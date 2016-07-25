package com.rldevel.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rldevel.DAO.Interfaces.ICommonDAO;
import com.rldevel.Entities.Operacion;
import com.rldevel.Entities.Enumerators.TipoOperacion;

@Repository
@Transactional
public class OperacionDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

//	@Override
//	public boolean insert(Object entity) {
//		try{
//			this.getSessionFactory().getCurrentSession().save((Operacion)entity);
//		}catch(HibernateException ex){
//			return false;
//		}
//		return true;
//	}
//
//	@Override
//	public boolean update(Object entity) {
//		try{
//			this.getSessionFactory().getCurrentSession().update((Operacion)entity);
//		}catch(HibernateException ex){
//			return false;
//		}
//		return true;
//	}
//
//	@Override
//	public boolean delete(Object entity) {
//		try{
//			this.getSessionFactory().getCurrentSession().save((Operacion)entity);
//		}catch(HibernateException ex){
//			return false;
//		}
//		return true;
//	}
//
//	@Override
//	public List<Object> getItemCollection() {
//		List<Object> operaciones = null;
//		try{
//			operaciones = this.getSessionFactory().getCurrentSession()
//					.createQuery("from Operacion").list();
//		}catch(HibernateException ex){
//			return null;
//		}
//		return operaciones;
//	}
//
//	@Override
//	public List<Object> getItemCollection(Object... criteria) {
//		List<Object> operaciones = null;
//		try{
//			if (!criteria[0].toString().equalsIgnoreCase("")){ //Tipo de operacion
//				TipoOperacion tipoOperacion = (TipoOperacion)criteria[0];
//				operaciones = this.getSessionFactory().getCurrentSession().createCriteria(Operacion.class)
//				.add(Restrictions.eq("TipoOperacion", tipoOperacion)).list();
//			}
//		}catch(HibernateException ex){
//			return null;
//		}
//		return operaciones;
//	}

	
}
