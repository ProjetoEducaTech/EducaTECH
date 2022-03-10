package sistema.modelo.dao.aluno;


import java.util.List;

import sistema.modelo.entidade.aluno.Aluno;
import sistema.modelo.entidade.curso.Curso;


public interface AlunoDAO {
	
	void deletarAluno(Aluno aluno);
	
	void inserirAluno(Aluno aluno);
	
	void atualizarAluno(Aluno aluno);
	
	void favoritarCurso(Curso curso);
	
	List<Aluno> recuperarAlunos();
	
	List<Curso> consultaNotaCurso(Aluno aluno);
	
	List<Curso> exibirCursosFavoritos();
}