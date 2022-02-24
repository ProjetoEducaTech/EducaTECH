package sistema.modelo.dao.aluno;


import java.util.List;

import sistema.modelo.entidade.aluno.Aluno;
import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.entidade.area.Area;
import sistema.modelo.entidade.instituicao.Instituicao;


public interface AlunoDAO {
	
	void deletarAluno(Aluno aluno);
	void inserirAluno(Aluno aluno);
	void atualizarAluno(Aluno aluno);
	void favoritarCurso(Curso curso);
	
	List<Curso> consultaNota(Aluno aluno);
	List<Curso> consultaInstituicao(Instituicao instituicao);
	List<Curso> consultaArea(Area area);
	List<Curso> exibirCursosFavoritos();
}