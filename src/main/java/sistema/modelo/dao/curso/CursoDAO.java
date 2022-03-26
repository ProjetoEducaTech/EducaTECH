package sistema.modelo.dao.curso;

import java.util.List;

import sistema.modelo.entidade.aluno.Aluno;
import sistema.modelo.entidade.area.Area;
import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.entidade.instituicao.Instituicao;

public interface CursoDAO {

	void inserirCurso(Curso curso);
	void deletarCurso(Curso curso);
	void atualizarCurso(Curso curso);
	
	List<Curso> recuperarCursos();
	List<Curso> consultaInstituicaoCurso(Instituicao instituicao);
	List<Curso> consultaAreaCurso(Area area);
	List<Curso> consultaNotaCurso(Aluno aluno);
	List<Curso> exibirCursosFavoritos(Aluno aluno);
	List<Curso> consultaPrecoCurso(double custo);
}