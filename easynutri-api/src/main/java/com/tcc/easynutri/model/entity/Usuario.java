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
	
	@Column(nullable = false)
	private String nome;
	
	private String telefone;
	
	private String celular;
		
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
		usuarioDto.setEmail(email);
		usuarioDto.setSenha(senha);
		usuarioDto.setNome(nome);
		usuarioDto.setTelefone(telefone);
		usuarioDto.setCelular(celular);
		return usuarioDto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
}
