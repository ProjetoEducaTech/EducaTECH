package sistema.modelo.dao;

import java.util.List;

import sistema.modelo.entidade.Curso;

public interface CursoDAO {

	void inserirCurso(Curso curso);

	void deletarCurso(Curso curso);

	void atualizarNotaCorteCurso(Curso curso, float notaCorte);

	void atualizarNomeCurso(Curso curso, String nomeCurso);

	List<Curso> recuperarCursos();

}