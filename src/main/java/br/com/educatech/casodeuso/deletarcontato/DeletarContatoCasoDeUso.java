package br.com.educatech.casodeuso.deletarcontato;

import br.com.educatech.modelo.dao.contato.ContatoDAO;
import br.com.educatech.modelo.entidade.contato.Contato;

public class DeletarContatoCasoDeUso {

	private ContatoDAO contatoDAO;

	public DeletarContatoCasoDeUso(ContatoDAO contatoDAO) {
		this.contatoDAO = contatoDAO;
	}

	public Contato deletarContato(Contato contato) {

		return contatoDAO.deletarContato(contato);

	}

}
