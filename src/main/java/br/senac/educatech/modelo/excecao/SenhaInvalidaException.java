package br.senac.educatech.modelo.excecao;

public class SenhaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public SenhaInvalidaException(String mensagem) {
		super(mensagem);
	}

}