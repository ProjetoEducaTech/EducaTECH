package br.com.educatech.modelo.entidade.aluno;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.com.educatech.modelo.entidade.curso.Curso;
import br.com.educatech.modelo.entidade.usuario.Usuario;
import br.com.educatech.modelo.enumeraco.genero.TipoGenero;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1008488261752669129L;

	@Column(name = "cpf_aluno", length = 20, unique = true, nullable = false)
	private String cpf;

	@Column(name = "sobrenome_aluno", length = 20, nullable = false)
	private String sobrenome;

	@Column(name = "data_nascimento_aluno", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "nota_aluno", scale = 5, precision = 2, nullable = false)
	private double nota;

	@Column(name = "genero_aluno", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TipoGenero tipoGenero;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "aluno_curso_favorito", joinColumns = @JoinColumn(name = "fk_usuario"), inverseJoinColumns = @JoinColumn(name = "fk_curso"))
	private List<Curso> cursosFavorito = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Avaliacao> avaliacoes = new ArrayList<>();

	public Aluno() {
	}

	public Aluno(Long id, String nome, String senha, byte[] sal, String cpf, String sobrenome, double nota,
			LocalDate dataNascimento, TipoGenero tipoGenero) {
		super(id, nome, senha, sal);
		setCpf(cpf);
		setSobrenome(sobrenome);
		setNota(nota);
		setDataNascimento(dataNascimento);
		setTipoGenero(tipoGenero);
		cursosFavorito = new ArrayList<>();
		avaliacoes = new ArrayList<>();
	}

	public Aluno(String nome, String senha, String cpf, String sobrenome, double nota, LocalDate dataNascimento,
			TipoGenero tipoGenero, Curso curso, byte[] sal) {
		super(nome, senha, sal);
		setCpf(cpf);
		setSobrenome(sobrenome);
		setNota(nota);
		setDataNascimento(dataNascimento);
		setTipoGenero(tipoGenero);
		cursosFavorito = new ArrayList<>();
	}

	public Aluno(String nome, String senha, String cpf, String sobrenome, double nota, LocalDate dataNascimento,
			TipoGenero tipoGenero, byte[] sal) {
		super(nome, senha, sal);
		setCpf(cpf);
		setSobrenome(sobrenome);
		setNota(nota);
		setDataNascimento(dataNascimento);
		setTipoGenero(tipoGenero);
		cursosFavorito = new ArrayList<>();
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

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public LocalDate getDataNascimento() {

		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoGenero getTipoGenero() {
		return tipoGenero;
	}

	public void setTipoGenero(TipoGenero tipoGenero) {
		this.tipoGenero = tipoGenero;
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

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

}
