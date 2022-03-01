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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.entidade.usuario.Usuario;
import sistema.modelo.enumeracao.genero.Genero;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "cpf_aluno", length = 20, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "sobrenome_aluno", length = 20, nullable = false, unique = false)
	private String sobrenome;
	
	@Column(name = "data_nascimento_aluno", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "nota_corte_aluno", scale = 5, precision = 2,nullable = false)
	private double notaCorte;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "Aluno_curso_favorito", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_curso"))
	private List<Curso> cursoFavorito = new ArrayList<Curso>();
	
	@Column(name = "genero_aluno", nullable = false)
	@Enumerated(EnumType.ORDINAL)
    private Genero genero;
	
	public Aluno() {}
	
	public Aluno(Long id, String nome, String senha, String cpf, String sobrenome, double notaCorte, Genero genero, LocalDate dataNascimento) {
		super (id, nome, senha);
		setCpf(cpf);
		setSobrenome(sobrenome);
		setNotaCorte(notaCorte);
		setGenero(genero);
		setDataNascimento(dataNascimento);
		cursoFavorito = new ArrayList<Curso>();
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
	
	public LocalDate getDataNascimento() {
		
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public double getNotaCorte() {
		return notaCorte;
	}

	public void setNotaCorte(double notaCorte) {
		this.notaCorte = notaCorte;
	}
	
	public List<Curso> getCursoFavorito() {
		return cursoFavorito;
	}

	public void adicionarCursoFavorito(Curso cursoFavorito) {
		this.cursoFavorito.add(cursoFavorito);
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}