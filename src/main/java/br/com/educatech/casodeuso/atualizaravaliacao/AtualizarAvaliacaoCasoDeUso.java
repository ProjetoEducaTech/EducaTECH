package br.com.educatech.casodeuso.atualizaravaliacao;

import br.com.educatech.modelo.dao.avaliacao.AvaliacaoDAO;
import br.com.educatech.modelo.entidade.avaliacao.Avaliacao;

public class AtualizarAvaliacaoCasoDeUso {

	private AvaliacaoDAO avaliacaoDAO;

	public AtualizarAvaliacaoCasoDeUso(AvaliacaoDAO avaliacaoDAO) {
		this.avaliacaoDAO = avaliacaoDAO;
	}

	public Avaliacao atualizarAvaliacao(Avaliacao avaliacao) {

		return avaliacaoDAO.atualizarAvaliacao(avaliacao);

	}

}
