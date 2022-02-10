package sistema.modelo.dao.instituicao;

import sistema.modelo.entidade.*;
import sistema.modelo.entidade.instituicao.Instituicao;

import java.util.List;

public interface InstituicaoDAO {

	void inserirInstituicao(Instituicao instuicao);

	void deletarInstituicao(Instituicao instuicao);

	void atualizarInstituicao(Instituicao instuicao);

	List<Instituicao> recuperarInstituicoes();
}