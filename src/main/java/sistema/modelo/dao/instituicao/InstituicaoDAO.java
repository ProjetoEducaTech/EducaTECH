package sistema.modelo.dao.instituicao;

import java.util.List;

import sistema.modelo.entidade.instituicao.Instituicao;

public interface InstituicaoDAO {

	void inserirInstituicao(Instituicao instuicao);

	void deletarInstituicao(Instituicao instuicao);

	void atualizarInstituicao(Instituicao instuicao);

	List<Instituicao> recuperarInstituicoes();
	
}