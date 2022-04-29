package br.com.educatech.casodeuso.inseririnstituicao;

import br.com.educatech.modelo.dao.instituicao.InstituicaoDAO;
import br.com.educatech.modelo.entidade.instituicao.Instituicao;

public class InserirInstituicaoCasoDeUso {

	private InstituicaoDAO instituicaoDAO;

	public InserirInstituicaoCasoDeUso(InstituicaoDAO instituicaoDAO) {
		this.instituicaoDAO = instituicaoDAO;
	}

	public Instituicao inserirInstituicao(Instituicao instituicao) {

		return instituicaoDAO.inserirInstituicao(instituicao);

	}

}
