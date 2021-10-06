package com.tcc.easynutri.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.easynutri.model.entity.Permissao;
import com.tcc.easynutri.model.repository.PermissaoRepository;
import com.tcc.easynutri.util.validacao.ValidacaoRecursoUtil;

@RestController
@RequestMapping("/permissao")
public class PermissaoController {

	@Autowired	
	private PermissaoRepository permissaoRepository;
	
	@GetMapping
	public List<Permissao> listar() {
		return permissaoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Permissao adicionar(@RequestBody Permissao permissao) throws ConstraintViolationException {
		try  {
			return permissaoRepository.save(permissao);
		} catch(ConstraintViolationException e) {
			throw new ConstraintViolationException(String.format("O permissao informado %s já existe", permissao.getNome()),e.getSQLException(), e.getConstraintName());
		}
		
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void alterar(@PathVariable("id") Long id, @RequestBody Permissao permissao) throws Exception {
		
		ValidacaoRecursoUtil.verificarSeRecursoExiste(id, permissaoRepository);
		var permissaoRetornado = permissaoRepository.findById(id);
		permissaoRetornado.get().setNome(permissao.getNome());
		permissaoRetornado.get().setPerfil(permissao.getPerfil());
		permissaoRetornado.get().setDataAlteracao(new Date());
		permissaoRepository.save(permissaoRetornado.get());
		 
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable("id") Long id) throws MissingServletRequestParameterException {
		ValidacaoRecursoUtil.verificarSeRecursoExiste(id, permissaoRepository);
		var permissaoRetornado = permissaoRepository.findById(id);
		permissaoRepository.delete(permissaoRetornado.get());
	}
	
	@GetMapping("/{id}")
	public Permissao buscarPeloId(@PathVariable("id") Long id) throws Exception {
		ValidacaoRecursoUtil.verificarSeRecursoExiste(id, permissaoRepository);
		var permissao = permissaoRepository.findById(id);
		return permissao.get();
	}
	
}
