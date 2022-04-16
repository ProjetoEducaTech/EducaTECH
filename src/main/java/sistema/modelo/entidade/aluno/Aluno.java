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

	@Column(name = "nota_aluno", scale = 5, precision = 2, nullable = false)
	private double nota;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "aluno_curso_favorito", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_curso"))
	private List<Curso> cursosFavorito = new ArrayList<Curso>();

	@Column(name = "genero_aluno", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Genero genero;

	public Aluno() {
	}

	public Aluno(Long id, String nome, String senha, String cpf, String sobrenome, double nota, Genero genero,
			LocalDate dataNascimento) {
		super(id, nome, senha);
		setCpf(cpf);
		setSobrenome(sobrenome);
		setNota(nota);
		setGenero(genero);
		setDataNascimento(dataNascimento);
		cursosFavorito = new ArrayList<Curso>();
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

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public List<Curso> getCursoFavorito() {
		return cursosFavorito;
	}

	public void setCursoFavorito(Curso cursosFavorito) {
		this.cursosFavorito.add(cursosFavorito);
	}

	public void removerCursoFavorito(Curso cursosFavorito) {
		this.cursosFavorito.remove(cursosFavorito);
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(this instanceof Aluno))
			return false;

		Aluno aluno = (Aluno) obj;

		return this.getId().equals(aluno.getId()) && this.getNome().equals(aluno.getNome())
				&& this.getSenha().equals(aluno.getSenha()) && this.getCpf().equals(aluno.getCpf())
				&& this.getSobrenome().equals(aluno.getSobrenome()) && this.getNota() == aluno.getNota()
				&& this.getGenero().equals(aluno.getGenero())&& this.getDataNascimento().equals(aluno.getDataNascimento());
	}
}