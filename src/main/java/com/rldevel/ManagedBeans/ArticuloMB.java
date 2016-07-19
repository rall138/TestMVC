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

import com.rldevel.Entities.Articulo;
import com.rldevel.Services.ArticuloService;

@ManagedBean(name="articuloMB")
@SessionScoped
public class ArticuloMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{articuloservice}")
	private ArticuloService articuloservice;

	private Articulo selectedArticulo;
	private List<Articulo> articulos;
	private String mode;
		
	public ArticuloMB(){
		this.selectedArticulo = new Articulo();
		this.mode = new String();
		this.articulos = new ArrayList<Articulo>();
	}
	
	public List<Articulo> getArticulos(){
		articulos = articuloservice.getArticulos();
		return articulos;
	}

	public Articulo getSelectedArticulo() {
		return selectedArticulo;
	}

	public void setSelectedArticulo(Articulo selectedArticulo) {
		this.selectedArticulo = selectedArticulo;
	}

	public ArticuloService getArticuloservice() {
		return articuloservice;
	}

	public void setArticuloservice(ArticuloService articuloservice) {
		this.articuloservice = articuloservice;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public void clearArticulo(){
		this.selectedArticulo = new Articulo();
	}
	
	public void dialogConfirm(){
		if (mode.equalsIgnoreCase("insert")){
			this.insertArticulo();
		}else if (mode.equalsIgnoreCase("update")){
			this.updateArticulo();
		}else if (mode.equalsIgnoreCase("delete")){
			this.deleteArticulo();
		}
	}
	
	private void insertArticulo(){
		if (this.articuloservice.insertArticulo(this.selectedArticulo)){
			deployMessage("Articulo añadido con éxito");
		}else{
			deployMessage("Ha ocurrido un error al añadir el registro", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	private void updateArticulo(){
		if (this.articuloservice.updateArticulo(this.selectedArticulo)){
			deployMessage("Articulo modificado con éxito");
		}else{
			deployMessage("Ha ocurrido un error al actualizar el registro", FacesMessage.SEVERITY_ERROR);
		}
	}

	private void deleteArticulo(){
		if (this.articuloservice.deleteArticulo(this.selectedArticulo)){
			deployMessage("Articulo eliminado con éxito");
		}else{
			deployMessage("Ha ocurrido un error al eliminar el registro", FacesMessage.SEVERITY_ERROR);
		}
	}
	
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