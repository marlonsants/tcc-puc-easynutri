package com.tcc.easynutri.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name="perfil")
public class Perfil extends EntityBase {
	
	@Column(unique = true)
	private String nome;
	
	private String descricao;
	
	@OneToMany(mappedBy = "perfil", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Permissao> listaPermissao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Permissao> getListaPermissao() {
		return listaPermissao;
	}
	public void setListaPermissao(List<Permissao> listaPermissao) {
		this.listaPermissao = listaPermissao;
	}
	
}
