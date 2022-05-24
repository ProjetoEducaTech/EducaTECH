package br.senac.educatech.modelo.entidade.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.educatech.modelo.entidade.instituicao.Instituicao;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = -7357871736984533474L;

	@Id
	@Column(name = "id_endereco", nullable = false)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_usuario")
	private Instituicao instituicao;

	@Column(name = "logradouro_endereco", length = 45, nullable = false)
	private String logradouro;

	@Column(name = "bairro_endereco", length = 45, nullable = false)
	private String bairro;

	@Column(name = "numero_endereco", nullable = false)
	private int numero;

	@Column(name = "cep_endereco", length = 45, nullable = false)
	private String cep;

	@Column(name = "cidade_endereco", length = 45, nullable = false)
	private String cidade;

	@Column(name = "estado_endereco", length = 45, nullable = false)
	private String estado;

	@Column(name = "referencia_endereco", length = 45, nullable = false)
	private String referencia;
	
	@Column(name = "complemento_endereco", length = 45, nullable = false)
	private String complemento; 

	public Endereco() {}

	public Endereco(String logradouro, String bairro, int numero, String cep, String cidade, String estado, String referencia, String complemento, Instituicao instituicao) {
		setLogradouro(logradouro);
		setBairro(bairro);
		setNumero(numero);
		setCep(cep);
		setCidade(cidade);
		setEstado(estado);
		setReferencia(referencia);
		setComplemento(complemento);
		setInstituicao(instituicao);
	}

	public Endereco(Long id, String logradouro, String bairro, int numero, String cep, String cidade, String estado, String referencia, String complemento, Instituicao instituicao) {
		setId(id);
		setLogradouro(logradouro);
		setBairro(bairro);
		setNumero(numero);
		setCep(cep);
		setCidade(cidade);
		setEstado(estado);
		setReferencia(referencia);
		setComplemento(complemento);
		setInstituicao(instituicao);
	}

	public Endereco(Long id) {
		setId(id);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

		if (!(this instanceof Endereco))
			return false;

		Endereco endereco = (Endereco) obj;

		return this.getLogradouro().equals(endereco.getLogradouro()) && this.getNumero() == endereco.getNumero()
				&& this.getCep().equals(endereco.getCep()) && this.getBairro().equals(endereco.getBairro())
				&& this.getCidade().equals(endereco.getCidade()) && this.getEstado().equals(endereco.getEstado())
				&& this.getReferencia().equals(endereco.getReferencia())&& this.getInstituicao().equals(endereco.getInstituicao());
	}
}