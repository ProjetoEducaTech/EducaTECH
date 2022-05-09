package br.com.educatech.modelo.entidade.avaliacao;

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

import br.com.educatech.modelo.entidade.aluno.Aluno;
import br.com.educatech.modelo.entidade.curso.Curso;

@Entity
@Table(name = "avaliacao")
public class Avaliacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8587596035712912830L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_avaliacao", unique = true, nullable = false)
	private Long id;

	@Column(name = "nota_avaliacao", nullable = false)
	private int nota;

	@Column(name = "comentario_avaliacao", length = 45, nullable = false)
	private String comentario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_aluno", nullable = false)
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_curso", nullable = false)
	private Curso curso;
	
	@Column(name = "data_comentario_avaliacao", nullable = false)
	private LocalDate dataComentario; 

	public Avaliacao() {
	}

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
		return dataComentario;
	}

	public void setDataComentario(LocalDate dataComentario) {
		this.dataComentario = dataComentario;
	}
}