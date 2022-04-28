package sistema.modelo.dao.avaliacao;

import java.util.List;

import sistema.modelo.entidade.avaliacao.Avaliacao;
import sistema.modelo.entidade.curso.Curso;

public interface AvaliacaoDAO {

	void inserirAvaliacao(Avaliacao avaliacao);

	void deletarAvaliacao(Avaliacao avaliacao);

	void atualizarAvaliacao(Avaliacao avaliacao);

	List<Avaliacao> avaliacoesCurso(Curso curso);

	double mediaAvaliacoesCurso(Curso curso);
}