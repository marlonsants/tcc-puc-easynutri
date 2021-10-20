package com.tcc.easynutri.error;

public class ErrorObject {
	private final  String mensagem;
    private final  String campo;
    private final  Object parametro;
    
	public ErrorObject(String message, String field, Object parameter) {
		super();
		this.mensagem = message;
		this.campo = field;
		this.parametro = parameter;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public Object getParametro() {
		return parametro;
	}
	
	
    
}
