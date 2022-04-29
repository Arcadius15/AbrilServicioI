package com.idat.AbrilServicioI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.AbrilServicioI.modelo.Items;
import com.idat.AbrilServicioI.servicio.ItemServicio;

@RestController
@RequestMapping("/item/v1")
public class ItemControlador {
	
	@Autowired
	private ItemServicio servicio;
	
	@RequestMapping(path = "/listar",method = RequestMethod.GET)
	public ResponseEntity<List<Items>>  listarProducot(){
		return new ResponseEntity<List<Items>>(servicio.obtenerItems(),HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/guardar",method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Items item) {
		servicio.guardarItem(item);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Items> listarPorId(@PathVariable Integer Id) {
		Items p =  servicio.obtenerItemId(Id);
		if (p != null) {
			return new ResponseEntity<Items>(p,HttpStatus.OK);
		}else {
			return new ResponseEntity<Items>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar",method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody Items item) {
		Items p = servicio.obtenerItemId(item.getIdItem());
		if (p != null) {
			servicio.editarItem(item);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> editar(@PathVariable Integer Id) {
		Items p = servicio.obtenerItemId(Id);
		if (p != null) {
			servicio.eliminarItem(Id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
