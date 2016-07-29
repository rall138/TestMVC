package com.rldevel.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rldevel.DAO.ClienteDAO;
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
	
	public List<Cliente> getItemCollection(Object... criteria){
		return this.clientedao.getItemCollection(criteria);
	}
	
}
