package br.com.educatech.casodeuso.solicitarlogin;

import br.com.educatech.modelo.dao.aluno.AlunoDAO;
import br.com.educatech.modelo.entidade.aluno.Aluno;

public class SolicitarLoginCasoDeUso {

	private AlunoDAO alunoDAO;

	public SolicitarLoginCasoDeUso(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}

	public Aluno loginUsuarioAluno(Long id) {

		return alunoDAO.recuperarAlunoPorId(id);

	}

}
