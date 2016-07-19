package com.rldevel.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ARTICULO")
public class Articulo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
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
	
	public Articulo(){
		
	}
	
	public Articulo(String marca, String nombre, String numeroSerie, 
			String diagnostico, String comentario){
		this.marca = marca;
		this.nombre = nombre;
		this.numeroSerie = numeroSerie;
		this.diagnostico = diagnostico;
		this.comentario = comentario;
	}
	
	public int getId() {
		return id;
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
	
	
	
}
