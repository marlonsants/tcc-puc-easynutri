package com.tcc.easynutri.error;

import java.util.List;

public class ErrorResponse {
	
	private final String mensagemErro;
    private final int codigo;
    private final String status;
    private final String nomeObjeto;
    private final List<ErrorObject> erros;
    
	public ErrorResponse(String message, int code, String status, String objectName, List<ErrorObject> errors) {
		super();
		this.mensagemErro = message;
		this.codigo = code;
		this.status = status;
		this.nomeObjeto = objectName;
		this.erros = errors;
	}

	public String getMessage() {
		return mensagemErro;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getStatus() {
		return status;
	}

	public String getNomeObjeto() {
		return nomeObjeto;
	}

	public List<ErrorObject> getErros() {
		return erros;
	}

	
}
