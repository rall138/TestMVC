package com.rldevel.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.rldevel.Entities.Cliente;
import com.rldevel.Services.ClienteService;

@ManagedBean(name="clienteMB")
@SessionScoped
public class ClienteMB implements Serializable{

	private static final long serialVersionUID = -5915349057842046942L;

	@ManagedProperty(value="#{clienteservice}")	
	private ClienteService clienteservice;
		
	private String filteredNombre = new String();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private Cliente selectedCliente = new Cliente();
	private String mode = new String();
	
	public ClienteMB(){}
	
	public void clearCliente(){
		selectedCliente = new Cliente();
	}
	
	public List<Cliente> getClientes() {
		this.clientes = this.clienteservice.getItemCollection();
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getSelectedCliente() {
		return selectedCliente;
	}

	public void setSelectedCliente(Cliente selectedCliente) {
		this.selectedCliente = selectedCliente;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getFilteredNombre() {
		return filteredNombre;
	}

	public void setFilteredNombre(String filteredNombre) {
		this.filteredNombre = filteredNombre;
	}
	
	public ClienteService getClienteservice() {
		return clienteservice;
	}

	public void setClienteservice(ClienteService clienteservice) {
		this.clienteservice = clienteservice;
	}

	public void dialogConfirm(){
		if (mode.equalsIgnoreCase("insert")){
			this.insertCliente();
		}else if (mode.equalsIgnoreCase("update")){
//			this.updateCliente();
//		}else if (mode.equalsIgnoreCase("delete")){
//			this.deleteCliente();
		}
	}

	private void insertCliente() {
		if (this.clienteservice.insert(this.selectedCliente)){
			deployMessage("Cliente generado exitosamente");
		}else{
			deployMessage("Ha ocurrido un error al generar el registro", 
					FacesMessage.SEVERITY_ERROR);
		}
	}
	
//	private void updateCliente() {
//		if (this.clienteservice.update(this.selectedCliente)){
//			deployMessage("Cliente actualizado con éxito");
//		}else{
//			deployMessage("Ha ocurrido un error al actualizar el registro", 
//					FacesMessage.SEVERITY_ERROR);
//		}
//	}
//
//	private void deleteCliente() {
//		if (this.clienteservice.delete(this.selectedCliente)){
//			deployMessage("Cliente eliminado con éxito");
//		}else{
//			deployMessage("Ha ocurrido un error al eliminar el registro", 
//					FacesMessage.SEVERITY_ERROR);
//		}
//	}

	private void deployMessage(String strMessage){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(strMessage);
		context.addMessage(null, message);
	}
	
	private void deployMessage(String strMessage, Severity severity){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(strMessage);
		message.setSeverity(severity);
		context.addMessage(null, message);
	}

	
	
}
