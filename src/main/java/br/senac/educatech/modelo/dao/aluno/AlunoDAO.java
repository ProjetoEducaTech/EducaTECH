package br.senac.educatech.modelo.dao.aluno;

import java.util.List;

import br.senac.educatech.modelo.entidade.aluno.Aluno;
import br.senac.educatech.modelo.entidade.curso.Curso;

public interface AlunoDAO {

	Long inserirAluno(Aluno aluno);

	void atualizarAluno(Aluno aluno);

	void deletarAluno(Aluno aluno);

	Aluno recuperarAlunoPeloId(Aluno aluno);
	
	Aluno recuperarAlunoComCursosPeloId(Aluno aluno);
	
	Aluno recuperarAlunoComAvaliacoesPeloId(Aluno aluno);

	List<Aluno> recuperarAlunos();
	
	List<Aluno> recuperarAlunosAvaliaramCurso(Curso curso);

}