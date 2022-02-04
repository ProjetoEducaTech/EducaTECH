package sistema.modelo.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Column(name = "cpf_aluno", length = 20, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "sobrenome_aluno", length = 20, nullable = false, unique = true)
	private String sobrenome;
	
	//devendo o date

	
	@Column(name = "nota_corte", nullable = false)
	private float notaCorte;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "Aluno_curso_favorito", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_curso"))
	private List<Curso> cursoFavorito = new ArrayList<Curso>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "Aluno_curso", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_curso"))
	private List<Curso> curso = new ArrayList<Curso>();
	
	@Enumerated(EnumType.ORDINAL)
    private Genero genero;
	
	public Aluno() {}
	
	public Aluno(String cpf, String sobrenome, float notaCorte, Genero genero) {
		setCpf(cpf);
		setSobrenome(sobrenome);
		setNotaCorte(notaCorte);
		setGenero(genero);
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public float getNotaCorte() {
		return notaCorte;
	}

	public void setNotaCorte(float notaCorte) {
		this.notaCorte = notaCorte;
	}
	
	public List<Curso> getCursoFavorito() {
		return cursoFavorito;
	}

	public void adicionarCursoFavorito(Curso cursoFavorito) {
		this.cursoFavorito.add(cursoFavorito);
	}
	
	public List<Curso> getCurso() {
		return curso;
	}

	public void adicionarCurso(Curso curso) {
		this.curso.add(curso);
	}
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}