package br.com.educatech.casodeuso.deletarcurso;

import br.com.educatech.modelo.dao.curso.CursoDAO;
import br.com.educatech.modelo.entidade.curso.Curso;

public class DeletarCursoCasoDeUso {

	private CursoDAO cursoDAO;

	public DeletarCursoCasoDeUso(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	public Curso deletarCurso(Curso curso) {

		return cursoDAO.deletarCurso(curso);

	}

}
