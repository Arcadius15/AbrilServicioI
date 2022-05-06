package com.idat.AbrilServicioI.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idat.AbrilServicioI.modelo.Items;

@Repository
public class ItemRepositorioImpl implements ItemRepositorio{
	
	public List<Items> listar = new ArrayList<>();

	@Override
	public void guardarItem(Items item) {
		// TODO Auto-generated method stub
		listar.add(item);
	}

	@Override
	public void editarItem(Items item) {
		// TODO Auto-generated method stub
		listar.remove(obtenerItemId(item.getIdItem()));
		listar.add(item);
		
	}

	@Override
	public void eliminarItem(Integer idItem) {
		// TODO Auto-generated method stub
		listar.remove(obtenerItemId(idItem));
	}

	@Override
	public List<Items> obtenerItems() {
		// TODO Auto-generated method stub
		return listar;
	}

	@Override
	public Items obtenerItemId(Integer idItem) {
		// TODO Auto-generated method stub
		return listar.stream().filter(x -> x.getIdItem() == idItem).findFirst().orElse(null);
	}

}
