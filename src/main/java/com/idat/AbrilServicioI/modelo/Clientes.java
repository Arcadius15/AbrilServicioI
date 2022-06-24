package com.idat.AbrilServicioI.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1063644946794342032L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	@Column
	private String celular;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	@ManyToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Productos> productos = new ArrayList<Productos>();
	
	@OneToMany(mappedBy = "cliente")
	private List<Items> item =new ArrayList<Items>();
	public List<Productos> getProductos() {
		return productos;
	}
	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}
	public List<Items> getItem() {
		return item;
	}
	public void setItem(List<Items> item) {
		this.item = item;
	}
	
	
	
	

}
