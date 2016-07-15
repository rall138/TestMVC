package com.rldevel.ManagedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.rldevel.Entities.Articulo;
import com.rldevel.Services.ArticuloService;

@ManagedBean
public class ArticuloMB {

	@ManagedProperty(value="#{articuloservice}")
	ArticuloService articuloservice;

	Articulo articulo;
	
	public List<Articulo> getArticulos(){
		return articuloservice.getArticulos();
	}
}
