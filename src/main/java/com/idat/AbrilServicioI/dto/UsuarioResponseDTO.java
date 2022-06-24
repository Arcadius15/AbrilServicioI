package com.idat.AbrilServicioI.dto;

public class UsuarioResponseDTO {

	private String token;

	
	public UsuarioResponseDTO() {
	}

	public UsuarioResponseDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
