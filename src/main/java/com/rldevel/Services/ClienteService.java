package com.rldevel.Services;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rldevel.DAO.ClienteDAO;
import com.rldevel.DAO.Interfaces.ICommonDAO;
import com.rldevel.Entities.Articulo;
import com.rldevel.Entities.Cliente;

@Service("clienteservice")
public class ClienteService implements Serializable{

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
		
		//Prueba
		Articulo art1, art2, art3;
		art1 = new Articulo();
		art1.setMarca("MARC1");
		art1.setNombre("Nomb1");
		art1.setNumeroSerie("11122");
		art1.setCliente(cliente);
		
		art2 = new Articulo();
		art2.setMarca("MARC2");
		art2.setNombre("Nomb2");
		art2.setNumeroSerie("2233");
		art2.setCliente(cliente);

		art3 = new Articulo();
		art3.setMarca("MARC3");
		art3.setNombre("Nomb3");
		art3.setNumeroSerie("3344");
		art3.setCliente(cliente);
		
		cliente.getArticulos().add(art1);
		cliente.getArticulos().add(art2);
		cliente.getArticulos().add(art3);

		Transaction transaction = null;
		transaction = this.clientedao.getSessionFactory().getCurrentSession().beginTransaction();
		this.clientedao.getSessionFactory().getCurrentSession().save(cliente);
		for(Articulo articulo : cliente.getArticulos()){
			this.clientedao.getSessionFactory().getCurrentSession().save(articulo);
		}
		transaction.commit();
		return transaction.wasCommitted();
	}

	public List<Cliente> getItemCollection() {
		return this.clientedao.getItemCollection();
	}
	
}
