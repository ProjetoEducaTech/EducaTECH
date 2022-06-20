package br.senac.educatech.modelo.dao.curso;

import java.util.List;
import java.util.Optional;

import br.senac.educatech.modelo.entidade.aluno.Aluno;
import br.senac.educatech.modelo.entidade.area.Area;
import br.senac.educatech.modelo.entidade.curso.Curso;
import br.senac.educatech.modelo.entidade.instituicao.Instituicao;
import br.senac.educatech.modelo.enumeracao.modalidade.Modalidade;
import br.senac.educatech.modelo.enumeracao.turno.Turno;

public interface CursoDAO {

	Long inserirCurso(Curso curso);

	void atualizarCurso(Curso curso);

	void deletarCurso(Curso curso);

	Curso recuperarCursoPeloId(Curso curso);
	
	Curso recuperarCursoComAvaliacoesPeloId(Curso curso);
	
	Curso recuperarCursoComAlunosPeloId(Curso curso);
	
	Curso recuperarCursoComAreaPeloId(Curso curso);

	List<Curso> recuperarCursos();

	List<Curso> recuperarCursosPelaInstituicao(Instituicao instituicao);

	List<Curso> recuperarCursosPelaArea(Area area);

	//List<Curso> recuperarCursosPelaNota(Aluno aluno);

	List<Curso> recuperarCursosFavoritos(Aluno aluno);

	List<Curso> recuperarCursosPeloPreco(double custo);

	List<Curso> recuperarCursosPelaModalidade(Modalidade modalidade);

	List<Curso> recuperarCursosPeloTurno(Turno turno);

	double recuperaMenorPrecoCurso();

	double recuperarMaiorPrecoCurso();

	List<Curso> recuperarPaginaPorAvaliacao();

	List<Curso> recuperarCursoPorFiltro(Optional<Long> idInstituicao, Optional<Long> idArea, Optional<Double> nota,
			Optional<Turno> turno, Optional<Modalidade> modalidade, Optional<Double> preco,
			Optional<Double> duracao);

	List<Curso> recuperarCursosPorFiltroInicial(Optional<Modalidade> modalidade, Optional<Double> notaDeCorte,
			Optional<Turno> turno, Optional<Long> idArea);
	
	
}
