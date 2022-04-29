package br.com.educatech.casodeuso.deletaravaliacao;

import br.com.educatech.modelo.dao.avaliacao.AvaliacaoDAO;
import br.com.educatech.modelo.entidade.avaliacao.Avaliacao;

public class DeletarAvaliacaoCasoDeUso {

	private AvaliacaoDAO avaliacaoDAO;

	public DeletarAvaliacaoCasoDeUso(AvaliacaoDAO avaliacaoDAO) {
		this.avaliacaoDAO = avaliacaoDAO;
	}

	public Avaliacao deletarAvaliacao(Avaliacao avaliacao) {

		return avaliacaoDAO.deletarAvaliacao(avaliacao);

	}

}
