package br.com.educatech.modelo.dao.avaliacao;

import java.util.List;

import br.com.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.com.educatech.modelo.entidade.curso.Curso;

public interface AvaliacaoDAO {

	Avaliacao inserirAvaliacao(Avaliacao avaliacao);

	Avaliacao atualizarAvaliacao(Avaliacao avaliacao);

	Avaliacao deletarAvaliacao(Avaliacao avaliacao);

	Avaliacao recuperarAvaliacaoPorId(Avaliacao avaliacao);

	double recuperarMediaAvaliacaoCurso(Curso curso);

	List<Avaliacao> recuperarAvaliacaoCurso(Curso curso);

}