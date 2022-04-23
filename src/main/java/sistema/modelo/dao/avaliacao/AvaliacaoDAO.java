package sistema.modelo.dao.avaliacao;

import sistema.modelo.entidade.avaliacao.Avaliacao;

public interface AvaliacaoDAO {

	void inserirAvaliacao(Avaliacao avaliacao);

	void deletarAvaliacao(Avaliacao avaliacao);

	void atualizarAvaliacao(Avaliacao avaliacao);

}