package sistema.modelo.dao.aluno;

import java.util.List;

import sistema.modelo.entidade.curso.Curso;


public interface AlunoDAO {
	
	//List<Curso> consultaNota(Aluno aluno);
	//List<Curso> consultaInstituicao(Instituicao instituicao);
	//List<Curso> consultaArea(Area area);
	void favoritarCurso(Curso curso);
	List<Curso> exibirCursosFavoritos();


}
