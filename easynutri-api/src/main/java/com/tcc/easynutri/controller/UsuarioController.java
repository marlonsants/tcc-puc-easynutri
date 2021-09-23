package com.tcc.easynutri.controller;

import java.util.List;

import javax.xml.bind.ValidationException;

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

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired	
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void alterar(@PathVariable("id") Long id, @RequestBody Usuario usuario) throws Exception {
		var usuarioRetornado = usuarioRepository.findById(id);
		if (usuarioRetornado.isPresent()) {
			usuarioRetornado.get().setNome(usuario.getNome());
			usuarioRepository.save(usuario);
		} else {
			throw new Exception("O usuário informado não existe");
		}
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@RequestBody Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	@GetMapping("/{id}")
	public Usuario buscarPeloId(@PathVariable("id") Long id) throws Exception {
		var usuario = usuarioRepository.findById(id);
		
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new Exception("O usuário informado não existe");
		}

	}
	
}
