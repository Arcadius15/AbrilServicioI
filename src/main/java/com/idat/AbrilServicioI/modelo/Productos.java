package com.idat.AbrilServicioI.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;


@Table(name = "productos")
@Entity
public class Productos implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -101026544387010393L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	private String nombreProducto;
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	
	public Productos() {
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	@OneToOne(mappedBy = "producto")
	private Proveedores proveedor;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
		name="producto_cliente",
		joinColumns =
			@JoinColumn(
					name="id_cliente", 
					nullable = false, 
					unique = true, 
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente) references clientes (id_cliente)")),
			
		inverseJoinColumns = 
			@JoinColumn(
					name="id_producto", 
					nullable = false, 
					unique = true, 
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto) references Productos (id_producto)"))
	)
	private List<Clientes> cliente = new ArrayList<Clientes>();


	public Proveedores getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedores proveedor) {
		this.proveedor = proveedor;
	}
	public List<Clientes> getCliente() {
		return cliente;
	}
	public void setCliente(List<Clientes> cliente) {
		this.cliente = cliente;
	}
	
	
	
	

}
