package br.com.educatech.modelo.dao.instituicao;

import java.util.List;

import br.com.educatech.modelo.entidade.instituicao.Instituicao;

public interface InstituicaoDAO {

	Instituicao inserirInstituicao(Instituicao instuicao);

	Instituicao atualizarInstituicao(Instituicao instuicao);

	void deletarInstituicao(Instituicao instuicao);

	Instituicao loginUsuarioInstituicao(Long id);

	List<Instituicao> recuperarInstituicao();

}
