package com.idat.AbrilServicioI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.AbrilServicioI.dto.UsuarioRequestDTO;
import com.idat.AbrilServicioI.dto.UsuarioResponseDTO;
import com.idat.AbrilServicioI.seguridad.JwtUtil;
import com.idat.AbrilServicioI.seguridad.UserDetailService;

@RestController
public class UsuarioController {

	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserDetailService service;
	
	@PostMapping("/crearToken")
	public ResponseEntity<?> crearToken(@RequestBody UsuarioRequestDTO dto){
		UserDetails detail = service.loadUserByUsername(dto.getUsername());
		return ResponseEntity.ok(new UsuarioResponseDTO(util.generateToken(detail.getUsername())));
	}
}

