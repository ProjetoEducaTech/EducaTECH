package br.com.educatech.casodeuso.inseriravaliacao;

import br.com.educatech.modelo.dao.avaliacao.AvaliacaoDAO;
import br.com.educatech.modelo.entidade.avaliacao.Avaliacao;

public class InserirAvaliacaoCasoDeUso {

	private AvaliacaoDAO avaliacaoDAO;

	public InserirAvaliacaoCasoDeUso(AvaliacaoDAO avaliacaoDAO) {
		this.avaliacaoDAO = avaliacaoDAO;
	}

	public Avaliacao inserirAvaliacao(Avaliacao avaliacao) {

		return avaliacaoDAO.inserirAvaliacao(avaliacao);

	}

}
