package sistema.modelo.entidade.instituicao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.entidade.endereco.Endereco;
import sistema.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "institiuicao")
public class Instituicao extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cnpj", length = 45, nullable = false, unique = true)
	private String cnpj;

	@Column(name = "descricao", length = 45, nullable = false)
	private String descricao;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Curso> cursos = new ArrayList<Curso>();

	public Instituicao() {
	}

	public Instituicao(Long id, String nome, String senha, String cnpj, Endereco endereco, Usuario usuario) {
		super (id, nome, senha);
		setNome(cnpj);
		setEndereco(endereco);
		setUsuario(usuario);
		cursos = new ArrayList<Curso>();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setNome(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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