package com.idat.AbrilServicioI.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.AbrilServicioI.dto.ProductoDTORequest;
import com.idat.AbrilServicioI.dto.ProductoDTOResponse;
import com.idat.AbrilServicioI.modelo.Productos;
import com.idat.AbrilServicioI.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoServicio{
	
	@Autowired
	public ProductoRepositorio repositorio;

	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		
		Productos p = new Productos();
		p.setNombreProducto(producto.getNombreProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		repositorio.save(p);
		
	}

	@Override
	public void editarProducto(ProductoDTORequest producto) {
		Productos p = new Productos();
		p.setIdProducto(producto.getIdProductoDTO());
		p.setNombreProducto(producto.getNombreProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		repositorio.saveAndFlush(p);
		
	}

	@Override
	public void eliminarProducto(Integer idProducto) {
		// TODO Auto-generated method stub
		repositorio.deleteById(idProducto);
		
	}

	@Override
	public List<ProductoDTOResponse> obtenerProductos() {
		List<ProductoDTOResponse> lista = new ArrayList<ProductoDTOResponse>();
		ProductoDTOResponse res =  new ProductoDTOResponse();
		for (Productos p : repositorio.findAll()) {
			res.setIdProductoDTO(p.getIdProducto());
			res.setNombreProductoDTO(p.getNombreProducto());
			res.setDescripcionDTO(p.getDescripcion());
			res.setPrecioDTO(p.getPrecio());
			res.setStockDTO(p.getStock());
			lista.add(res);
		}
		return lista;
	}

	@Override
	public ProductoDTOResponse obtenerProductoId(Integer idProducto) {
		// TODO Auto-generated method stub
		Productos p = repositorio.findById(idProducto).orElse(null);
		ProductoDTOResponse res =  new ProductoDTOResponse();
		res.setIdProductoDTO(p.getIdProducto());
		res.setNombreProductoDTO(p.getNombreProducto());
		res.setDescripcionDTO(p.getDescripcion());
		res.setPrecioDTO(p.getPrecio());
		res.setStockDTO(p.getStock());
		return res;
	}

}
