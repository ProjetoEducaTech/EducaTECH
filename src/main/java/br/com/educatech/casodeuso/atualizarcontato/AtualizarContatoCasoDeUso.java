package br.com.educatech.casodeuso.atualizarcontato;

import br.com.educatech.modelo.dao.contato.ContatoDAO;
import br.com.educatech.modelo.entidade.contato.Contato;

public class AtualizarContatoCasoDeUso {

	private ContatoDAO contatoDAO;

	public AtualizarContatoCasoDeUso(ContatoDAO contatoDAO) {
		this.contatoDAO = contatoDAO;
	}

	public Contato atualizarContato(Contato contato) {

		return contatoDAO.atualizarContato(contato);

	}

}
