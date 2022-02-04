package sistema.modelo.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

	
	@Entity
	@Table(name = "area")
	public class Area implements Serializable {
		
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name = "id_area", unique = true)
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
}