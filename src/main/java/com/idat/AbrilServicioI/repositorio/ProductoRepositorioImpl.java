package com.idat.AbrilServicioI.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idat.AbrilServicioI.modelo.Productos;

@Repository
public class ProductoRepositorioImpl implements ProductoRepositorio{
	
	public List<Productos> listar = new ArrayList<>();

	@Override
	public void guardarProducto(Productos producto) {
		// TODO Auto-generated method stub
		listar.add(producto);
	}

	@Override
	public void editarProducto(Productos producto) {
		// TODO Auto-generated method stub
		listar.remove(obtenerProductoId(producto.getIdProducto()));
		listar.add(producto);
		
	}

	@Override
	public void eliminarProducto(Integer idProducto) {
		// TODO Auto-generated method stub
		listar.remove(obtenerProductoId(idProducto));
		
	}

	@Override
	public List<Productos> obtenerProductos() {
		// TODO Auto-generated method stub
		return listar;
	}

	@Override
	public Productos obtenerProductoId(Integer idProducto) {
		// TODO Auto-generated method stub
		return listar.stream().filter(x -> x.getIdProducto() == idProducto).findFirst().orElse(null);
	}

}
