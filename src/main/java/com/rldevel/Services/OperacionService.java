package com.rldevel.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rldevel.DAO.OperacionDAO;
import com.rldevel.DAO.Interfaces.ICommonDAO;

@Service("operacionservice")
public class OperacionService {

	private OperacionDAO operaciondao;
	
	public OperacionService() {
	}
	
	public OperacionDAO getOperaciondao() {
		return operaciondao;
	}

	@Autowired
	public void setOperaciondao(OperacionDAO operaciondao) {
		this.operaciondao = operaciondao;
	}

//	@Override
//	public boolean insert(Object entity) {
//		return this.operaciondao.insert(entity);
//	}
//
//	@Override
//	public boolean update(Object entity) {
//		return this.operaciondao.update(entity);
//	}
//
//	@Override
//	public boolean delete(Object entity) {
//		return this.operaciondao.delete(entity);
//	}
//
//	@Override
//	public List<Object> getItemCollection() {
//		return this.getItemCollection();
//	}
//
//	@Override
//	public List<Object> getItemCollection(Object... criteria) {
//		return this.getItemCollection(criteria);
//	}

	
}
