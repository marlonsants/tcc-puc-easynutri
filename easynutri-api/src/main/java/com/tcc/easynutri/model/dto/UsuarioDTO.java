package com.tcc.easynutri.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		return usuario;
	}
}
