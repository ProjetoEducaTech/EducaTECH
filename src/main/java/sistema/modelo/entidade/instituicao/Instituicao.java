package sistema.modelo.entidade.instituicao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "instituicao")
public class Instituicao extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "cnpj_instituicao", length = 45, nullable = false, unique = true)
	private String cnpj;

	@Column(name = "descricao_instituicao", length = 45, nullable = false)
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Curso> cursos;

	public Instituicao() {
	}

	public Instituicao(Long id, String nome, String senha, String cnpj) {
		super(id, nome, senha);
		setCnpj(cnpj);
		setDescricao(descricao);
		cursos = new ArrayList<Curso>();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void inserirCurso(Curso curso) {
		cursos.add(curso);
	}
}