package br.senac.educatech.modelo.dao.aluno;

import java.util.List;

import br.senac.educatech.modelo.entidade.aluno.Aluno;

public interface AlunoDAO {

	Long inserirAluno(Aluno aluno);

	void atualizarAluno(Aluno aluno);

	void deletarAluno(Aluno aluno);

	Aluno recuperarAlunoPeloId(Aluno aluno);

	List<Aluno> recuperarAlunos();

}