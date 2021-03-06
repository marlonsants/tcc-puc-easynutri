package com.tcc.easynutri.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcc.easynutri.model.entity.Usuario;

@SuppressWarnings("serial")
public class UsuarioDTO extends DtoBase {
	
	@NotBlank(message =  "{email.not.blank}")
	@Email(message =  "{email.not.valid}")
	private String email;
	
	@NotBlank(message =  "{senha.not.blank}")
	@Length(min = 6, message = "{senha.min}")
	private String senha;
		
	private String nome;
	
	private String telefone;
	
	private String celular;
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
		
	public String getEmail() {
		return email;
	}
		
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonIgnore
	public Usuario getEntity() {
		var usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setNome(nome);
		usuario.setTelefone(telefone);
		usuario.setCelular(celular);
		return usuario;
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
