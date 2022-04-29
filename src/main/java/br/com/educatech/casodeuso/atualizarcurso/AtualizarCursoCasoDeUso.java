package br.com.educatech.casodeuso.atualizarcurso;

import br.com.educatech.modelo.dao.curso.CursoDAO;
import br.com.educatech.modelo.entidade.curso.Curso;

public class AtualizarCursoCasoDeUso {

	private CursoDAO cursoDAO;

	public AtualizarCursoCasoDeUso(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	public Curso atualizarCurso(Curso curso) {

		return cursoDAO.atualizarCurso(curso);

	}

}
