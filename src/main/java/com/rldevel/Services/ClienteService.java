package com.rldevel.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rldevel.DAO.ClienteDAO;
import com.rldevel.Entities.Cliente;

@Service("clienteservice")
public class ClienteService {

	private ClienteDAO clientedao;

	public ClienteService(){}

	public List<Cliente> getClientes(String nombre){
		return clientedao.getClientes(nombre);
	}
	
	public boolean insertCliente(Cliente cliente){
		return clientedao.insertCliente(cliente);
	}
	
	public boolean updateCliente(Cliente cliente){
		return clientedao.updateCliente(cliente);
	}
	
	public boolean deleteCliente(Cliente cliente){
		return clientedao.deleteCliente(cliente);
	}
	
	public ClienteDAO getClientedao() {
		return clientedao;
	}

	@Autowired
	public void setClientedao(ClienteDAO clientedao) {
		this.clientedao = clientedao;
	}
	
}
