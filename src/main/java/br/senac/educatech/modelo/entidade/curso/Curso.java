package br.senac.educatech.modelo.entidade.curso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.educatech.modelo.entidade.aluno.Aluno;
import br.senac.educatech.modelo.entidade.area.Area;
import br.senac.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.senac.educatech.modelo.entidade.instituicao.Instituicao;
import br.senac.educatech.modelo.enumeracao.ingresso.Ingresso;
import br.senac.educatech.modelo.enumeracao.modalidade.Modalidade;
import br.senac.educatech.modelo.enumeracao.turno.Turno;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = -168282301577242694L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso", nullable = false)
	private Long id;

	@Column(name = "nome_curso", length = 45, nullable = false)
	private String nome;

	@Column(name = "descricao_curso", length = 45, nullable = false)
	private String descricao;

	@Column(name = "duracao_curso", nullable = false)
	private double duracao;

	@Column(name = "preco_curso", scale = 6, precision = 2, nullable = false)
	private double preco;

	@Column(name = "link_curso", length = 45, nullable = false)
	private String link;

	@Column(name = "nota_corte_curso", scale = 5, precision = 2, nullable = false)
	private double notaCorte;

	@Column(name = "ingresso_curso", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Ingresso ingresso;

	@Column(name = "modalidade_curso", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Modalidade modalidade;

	@Column(name = "turno_curso", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Turno turno;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_area", nullable = false)
	private Area area;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_instituicao", nullable = false)
	private Instituicao instituicao;

	@ManyToMany(mappedBy = "cursosFavorito")
	private List<Aluno> alunos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Avaliacao> avaliacoes;

	public Curso() {}

	public Curso(String nome, String descricao, double duracao, double preco, String link, double notaCorte, Ingresso ingresso, Modalidade modalidade, Turno turno, Area area, Instituicao instituicao) {
		setNome(nome);
		setDescricao(descricao);
		setDuracao(duracao);
		setPreco(preco);
		setLink(link);
		setNotaCorte(notaCorte);
		setIngresso(ingresso);
		setModalidade(modalidade);
		setTurno(turno);
		setArea(area);
		setInstituicao(instituicao);
		alunos = new ArrayList<Aluno>();
		avaliacoes = new ArrayList<Avaliacao>();
	}

	public Curso(String nome, String descricao, double duracao, double preco, String link, Ingresso tipoIngresso, Modalidade tipoModalidade, Turno tipoTurno, Area area, Instituicao instituicao) {
		setNome(nome);
		setDescricao(descricao);
		setDuracao(duracao);
		setPreco(preco);
		setLink(link);
		setIngresso(tipoIngresso);
		setModalidade(tipoModalidade);
		setTurno(tipoTurno);
		setArea(area);
		setInstituicao(instituicao);
		alunos = new ArrayList<Aluno>();
		avaliacoes = new ArrayList<Avaliacao>();
	}

	public Curso(Long id, String nome, String descricao, double duracao, double preco, String link, double notaCorte, Ingresso tipoIngreso, Modalidade tipoModalidade, Turno tipoTurno, Area area, Instituicao instituicao) {
		setId(id);
		setNome(nome);
		setDescricao(descricao);
		setDuracao(duracao);
		setPreco(preco);
		setLink(link);
		setNotaCorte(notaCorte);
		setIngresso(tipoIngreso);
		setModalidade(tipoModalidade);
		setTurno(tipoTurno);
		setArea(area);
		setInstituicao(instituicao);
		alunos = new ArrayList<Aluno>();
		avaliacoes = new ArrayList<Avaliacao>();
	}

	public Curso(Long id) {
		setId(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getlink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public double getNotaCorte() {
		return notaCorte;
	}

	public void setNotaCorte(double notaCorte) {
		this.notaCorte = notaCorte;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public void removerAluno(Aluno aluno) {
		alunos.remove(aluno);
	}

	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(this instanceof Curso))
			return false;

		Curso curso = (Curso) obj;

		return this.getId().equals(curso.getId()) && this.getNome().equals(curso.getNome())
				&& this.getArea().equals(curso.getArea()) && this.getDescricao().equals(curso.getDescricao())
				&& this.getDuracao() == curso.getDuracao() && this.getIngresso().equals(curso.getIngresso())
				&& this.getPreco() == curso.getPreco() && this.getNotaCorte() == curso.getNotaCorte()
				&& this.getlink().equals(curso.getlink()) && this.getModalidade().equals(curso.getModalidade())
				&& this.getTurno().equals(curso.getTurno()) && this.getInstituicao().equals(curso.getInstituicao());
	}
}