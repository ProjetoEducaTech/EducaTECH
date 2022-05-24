package br.senac.educatech.modelo.entidade.area;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public Area() {}

	public Area(String nome) {
		setNome(nome);
	}

	public Area(Long id, String nome) {
		setId(id);
		setNome(nome);
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
	
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(this instanceof Area))
			return false;

		Area area = (Area) obj;

		return this.getId().equals(area.getId()) && this.getNome().equals(area.getNome());
	}
}