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
	private List<Curso> cursos = new ArrayList<Curso>();

	public Instituicao() {
	}

	public Instituicao(Long id, String nome, String senha, byte[] sal, String cnpj, String descrcao) {
		super(id, nome, senha, sal);
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

	public void inserirCurso(Curso cursos) {
		this.cursos.add(cursos);
	}

	public void removerCursoInstituicao(Curso cursos) {
		this.cursos.remove(cursos);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(this instanceof Instituicao))
			return false;

		Instituicao instituicao = (Instituicao) obj;

		return this.getId().equals(instituicao.getId()) && this.getNome().equals(instituicao.getNome())
				&& this.getSenha().equals(instituicao.getSenha()) && this.getCnpj().equals(instituicao.getCnpj())
				&& this.getDescricao().equals(instituicao.getDescricao());
	}
}