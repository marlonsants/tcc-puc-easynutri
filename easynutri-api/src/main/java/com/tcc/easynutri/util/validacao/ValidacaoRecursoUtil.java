package com.tcc.easynutri.util.validacao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.easynutri.exception.RecursoNaoEncontradoException;

public class ValidacaoRecursoUtil {
	
	/**
	 * Verifica se um recurso existe e retorna uma exceção caso não exista
	 * @param id
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends JpaRepository> void verificaSeRecursoExiste(Long id, T entidade) {
		var usuario = entidade.findById(id);
		if (!usuario.isPresent()) {
			throw new RecursoNaoEncontradoException(String.format("O recurso com id %d não existe", id) );
		}
	}

}
