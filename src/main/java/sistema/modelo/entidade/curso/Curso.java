package sistema.modelo.entidade.curso;

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
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sistema.modelo.entidade.area.Area;
import sistema.modelo.entidade.instituicao.Instituicao;
import sistema.modelo.enumeracao.Turno;
import sistema.modelo.enumeracao.metodoentrada.MetodoEntrada;
import sistema.modelo.enumeracao.modalidade.Modalidade;

@Entity
@Table(name = "Curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso", unique = true)
	private Long idCurso;

	@Column(name = "nome_curso", length = 45, nullable = false)
	private String nomeCurso;

	@Column(name = "descricao_curso", length = 45, nullable = false)
	private String descricaoCurso;

	@Column(name = "duracao_curso", nullable = false)
	private int duracaoCurso;

	@Enumerated(EnumType.ORDINAL)
	private MetodoEntrada metodoEntrada;

	@Column(name = "preco_curso", scale = 6, precision = 2,nullable = false)
	private double preco;

	@Column(name = "link_curso", length = 45, nullable = false)
	private String link;

	@Enumerated(EnumType.ORDINAL)
	private Modalidade tipoModalidade;

	@Enumerated(EnumType.ORDINAL)
	private Turno tipoTurno;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "area_curso")
	private Area area;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_usuario")
	private Instituicao instituicao;

	public Curso() {

	}
	
	public Curso(String nomeCurso, Area area, String descricaoCurso, int duracaoCurso,
			MetodoEntrada metodoEntrada, double preco, String link, Modalidade tipoModalidade, Turno tipoTurno,
			Instituicao instituicao) {

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

	public Curso(Long idCurso, String nomeCurso, Area area, String descricaoCurso, int duracaoCurso,
			MetodoEntrada metodoEntrada, int preco, String link, Modalidade tipoModalidade, Turno tipoTurno,
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getDescricaoCurso() {
		return descricaoCurso;
	}

	public void setDescricaoCurso(String descricaoCurso) {
		this.descricaoCurso = descricaoCurso;
	}

	public int getDuracaoCurso() {
		return duracaoCurso;
	}

	public void setDuracaoCurso(int duracaoCurso) {
		this.duracaoCurso = duracaoCurso;
	}

	public MetodoEntrada getMetodoEntrada() {
		return metodoEntrada;
	}

	public void setMetodoEntrada(MetodoEntrada metodoEntrada) {
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