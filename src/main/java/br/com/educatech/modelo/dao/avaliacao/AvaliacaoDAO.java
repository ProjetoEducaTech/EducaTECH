package br.com.educatech.modelo.dao.avaliacao;

import java.util.List;

import br.com.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.com.educatech.modelo.entidade.curso.Curso;

public interface AvaliacaoDAO {

	Avaliacao inserirAvaliacao(Avaliacao avaliacao);

	Avaliacao atualizarAvaliacao(Avaliacao avaliacao);

	Avaliacao deletarAvaliacao(Avaliacao avaliacao);

	double mediaAvaliacoesCurso(List<Integer> media);

	List<Avaliacao> avaliacaoCurso(Curso curso);
	
	Avaliacao recuperarAvaliacaoPorID (Avaliacao avaliacao);
}