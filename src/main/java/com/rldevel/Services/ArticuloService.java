package com.rldevel.Services;

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
	
	public void insertArticulo(Articulo articulo){
		articulodao.insertArticulo(articulo);
	}
	
	public void updateArticulo(Articulo articulo){
		articulodao.updateArticulo(articulo);
	}
	
	public void deleteArticulo(Articulo articulo){
		articulodao.deleteArticulo(articulo);
	}
}
