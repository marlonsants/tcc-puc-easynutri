package com.tcc.easynutri.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcc.easynutri.model.dto.UsuarioDTO;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario")
public class Usuario extends EntityBase {
	
	public Usuario() {
		super.setDataCriacao(new Date());
	}
		
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String senha;
		
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@JsonIgnore
	public UsuarioDTO getDto() {
		var usuarioDto = new UsuarioDTO();
		usuarioDto.setId(this.getId());
		usuarioDto.setEmail(this.email);
		usuarioDto.setSenha(senha);
		return usuarioDto;
	}
}
