package br.senac.educatech.modelo.entidade.instituicao;

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

import br.senac.educatech.modelo.entidade.area.Area;
import br.senac.educatech.modelo.entidade.curso.Curso;
import br.senac.educatech.modelo.entidade.endereco.Endereco;
import br.senac.educatech.modelo.entidade.foto.Foto;
import br.senac.educatech.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "instituicao")
public class Instituicao extends Usuario implements Serializable {

	private static final long serialVersionUID = -7130420479638977031L;

	@Column(name = "cnpj_instituicao", length = 18, unique = true, nullable = false)
	private String cnpj;

	@Column(name = "descricao_instituicao", length = 45, nullable = false)
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Curso> cursos;

	@OneToOne(mappedBy = "instituicao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Endereco endereco;

	@OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Area> areas;

	public Instituicao() {
	}

	public Instituicao(Long id, String nome, String senha, byte[] sal, String cnpj, String descricao, Foto foto) {
		super(id, nome, senha, sal, foto);
		setCnpj(cnpj);
		setDescricao(descricao);
		cursos = new ArrayList<Curso>();
	}

	public Instituicao(String nome, String senha, byte[] sal, String cnpj, String descricao, Foto foto) {
		super(nome, senha, sal, foto);
		setCnpj(cnpj);
		setDescricao(descricao);
		cursos = new ArrayList<Curso>();
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

	public void inserirCurso(Curso curso) {
		cursos.add(curso);
	}

	public void removerCurso(Curso curso) {
		cursos.remove(curso);
	}

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