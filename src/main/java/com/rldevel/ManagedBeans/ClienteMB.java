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
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import com.rldevel.Entities.Articulo;
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
	private List<Articulo> articulos_auxiliares = new ArrayList<Articulo>();
	
	//Articulos para eliminar
	private List<Articulo> articulos_eliminar = new ArrayList<Articulo>();
	
	private Cliente selectedCliente = new Cliente();
	private Articulo selectedArticulo = new Articulo();
	private String mode = new String();
	
	public ClienteMB(){}
	
	public void clearCliente(){
		this.setSelectedCliente(new Cliente());
		articulos_auxiliares = this.getSelectedCliente().getArticulos();
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
		if (this.selectedCliente != null)
			this.articulos_auxiliares = selectedCliente.getArticulos();
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
	
	public List<Articulo> getArticulos_auxiliares() {
		return articulos_auxiliares;
	}

	public void setArticulos_auxiliares(List<Articulo> articulos_auxiliares) {
		this.articulos_auxiliares = articulos_auxiliares;
	}
	
	public Articulo getSelectedArticulo() {
		return selectedArticulo;
	}

	public void setSelectedArticulo(Articulo selectedArticulo) {
		this.selectedArticulo = selectedArticulo;
	}
	
	public List<Articulo> getArticulos_eliminar() {
		return articulos_eliminar;
	}

	public void setArticulos_eliminar(List<Articulo> articulos_eliminar) {
		this.articulos_eliminar = articulos_eliminar;
	}

	public boolean isArticuloReadyForDelete(Articulo articulo) {
		for (Articulo art: articulos_eliminar){
			if (art.getId()==articulo.getId()){
				return true;
			}
		}
		return false;
	}

	public void dialogConfirm(){
		if (mode.equalsIgnoreCase("insert")){
			this.insertCliente();
		}else if (mode.equalsIgnoreCase("update")){
			this.updateCliente();
		}else if (mode.equalsIgnoreCase("delete")){
			this.deleteCliente();
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
	
	private void updateCliente() {
		this.removeArticulos();
		this.selectedCliente.setArticulos(articulos_auxiliares);
		if (this.clienteservice.update(this.selectedCliente)){
			deployMessage("Cliente actualizado exitosamente");
		}else{
			deployMessage("Ha ocurrido un error al actualizar el registro", 
					FacesMessage.SEVERITY_ERROR);
		}
	}

	public void deleteCliente() {
		this.selectedCliente.setArticulos(articulos_auxiliares);		
		if (this.clienteservice.delete(this.selectedCliente)){
			deployMessage("Cliente eliminado exitosamente");
		}else{
			deployMessage("Ha ocurrido un error al eliminar el registro", 
					FacesMessage.SEVERITY_ERROR);
		}
	}

	private void deployMessage(String strMessage){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(strMessage);
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		context.addMessage(null, message);
	}
	
	private void deployMessage(String strMessage, Severity severity){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(strMessage);
		message.setSeverity(severity);
		context.addMessage(null, message);
	}

	public void seleccionFila(SelectEvent event){
		this.setSelectedCliente((Cliente)event.getObject());
	}
	
	public void agregarRegistro(ActionEvent event){
		Articulo auxiliar = new Articulo();
		auxiliar.setCliente(this.selectedCliente);
		this.articulos_auxiliares.add(auxiliar);
	}
	
	public void markArticuloForDelete(Articulo articulo){
		if (!isArticuloReadyForDelete(articulo)){
			this.articulos_eliminar.add(articulo);
		}
	}
	
	private void removeArticulos(){
		this.articulos_auxiliares.removeAll(this.articulos_eliminar);
	}

}
