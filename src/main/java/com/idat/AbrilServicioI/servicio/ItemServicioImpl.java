package com.idat.AbrilServicioI.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.AbrilServicioI.modelo.Items;
import com.idat.AbrilServicioI.repositorio.ItemRepositorio;

public class ItemServicioImpl implements ItemServicio{
	
	@Autowired
	public ItemRepositorio repositorio;

	@Override
	public void guardarItem(Items item) {
		// TODO Auto-generated method stub
		repositorio.guardarItem(item);
	}

	@Override
	public void editarItem(Items item) {
		// TODO Auto-generated method stub
		repositorio.editarItem(item);
	}

	@Override
	public void eliminarItem(Integer idItem) {
		// TODO Auto-generated method stub
		repositorio.eliminarItem(idItem);
	}

	@Override
	public List<Items> obtenerItems() {
		// TODO Auto-generated method stub
		return repositorio.obtenerItems();
	}

	@Override
	public Items obtenerItemId(Integer idItem) {
		// TODO Auto-generated method stub
		return repositorio.obtenerItemId(idItem);
	}

}
