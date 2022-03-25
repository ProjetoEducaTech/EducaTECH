package sistema.modelo.dao.aluno;


import java.util.List;

import sistema.modelo.entidade.aluno.Aluno;
import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.entidade.usuario.Usuario;


public interface AlunoDAO {
	
	void deletarAluno(Aluno aluno);
	
	void inserirAluno(Aluno aluno);
	
	void atualizarAluno(Aluno aluno);
	
	void favoritarCurso(Curso curso);
	
	List<Aluno> recuperarAlunos();
	
	Usuario loginUsuarioAluno(Aluno aluno);
	
}
