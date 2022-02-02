package sistema.modelo.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Entity;



@Entity
@Table(name = "institiuicao")
public class Instituicao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cnpj", length = 20, nullable = false, unique = true)
	private String cnpj;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Curso> cursos = new ArrayList<Curso>();

	public Instituicao() {
	}

	public Instituicao(String cnpj) {
		setNome(cnpj);
		cursos = new ArrayList<Curso>();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setNome(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public void inserirCurso(Curso curso) {
		cursos.add(curso);
	}
}