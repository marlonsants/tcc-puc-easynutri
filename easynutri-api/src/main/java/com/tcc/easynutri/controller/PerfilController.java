package com.tcc.easynutri.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.easynutri.model.entity.Perfil;
import com.tcc.easynutri.model.repository.PerfilRepository;
import com.tcc.easynutri.util.validacao.ValidacaoRecursoUtil;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired	
	private PerfilRepository perfilRepository;
	
	@GetMapping
	public List<Perfil> listar() {
		return perfilRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Perfil adicionar(@RequestBody Perfil perfil) throws ConstraintViolationException {
		try  {
			return perfilRepository.save(perfil);
		} catch(ConstraintViolationException e) {
			throw new ConstraintViolationException(String.format("O perfil informado %s já existe", perfil.getNome()),e.getSQLException(), e.getConstraintName());
		}
		
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void alterar(@PathVariable("id") Long id, @RequestBody Perfil perfil) throws Exception {
		
		ValidacaoRecursoUtil.verificarSeRecursoExiste(id, perfilRepository);
		var perfilRetornado = perfilRepository.findById(id);
		perfilRetornado.get().setNome(perfil.getNome());
		perfilRetornado.get().setDescricao(perfil.getDescricao());
		perfilRetornado.get().setDataAlteracao(new Date());
		perfilRepository.save(perfilRetornado.get());
		 
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable("id") Long id) {
		ValidacaoRecursoUtil.verificarSeRecursoExiste(id, perfilRepository);
		var perfilRetornado = perfilRepository.findById(id);
		perfilRepository.delete(perfilRetornado.get());
	}
	
	@GetMapping("/{id}")
	public Perfil buscarPeloId(@PathVariable("id") Long id) throws Exception {
		ValidacaoRecursoUtil.verificarSeRecursoExiste(id, perfilRepository);
		var perfil = perfilRepository.findById(id);
		
		return perfil.get();
	}
	
}
