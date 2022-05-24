package br.senac.educatech.modelo.dao.avaliacao;

import java.util.List;

import br.senac.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.senac.educatech.modelo.entidade.curso.Curso;

public interface AvaliacaoDAO {

	Avaliacao inserirAvaliacao(Avaliacao avaliacao);

	void atualizarAvaliacao(Avaliacao avaliacao);

	void deletarAvaliacao(Avaliacao avaliacao);

	Avaliacao recuperarAvaliacaoPeloId(Avaliacao avaliacao);

	double recuperarMediaAvaliacaoPeloCurso(Curso curso);

	List<Avaliacao> recuperarAvaliacoesPeloCurso(Curso curso);
	
	List<Avaliacao> recuperarPaginaPelaNotaComentarioNome(int pageNumber, int pageSize);

}