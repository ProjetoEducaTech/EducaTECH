package sistema.modelo.entidade.avaliacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sistema.modelo.entidade.aluno.Aluno;
import sistema.modelo.entidade.curso.Curso;

@Entity
@Table(name = "avaliacao")
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_avaliacao", unique = true)
	private Long id;

	@Column(name = "nota_avaliacao", nullable = false)
	private int nota;

	@Column(name = "comentario_avaliacao", length = 45, nullable = false)
	private String comentario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Aluno aluno;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "cursos_avaliados", joinColumns = @JoinColumn(name = "id_avaliacao"), inverseJoinColumns = @JoinColumn(name = "id_curso"))
	private List<Curso> cursosAvaliados = new ArrayList<Curso>();

	public Avaliacao() {
	}

	public Avaliacao(int nota, String comentario) {
		setNota(nota);
		setComentario(comentario);
	}

	public Avaliacao(Long id, int nota, String comentario) {
		setId(id);
		setNota(nota);
		setComentario(comentario);
		cursosAvaliados = new ArrayList<Curso>();
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

	public List<Curso> getCursosAvaliados() {
		return cursosAvaliados;
	}

	public void setCursosAvaliados(Curso cursosAvaliados) {
		this.cursosAvaliados.add(cursosAvaliados);
	}
	
	public void removerCursosAvaliados(Curso cursosAvaliados) {
		this.cursosAvaliados.remove(cursosAvaliados);
	}

	@Override
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