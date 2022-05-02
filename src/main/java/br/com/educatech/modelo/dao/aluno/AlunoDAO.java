package br.com.educatech.modelo.dao.aluno;

import java.util.List;

import br.com.educatech.modelo.entidade.aluno.Aluno;
import br.com.educatech.modelo.entidade.curso.Curso;

public interface AlunoDAO {

	Aluno inserirAluno(Aluno aluno);

	Aluno atualizarAluno(Aluno aluno);

	void deletarAluno(Aluno aluno);

	void favoritarCurso(Curso curso);

	void removerCursoFavorito(Curso curso);

	Aluno loginUsuarioAluno(Long id);

	List<Aluno> recuperarAlunos();

	Aluno recuperarAlunoPorID(Aluno aluno);

}
