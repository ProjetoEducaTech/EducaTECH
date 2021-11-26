package sistema.modelo.entidade;

import java.util.ArrayList;
import java.util.List;

public class Instituicao {

	private int id;
	private String nome;
	private List<Curso> cursos;

	public Instituicao(String nome) {
		setNome(nome);
		cursos = new ArrayList<Curso>();
	}

	public Instituicao(int id, String nome) {
		setId(id);
		setNome(nome);
		cursos = new ArrayList<Curso>();
	}
	
	public Instituicao( int idInstituicao){
		setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public void inserirCurso(Curso curso) {
		cursos.add(curso);
	}	
}