package br.senac.educatech.modelo.entidade.avaliacao;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.educatech.modelo.entidade.aluno.Aluno;
import br.senac.educatech.modelo.entidade.curso.Curso;

@Entity
@Table(name = "avaliacao")
public class Avaliacao implements Serializable {

	
	private static final long serialVersionUID = 8587596035712912830L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_avaliacao")
	private Long id;

	@Column(name = "nota_avaliacao", nullable = false)
	private int nota;

	@Column(name = "comentario_avaliacao", length = 45, nullable = false)
	private String comentario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	@Column(name = "data_avaliacao", nullable = false)
	private LocalDate data; 

	public Avaliacao() {}

	public Avaliacao(int nota, String comentario, Aluno aluno, Curso curso, LocalDate dataComentario) {
		setNota(nota);
		setComentario(comentario);
		setAluno(aluno);
		setCurso(curso);
		setDataComentario(dataComentario);
	}

	public Avaliacao(Long id, int nota, String comentario, Aluno aluno, Curso curso, LocalDate dataComentario) {
		setId(id);
		setNota(nota);
		setComentario(comentario);
		setAluno(aluno);
		setCurso(curso);
		setDataComentario(dataComentario);
	}

	public Avaliacao(Long id) {
		setId(id);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getDataComentario() {
		return data;
	}

	public void setDataComentario(LocalDate dataComentario) {
		this.data = dataComentario;
	}
	
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(this instanceof Avaliacao))
			return false;

		Avaliacao avaliacao = (Avaliacao) obj;

		return this.getId().equals(avaliacao.getId()) && this.getNota() == (avaliacao.getNota())
				&& this.getComentario().equals(avaliacao.getComentario());
	}
}