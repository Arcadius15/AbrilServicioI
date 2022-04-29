package com.idat.AbrilServicioI.repositorio;

import java.util.List;

import com.idat.AbrilServicioI.modelo.Items;

public interface ItemRepositorio {
	public void guardarItem(Items item);
	public void editarItem(Items item);
	public void eliminarItem(Integer idItem);
	public List<Items> obtenerItems();
	public Items obtenerItemId(Integer idItem);
	

}
