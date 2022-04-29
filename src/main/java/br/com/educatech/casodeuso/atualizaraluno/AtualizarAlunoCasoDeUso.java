package br.com.educatech.casodeuso.atualizaraluno;

import br.com.educatech.modelo.dao.aluno.AlunoDAO;
import br.com.educatech.modelo.entidade.aluno.Aluno;

public class AtualizarAlunoCasoDeUso {

	private AlunoDAO alunoDAO;

	public AtualizarAlunoCasoDeUso(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}

	public Aluno atualizarAluno(Aluno aluno) {

		return alunoDAO.atualizarAluno(aluno);

	}

}
