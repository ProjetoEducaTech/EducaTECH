package br.com.educatech.casodeuso.recuperarporcurso;

import java.util.List;

import br.com.educatech.modelo.dao.curso.CursoDAO;
import br.com.educatech.modelo.entidade.curso.Curso;

public class RecuperarPorCursoCasoDeUso {

	private CursoDAO cursoDAO;

	public void RecuperarCursoCasoDeUso(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	public List<Curso> recuperarCurso() {

		return cursoDAO.recuperarCurso();

	}

}
