package br.com.educatech.casodeuso.recuperarporinstituicao;

import java.util.List;

import br.com.educatech.modelo.dao.instituicao.InstituicaoDAO;
import br.com.educatech.modelo.entidade.instituicao.Instituicao;

public class RecuperarPorInstituicaoCasoDeUso {

	private InstituicaoDAO instituicaoDAO;

	public void RecuperarInstituicaoCasoDeUso(InstituicaoDAO instituicaoDAO) {
		this.instituicaoDAO = instituicaoDAO;
	}

	public List<Instituicao> recuperarInstituicao() {

		return instituicaoDAO.recuperarInstituicao();

	}

}
