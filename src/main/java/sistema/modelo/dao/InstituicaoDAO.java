package sistema.modelo.dao;

import sistema.modelo.entidade.*;
import java.util.List;

public interface InstituicaoDAO {

	void inserirInstituicao(Instituicao instuicao);

	void deletarInstituicao(Instituicao instuicao);

	void atualizarInstituicao(Instituicao instuicao);

	List<Instituicao> recuperarInstituicoes();
}