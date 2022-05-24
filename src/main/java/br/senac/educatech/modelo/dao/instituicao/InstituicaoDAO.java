package br.senac.educatech.modelo.dao.instituicao;

import java.util.List;

import br.senac.educatech.modelo.entidade.instituicao.Instituicao;
import br.senac.educatech.modelo.entidade.usuario.Usuario;

public interface InstituicaoDAO {

	Instituicao inserirInstituicao(Instituicao instuicao);

	void atualizarInstituicao(Instituicao instuicao);

	void deletarInstituicao(Instituicao instuicao);

	Instituicao recuperarInstituicaoPeloId(Usuario usuario);

	List<Instituicao> recuperarInstituicoes();

}
