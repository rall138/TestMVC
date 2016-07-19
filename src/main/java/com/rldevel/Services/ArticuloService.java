package com.rldevel.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rldevel.DAO.ArticuloDAO;
import com.rldevel.Entities.Articulo;

@Service("articuloservice")
public class ArticuloService {

	private ArticuloDAO articulodao;

	public ArticuloDAO getArticulodao() {
		return articulodao;
	}

	@Autowired
	public void setArticulodao(ArticuloDAO articulodao) {
		this.articulodao = articulodao;
	}
	
	public boolean insertArticulo(Articulo articulo){
		return articulodao.insertArticulo(articulo);
	}
	
	public boolean updateArticulo(Articulo articulo){
		return articulodao.updateArticulo(articulo);
	}
	
	public boolean deleteArticulo(Articulo articulo){
		return articulodao.deleteArticulo(articulo);
	}
	
	public List<Articulo> getArticulos(){
		return articulodao.getArticulos();
	}
}
