package sistema.modelo.entidade.aluno;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.entidade.usuario.Usuario;
import sistema.modelo.enumeracao.Genero;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cpf_aluno", length = 20, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "sobrenome_aluno", length = 20, nullable = false, unique = true)
	private String sobrenome;
	
	@Column(name = "data_nascimento_aluno")
	private LocalDate dataNascimento;

	@Column(name = "nota_corte", scale = 5, precision = 2,nullable = false)
	private double notaCorte;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "Aluno_curso_favorito", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_curso"))
	private List<Curso> cursoFavorito = new ArrayList<Curso>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "Aluno_curso", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_curso"))
	private List<Curso> curso = new ArrayList<Curso>();
	
	@Enumerated(EnumType.ORDINAL)
    private Genero genero;
	
	public Aluno() {}
	
	public Aluno(String cpf, String sobrenome, double notaCorte, Genero genero, Usuario usuario) {
		setCpf(cpf);
		setSobrenome(sobrenome);
		setNotaCorte(notaCorte);
		setUsuario(usuario);
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
	
	public double getNotaCorte() {
		return notaCorte;
	}

	public void setNotaCorte(double notaCorte) {
		this.notaCorte = notaCorte;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
