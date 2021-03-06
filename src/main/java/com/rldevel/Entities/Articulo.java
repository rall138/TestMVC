package com.rldevel.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ARTICULO")
public class Articulo implements Serializable{

	private static final long serialVersionUID = -911274213771748253L;

	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id;
	
	@Column(name="MARCA")
	private String marca;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="NUMERO_SERIE")
	private String numeroSerie;

	@Column(name="DIAGNOSTICO")
	private String diagnostico;

	@Column(name="COMENTARIO")
	private String comentario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CLIENTE_ID", nullable=false)
	private Cliente cliente;
	
	@Transient
	private boolean readyForDelete = false;
	
	public Articulo(){}
	
	public Articulo(String marca, String nombre, String numeroSerie, 
			String diagnostico, String comentario, Cliente cliente){
		this.marca = marca;
		this.nombre = nombre;
		this.numeroSerie = numeroSerie;
		this.diagnostico = diagnostico;
		this.comentario = comentario;
	}
		
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isReadyForDelete() {
		return readyForDelete;
	}

	public void setReadyForDelete(boolean readyForDelete) {
		this.readyForDelete = readyForDelete;
	}
	
}
