package sistema.modelo.dao.curso;

import java.util.List;

import sistema.modelo.entidade.curso.Curso;

public interface CursoDAO {

	void inserirCurso(Curso curso);
	void deletarCurso(Curso curso);
	void atualizarCurso(Curso curso);
	
	List<Curso> recuperarCursos();

}