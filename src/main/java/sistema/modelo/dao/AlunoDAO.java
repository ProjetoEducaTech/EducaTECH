package sistema.modelo.dao;

import sistema.modelo.entidade.Curso;

public interface AlunoDAO {
	
	void inserirAluno (Aluno aluno);
	
	void favoritarCurso(Curso curso);

}
