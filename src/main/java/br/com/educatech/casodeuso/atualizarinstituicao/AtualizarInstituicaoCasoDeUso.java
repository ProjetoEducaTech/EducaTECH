package br.com.educatech.casodeuso.atualizarinstituicao;

import br.com.educatech.modelo.dao.instituicao.InstituicaoDAO;
import br.com.educatech.modelo.entidade.instituicao.Instituicao;

public class AtualizarInstituicaoCasoDeUso {

	private InstituicaoDAO instituicaoDAO;

	public AtualizarInstituicaoCasoDeUso(InstituicaoDAO instituicaoDAO) {
		this.instituicaoDAO = instituicaoDAO;
	}

	public Instituicao atualizarInstituicao(Instituicao instituicao) {

		return instituicaoDAO.atualizarInstituicao(instituicao);

	}

}
