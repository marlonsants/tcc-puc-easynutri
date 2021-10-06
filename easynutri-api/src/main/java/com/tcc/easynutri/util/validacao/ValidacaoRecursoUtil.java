package com.tcc.easynutri.util.validacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.MissingServletRequestParameterException;

import com.tcc.easynutri.exception.RecursoNaoEncontradoException;

public class ValidacaoRecursoUtil {
	
	/**
	 * Verifica se um recurso existe e retorna uma exceção caso não exista
	 * @param id
	 * @throws MissingServletRequestParameterException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends JpaRepository> void verificarSeRecursoExiste(Long id, T entidade) throws MissingServletRequestParameterException {
		var usuario = entidade.findById(id);
		if (!usuario.isPresent()) {
			throw new MissingServletRequestParameterException(String.format("O recurso com id %d não existe", id), "teste" );
		}
	}

}
