package br.com.educatech.modelo.entidade.instituicao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.educatech.modelo.entidade.curso.Curso;
import br.com.educatech.modelo.entidade.endereco.Endereco;
import br.com.educatech.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "instituicao")
public class Instituicao extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7130420479638977031L;

	@Column(name = "cnpj_instituicao", length = 45, unique = true, nullable = false)
	private String cnpj;

	@Column(name = "descricao_instituicao", length = 45, nullable = false)
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Curso> cursos = new ArrayList<>();

	@OneToOne(mappedBy = "instituicao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Endereco endereco;

	public Instituicao() {
	}

	public Instituicao(Long id, String nome, String senha, byte[] sal, String cnpj, String descricao) {
		super(id, nome, senha, sal);
		setCnpj(cnpj);
		setDescricao(descricao);
		cursos = new ArrayList<>();
	}

	public Instituicao(String nome, String senha, byte[] sal, String cnpj, String descricao) {
		super(nome, senha, sal);
		setCnpj(cnpj);
		setDescricao(descricao);
		cursos = new ArrayList<>();
	}

	public Instituicao(Long id) {
		super(id);
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

}
