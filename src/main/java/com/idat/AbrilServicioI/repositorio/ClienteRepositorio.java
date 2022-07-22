package com.idat.AbrilServicioI.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.idat.AbrilServicioI.modelo.Clientes;

@RepositoryRestResource(path = "cliente")
public interface ClienteRepositorio extends JpaRepository<Clientes, Integer>{

	
}
