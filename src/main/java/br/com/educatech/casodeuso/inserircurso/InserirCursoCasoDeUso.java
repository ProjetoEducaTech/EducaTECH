package br.com.educatech.casodeuso.inserircurso;

import br.com.educatech.modelo.dao.curso.CursoDAO;
import br.com.educatech.modelo.entidade.curso.Curso;

public class InserirCursoCasoDeUso {

	private CursoDAO cursoDAO;

	public InserirCursoCasoDeUso(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	public Curso inserirCurso(Curso curso) {

		return cursoDAO.inserirCurso(curso);

	}

}
