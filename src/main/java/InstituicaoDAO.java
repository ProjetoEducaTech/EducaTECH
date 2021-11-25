import java.util.List;

public interface InstituicaoDAO {

	void inserirInstituicao(Instituicao instuicao);

	void deletarInstituicao(Instituicao instuicao);

	void atualizarNomeInstituicao(Instituicao instuicao, String nome);

	Instituicao recuperarInstituicao(Instituicao instituicao);

	List<Instituicao> recuperarInstituicoes();
}