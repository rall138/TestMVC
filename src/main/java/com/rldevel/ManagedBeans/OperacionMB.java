package com.rldevel.ManagedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.rldevel.Services.OperacionService;

@ManagedBean(name="operacionMB")
@SessionScoped
public class OperacionMB {

	@ManagedProperty(value="#{operacionservice}")
	private OperacionService operacionservice;
	
	public OperacionMB(){}
	
}
