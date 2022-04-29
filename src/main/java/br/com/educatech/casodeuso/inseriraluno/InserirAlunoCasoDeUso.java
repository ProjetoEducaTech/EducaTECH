package br.com.educatech.casodeuso.inseriraluno;

import br.com.educatech.modelo.dao.aluno.AlunoDAO;
import br.com.educatech.modelo.entidade.aluno.Aluno;

public class InserirAlunoCasoDeUso {

	private AlunoDAO alunoDAO;

	public InserirAlunoCasoDeUso(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}

	public Aluno inserirAluno(Aluno aluno) {

		return alunoDAO.inserirAluno(aluno);

	}

}
