package com.rldevel.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 8992605351560091859L;

	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="CONTACTO")
	private String contacto;

	@OneToMany(cascade=javax.persistence.CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="CLIENTE_ARTICULO", joinColumns=@JoinColumn(name="CLIENTE_ID"), inverseJoinColumns=@JoinColumn(name="ARTICULO_ID"))
	private List<Articulo> articulos = new ArrayList<Articulo>();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public int getId() {
		return id;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

}
