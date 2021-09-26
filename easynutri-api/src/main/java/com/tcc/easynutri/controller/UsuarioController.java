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

import com.tcc.easynutri.model.entity.Usuario;
import com.tcc.easynutri.model.repository.UsuarioRepository;
import com.tcc.easynutri.util.validacao.ValidacaoRecursoUtil;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired	
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@RequestBody Usuario usuario) throws ConstraintViolationException {
		try  {
			return usuarioRepository.save(usuario);
		} catch(ConstraintViolationException e) {
			throw new ConstraintViolationException(String.format("O email informado %s já existe", usuario.getEmail()),e.getSQLException(), e.getConstraintName());
		}
		
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void alterar(@PathVariable("id") Long id, @RequestBody Usuario usuario) throws Exception {
		
		ValidacaoRecursoUtil.verificarSeRecursoExiste(id, usuarioRepository);
		var usuarioRetornado = usuarioRepository.findById(id);
		usuarioRetornado.get().setEmail(usuario.getEmail());
		usuarioRetornado.get().setDataAlteracao(new Date());
		usuarioRepository.save(usuarioRetornado.get());
		 
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable("id") Long id) {
		ValidacaoRecursoUtil.verificarSeRecursoExiste(id, usuarioRepository);
		var usuarioRetornado = usuarioRepository.findById(id);
		usuarioRepository.delete(usuarioRetornado.get());
	}
	
	@GetMapping("/{id}")
	public Usuario buscarPeloId(@PathVariable("id") Long id) throws Exception {
		ValidacaoRecursoUtil.verificarSeRecursoExiste(id, usuarioRepository);
		var usuario = usuarioRepository.findById(id);
		return usuario.get();
	}
	
}
