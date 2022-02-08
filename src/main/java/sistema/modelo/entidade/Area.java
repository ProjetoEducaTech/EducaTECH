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
	private Long idArea;

	@Column(name = "nome_area", length = 45, nullable = false)
	private String nomeArea;

	public Area() {
	}

	public Area(long idArea, String nomeArea) {
		setIdArea(idArea);
		setNomeArea(nomeArea);
	}

	public Long getIdArea() {
		return idArea;
	}

	public void setIdArea(Long idArea) {
		this.idArea = idArea;
	}

	public String getNomeArea() {
		return nomeArea;
	}

	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}
}