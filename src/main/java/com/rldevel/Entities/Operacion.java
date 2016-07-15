package com.rldevel.Entities;

import java.util.Date;
import java.util.List;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.rldevel.Entities.Enumerators.TipoOperacion;

@Entity
@Table(name="OPERACION")
public class Operacion {

	@Id
	private TipoOperacion tipoOperacion;
	
	@Id
	private Date fechaGeneracion;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="OPERACION_ARTICULO",  
			joinColumns={@JoinColumn(name="TIPOOPERACION"), @JoinColumn(name="FECHAGENERACION")}, 
			inverseJoinColumns=@JoinColumn(name="ARTICULOID"))
	private List<Articulo> articuloColeccion;
	
	public Operacion(TipoOperacion tipoOperacion){
		this.tipoOperacion = tipoOperacion;
		this.fechaGeneracion = Calendar.getInstance().getTime();
	}
	
	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	
}
