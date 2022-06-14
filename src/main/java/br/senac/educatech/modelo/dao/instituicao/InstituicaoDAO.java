package br.senac.educatech.modelo.dao.instituicao;

import java.util.List;

import br.senac.educatech.modelo.entidade.instituicao.Instituicao;

public interface InstituicaoDAO {

	Long inserirInstituicao(Instituicao instuicao);

	void atualizarInstituicao(Instituicao instuicao);

	void deletarInstituicao(Instituicao instuicao);

	Instituicao recuperarInstituicaoPeloId(Instituicao instituicao);
	
	Instituicao recuperarInstituicaoComAreasPeloId(Instituicao instituicao);

	List<Instituicao> recuperarInstituicoes();

}