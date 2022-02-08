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
public class Curso implements Serializable {

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

	@Column(name = "duracao", nullable = false)
	private double duracaoCurso;

	@Column(name = "metodoEntrada", length = 45, nullable = false)
	private String metodoEntrada;

	@Column(name = "preco", nullable = false)
	private double preco;

	@Column(name = "link", length = 45, nullable = false)
	private String link;

	@Enumerated(EnumType.ORDINAL)
	private Modalidade tipoModalidade;

	@Enumerated(EnumType.ORDINAL)
	private Turno tipoTurno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cnpj")
	private Instituicao instituicao;

	public Curso() {

	}

	public Curso(Long idCurso, String nomeCurso, String area, String descricaoCurso, double duracaoCurso,
			String metodoEntrada, double preco, String link, Modalidade tipoModalidade, Turno tipoTurno,
			Instituicao instituicao) {

		setIdCurso(idCurso);
		setNomeCurso(nomeCurso);
		setArea(area);
		setDescricaoCurso(descricaoCurso);
		setDuracaoCurso(duracaoCurso);
		setMetodoEntrada(metodoEntrada);
		setPreco(preco);
		setLink(link);
		setTipoModalidade(tipoModalidade);
		setTipoTurno(tipoTurno);
		setInstituicao(instituicao);

	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
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

	public String getMetodoEntrada() {
		return metodoEntrada;
	}

	public void setMetodoEntrada(String metodoEntrada) {
		this.metodoEntrada = metodoEntrada;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String link() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Modalidade getTipoModalidade() {
		return tipoModalidade;
	}

	public void setTipoModalidade(Modalidade tipoModalidade) {
		this.tipoModalidade = tipoModalidade;
	}

	public Turno getTipoTurno() {
		return tipoTurno;
	}

	public void setTipoTurno(Turno tipoTurno) {
		this.tipoTurno = tipoTurno;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
}