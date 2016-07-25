package com.rldevel.DAO.Interfaces;

import java.util.List;

public interface ICommonDAO {

	public abstract boolean insert(Object entity);
	public abstract boolean update(Object entity);
	public abstract boolean delete(Object entity);
	public abstract List<Object> getItemCollection();
	public abstract List<Object> getItemCollection(Object... criteria);
	
}
