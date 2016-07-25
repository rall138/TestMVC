package com.rldevel.Entities;

import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.rldevel.Entities.Enumerators.TipoOperacion;

@Entity
@Table(name="OPERACION")
public class Operacion implements Serializable{

	private static final long serialVersionUID = -5554843914909754397L;

//	@Id
//	@Column(name="TIPOOPERACION")
//	private TipoOperacion tipoOperacion;
	
	@Id
	@Column(name="FECHA_GENERACION")
	private Date fechaGeneracion;
	
//	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	@JoinTable(name="OPERACION_ARTICULO",  
//			joinColumns={@JoinColumn(name="TIPOOPERACION"), @JoinColumn(name="FECHA_GENERACION")}, 
//			inverseJoinColumns=@JoinColumn(name="ARTICULOID"))
//	private List<Articulo> articuloColeccion;
	
	public Operacion(){}
	
//	@Enumerated(EnumType.STRING)
//	public TipoOperacion getTipoOperacion() {
//		return tipoOperacion;
//	}

//	public void setTipoOperacion(TipoOperacion tipoOperacion) {
//		this.tipoOperacion = tipoOperacion;
//	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

//	public List<Articulo> getArticuloColeccion() {
//		return articuloColeccion;
//	}
//
//	public void setArticuloColeccion(List<Articulo> articuloColeccion) {
//		this.articuloColeccion = articuloColeccion;
//	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	
	
}
