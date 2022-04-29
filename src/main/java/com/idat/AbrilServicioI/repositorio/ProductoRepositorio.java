package com.idat.AbrilServicioI.repositorio;

import java.util.List;

import com.idat.AbrilServicioI.modelo.Productos;

public interface ProductoRepositorio {
	
	public void guardarProducto(Productos producto);
	public void editarProducto(Productos producto);
	public void eliminarProducto(Integer idProducto);
	public List<Productos> obtenerProductos();
	public Productos obtenerProductoId(Integer idProducto);
	
}
