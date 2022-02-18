package sistema.modelo.entidade.area;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "area")
public class Area implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_area", unique = true)
	private Long idArea;

	@Column(name = "nome_area", length = 45, nullable = false)
	private String nomeArea;

	public Area() {}

	public Area(Long idArea, String nomeArea) {
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