package br.com.educatech.modelo.entidade.curso;

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

import br.com.educatech.modelo.entidade.aluno.Aluno;
import br.com.educatech.modelo.entidade.area.Area;
import br.com.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.com.educatech.modelo.entidade.instituicao.Instituicao;
import br.com.educatech.modelo.enumeraco.ingresso.TipoIngresso;
import br.com.educatech.modelo.enumeraco.modalidade.TipoModalidade;
import br.com.educatech.modelo.enumeraco.turno.TipoTurno;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	/**
	 * 
	 */
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
	private int duracao;

	@Column(name = "preco_curso", scale = 6, precision = 2, nullable = false)
	private double preco;

	@Column(name = "link_curso", length = 45, nullable = false)
	private String link;

	@Column(name = "nota_corte_curso", scale = 5, precision = 2, nullable = false)
	private double notaCorte;

	@Column(name = "tipo_ingresso_curso", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TipoIngresso tipoIngresso;

	@Column(name = "tipo_modalidade_curso", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TipoModalidade tipoModalidade;

	@Column(name = "tipo_turno_curso", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TipoTurno tipoTurno;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_area", nullable = false)
	private Area area;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_instituicao", nullable = false)
	private Instituicao instituicao;

	@ManyToMany(mappedBy = "cursosFavorito")
	private List<Aluno> alunos = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Avaliacao> avaliacao = new ArrayList<>();

	public Curso() {

	}

	public Curso(String nome, String descricao, int duracao, double preco, String link, double notaCorte,
			TipoIngresso tipoIngresso, TipoModalidade tipoModalidade, TipoTurno tipoTurno, Area area,
			Instituicao instituicao) {
		setNome(nome);
		setDescricao(descricao);
		setDuracao(duracao);
		setPreco(preco);
		setLink(link);
		setNotaCorte(notaCorte);
		setTipoIngresso(tipoIngresso);
		setTipoModalidade(tipoModalidade);
		setTipoTurno(tipoTurno);
		setArea(area);
		setInstituicao(instituicao);
	}

	public Curso(String nome, String descricao, int duracao, double preco, String link, TipoIngresso tipoIngresso,
			TipoModalidade tipoModalidade, TipoTurno tipoTurno, Area area, Instituicao instituicao) {
		setNome(nome);
		setDescricao(descricao);
		setDuracao(duracao);
		setPreco(preco);
		setLink(link);
		setTipoIngresso(tipoIngresso);
		setTipoModalidade(tipoModalidade);
		setTipoTurno(tipoTurno);
		setArea(area);
		setInstituicao(instituicao);
	}

	public Curso(Long id, String nome, String descricao, int duracao, double preco, String link, double notaCorte,
			TipoIngresso tipoIngreso, TipoModalidade tipoModalidade, TipoTurno tipoTurno, Area area,
			Instituicao instituicao) {
		setId(id);
		setNome(nome);
		setDescricao(descricao);
		setDuracao(duracao);
		setPreco(preco);
		setLink(link);
		setNotaCorte(notaCorte);
		setTipoIngresso(tipoIngreso);
		setTipoModalidade(tipoModalidade);
		setTipoTurno(tipoTurno);
		setArea(area);
		setInstituicao(instituicao);
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

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
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

	public TipoIngresso getTipoIngresso() {
		return tipoIngresso;
	}

	public void setTipoIngresso(TipoIngresso tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}

	public TipoModalidade getTipoModalidade() {
		return tipoModalidade;
	}

	public void setTipoModalidade(TipoModalidade tipoModalidade) {
		this.tipoModalidade = tipoModalidade;
	}

	public TipoTurno getTipoTurno() {
		return tipoTurno;
	}

	public void setTipoTurno(TipoTurno tipoTurno) {
		this.tipoTurno = tipoTurno;
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

	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Aluno alunos) {
		this.alunos.add(alunos);
	}

	public void removerAluno(Aluno alunos) {
		this.alunos.remove(alunos);
	}

}
