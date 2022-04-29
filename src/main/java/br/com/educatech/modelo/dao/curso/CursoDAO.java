package br.com.educatech.modelo.dao.curso;

import java.util.List;
import java.util.Optional;

import br.com.educatech.modelo.entidade.aluno.Aluno;
import br.com.educatech.modelo.entidade.area.Area;
import br.com.educatech.modelo.entidade.curso.Curso;
import br.com.educatech.modelo.entidade.instituicao.Instituicao;
import br.com.educatech.modelo.enumeraco.modalidade.TipoModalidade;
import br.com.educatech.modelo.enumeraco.turno.TipoTurno;

public interface CursoDAO {

	Curso inserirCurso(Curso curso);

	Curso atualizarCurso(Curso curso);

	Curso deletarCurso(Curso curso);

	List<Curso> recuperarCurso();

	List<Curso> recuperarPorInstituicaoCurso(Instituicao instituicao);

	List<Curso> recuperarPorAreaCurso(Area area);

	List<Curso> recuperarPorNotaCurso(Aluno aluno);

	List<Curso> recuperarPorCursoFavorito(Aluno aluno);

	List<Curso> recuperarPorPrecoCurso(double custo);

	List<Curso> recuperarPorModalidadeCurso(TipoModalidade tipoModalidade);

	List<Curso> recuperarPorTurnoCurso(TipoTurno tipoTurno);

	List<Curso> recuperarPorFiltroCurso(Optional<Long> idInstituicao, Optional<Long> idArea, Optional<Double> nota,
			Optional<TipoTurno> tipoTurno, Optional<TipoModalidade> tipoModalidade, Optional<Double> preco);

}
