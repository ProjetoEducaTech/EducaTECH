package br.com.educatech.casodeuso.inserircontato;

import br.com.educatech.modelo.dao.contato.ContatoDAO;
import br.com.educatech.modelo.entidade.contato.Contato;

public class InserirContatoCasoDeUso {

	private ContatoDAO contatoDAO;

	public InserirContatoCasoDeUso(ContatoDAO contatoDAO) {
		this.contatoDAO = contatoDAO;
	}

	public Contato inserirContato(Contato contato) {

		return contatoDAO.inserirContato(contato);

	}

}
