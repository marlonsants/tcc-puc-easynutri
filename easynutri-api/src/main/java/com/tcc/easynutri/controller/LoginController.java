package com.tcc.easynutri.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.easynutri.model.dto.UsuarioDTO;
import com.tcc.easynutri.model.repository.UsuarioRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired	
	private UsuarioRepository usuarioRepository;
		
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Boolean> login(@RequestBody  @Valid UsuarioDTO usuarioDto) throws MissingServletRequestParameterException {
		var encoder = new BCryptPasswordEncoder();
		var usuarioRetornado = usuarioRepository.findFirstByEmail(usuarioDto.getEmail());
		
		if(usuarioRetornado == null) {
			throw new MissingServletRequestParameterException(String.format("E-mail incorreto, verifique e tente novamente"), "teste" );
		}
		
		boolean senhaCorreta = encoder.matches(usuarioDto.getSenha(), usuarioRetornado.getSenha());
		if (!senhaCorreta) {
			throw new MissingServletRequestParameterException(String.format("Senha incorreta, verifique e tente novamente"), "teste" );
		}
		
		return new ResponseEntity<Boolean>(true,HttpStatus.CREATED);
	}
	
	
			
}
