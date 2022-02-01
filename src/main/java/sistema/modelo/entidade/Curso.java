package sistema.modelo.entidade;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Curso")
public class Curso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long idCurso;

	@Column(name = "nome", length = 45, nullable = false)
	private String nomeCurso;

	@Column(name = "area", length = 45, nullable = false)
	private String area;

	@Column(name = "descricao", length = 45, nullable = false)
	private String descricaoCurso;

	@Column(name = "duracao", length = 45, nullable = false)
	private double duracaoCurso;

	@Enumerated(EnumType.ORDINAL)
	private Turno turno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cnpj")
	private Instituicao instituicao;
	
	public Curso() {
		
	}

	public Curso(Long idCurso, String nomeCurso, String area, String descricaoCurso, double duracaoCurso, Turno turno,
			Instituicao instituicao) {

		setIdCurso(idCurso);
		setNomeCurso(nomeCurso);
		setArea(area);
		setDescricaoCurso(descricaoCurso);
		setDuracaoCurso(duracaoCurso);
		setTurno(turno);
		setInstituicao(instituicao);

	}

	public long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescricaoCurso() {
		return descricaoCurso;
	}

	public void setDescricaoCurso(String descricaoCurso) {
		this.descricaoCurso = descricaoCurso;
	}

	public double getDuracaoCurso() {
		return duracaoCurso;
	}

	public void setDuracaoCurso(double duracaoCurso) {
		this.duracaoCurso = duracaoCurso;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
}