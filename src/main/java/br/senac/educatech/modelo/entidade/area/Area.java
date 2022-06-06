package br.senac.educatech.modelo.entidade.area;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.educatech.modelo.entidade.instituicao.Instituicao;

@Entity
@Table(name = "area")
public class Area implements Serializable {

	private static final long serialVersionUID = 4718453261491820700L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_area")
	private Long id;

	@Column(name = "nome_area", length = 45, nullable = false)
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Instituicao instituicao;

	public Area() {
	}

	public Area(String nome, Instituicao instituicao) {
		setNome(nome);
		setInstituicao(instituicao);
	}

	public Area(Long id, String nome, Instituicao instituicao) {
		setId(id);
		setNome(nome);
		setInstituicao(instituicao);
	}

	public Area(Long id) {
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
	
	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(this instanceof Area))
			return false;

		Area area = (Area) obj;

		return this.getId().equals(area.getId()) && this.getNome().equals(area.getNome())
				&& this.getInstituicao().equals(area.getInstituicao());
	}
}