package sistema.modelo.dao;

import java.util.List;

import sistema.modelo.entidade.Aluno;
import sistema.modelo.entidade.Area;
import sistema.modelo.entidade.Curso;
import sistema.modelo.entidade.Instituicao;

public interface AlunoDAO {
	
	List<Curso> consultaNota(Aluno aluno);
	List<Curso> consultaInstituicao(Instituicao instituicao);
	List<Curso> consultaArea(Area area);
	void favoritarCurso(Curso curso);
	List<Curso> exibirCursosFavoritos();

}
