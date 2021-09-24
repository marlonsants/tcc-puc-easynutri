package com.tcc.easynutri.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNaoEncontradoException extends RuntimeException {
	public RecursoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}
