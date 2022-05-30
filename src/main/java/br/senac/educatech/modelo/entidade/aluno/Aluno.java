package br.senac.educatech.modelo.entidade.aluno;

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

import br.senac.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.senac.educatech.modelo.entidade.curso.Curso;
import br.senac.educatech.modelo.entidade.foto.Foto;
import br.senac.educatech.modelo.entidade.usuario.Usuario;
import br.senac.educatech.modelo.enumeracao.genero.Genero;
import br.senac.educatech.modelo.enumeracao.pronome.Pronome;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario implements Serializable {

	private static final long serialVersionUID = 1008488261752669129L;

	@Column(name = "cpf_aluno", length = 14, unique = true, nullable = false)
	private String cpf;

	@Column(name = "sobrenome_aluno", length = 20, nullable = false)
	private String sobrenome;

	@Column(name = "data_nascimento_aluno", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "biografia_aluno", length = 45, nullable = false)
	private String biografia;

	@Column(name = "genero_aluno", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Genero Genero;

	@Column(name = "pronome_aluno", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Pronome pronome;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "aluno_curso_favorito", joinColumns = @JoinColumn(name = "id_aluno"), inverseJoinColumns = @JoinColumn(name = "id_curso"))
	private List<Curso> cursosFavoritos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Avaliacao> avaliacoes = new ArrayList<>();

	public Aluno() {
	}

	public Aluno(Long id) {
		super(id);
	}

	public Aluno(String nome, String senha, byte[] sal, String cpf, String sobrenome, String biografia,
			LocalDate dataNascimento, Genero Genero, Pronome pronomes, Foto foto) {
		super(nome, senha, sal, foto);
		setCpf(cpf);
		setSobrenome(sobrenome);
		setBiografia(biografia);
		setDataNascimento(dataNascimento);
		setGenero(Genero);
		setPronome(pronomes);
		cursosFavoritos = new ArrayList<Curso>();
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

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public LocalDate getDataNascimento() {

		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return Genero;
	}

	public void setGenero(Genero Genero) {
		this.Genero = Genero;
	}

	public Pronome getPronome() {
		return pronome;
	}

	public void setPronome(Pronome pronome) {
		this.pronome = pronome;
	}

	public List<Curso> getCursosFavoritos() {
		return cursosFavoritos;
	}

	public void adicionarCursoFavorito(Curso curso) {
		cursosFavoritos.add(curso);
	}

	public void removerCursoFavorito(Curso curso) {
		cursosFavoritos.remove(curso);
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void adicionarAvaliacao(Avaliacao avaliacao) {
		avaliacoes.add(avaliacao);
	}

	public void removerAvaliacao(Avaliacao avaliacao) {
		avaliacoes.remove(avaliacao);
	}

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
				&& this.getSobrenome().equals(aluno.getSobrenome()) && this.getGenero().equals(aluno.getGenero())
				&& this.getDataNascimento().equals(aluno.getDataNascimento())
				&& this.getBiografia().equals(aluno.getBiografia()) && this.getPronome().equals(aluno.getPronome());
	}
}