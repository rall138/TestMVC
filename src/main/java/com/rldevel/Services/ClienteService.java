package com.rldevel.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rldevel.DAO.ClienteDAO;
import com.rldevel.Entities.Articulo;
import com.rldevel.Entities.Cliente;

@Service("clienteservice")
public class ClienteService implements Serializable{

	private static final long serialVersionUID = 2892060095168512078L;

	private ClienteDAO clientedao;

	public ClienteService(){}

	public ClienteDAO getClientedao() {
		return clientedao;
	}

	@Autowired
	public void setClientedao(ClienteDAO clientedao) {
		this.clientedao = clientedao;
	}

	
	public boolean insert(Cliente cliente) {
		cliente.getArticulos().clear();
		//Prueba
		Articulo art1, art2, art3;
		art1 = new Articulo();
		art1.setMarca("MARC1");
		art1.setNombre("Nomb1");
		art1.setNumeroSerie("11122");
		
		art2 = new Articulo();
		art2.setMarca("MARC2");
		art2.setNombre("Nomb2");
		art2.setNumeroSerie("2233");

		art3 = new Articulo();
		art3.setMarca("MARC3");
		art3.setNombre("Nomb3");
		art3.setNumeroSerie("3344");
		
		cliente.getArticulos().add(art1);
		cliente.getArticulos().add(art2);
		cliente.getArticulos().add(art3);
		return this.getClientedao().insert(cliente);
	}
	
	public boolean update(Cliente cliente){
		return this.getClientedao().update(cliente);
	}
	
	public boolean delete(Cliente cliente){
		return this.getClientedao().delete(cliente);
	}

	public List<Cliente> getItemCollection() {
		return this.clientedao.getItemCollection();
	}
	
}
