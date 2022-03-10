package sistema.modelo.entidade.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sistema.modelo.entidade.instituicao.Instituicao;


@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "logradouro_endereco", length = 45, nullable = false)
	private String logradouro;
	
	@Column(name = "numero_endereco", nullable = false)
	private int numero;
	
	@Column(name = "cep_endereco", length = 45, nullable = false)
	private String cep;
	
	@Column(name = "bairro_endereco", length = 45, nullable = false)
	private String bairro;
	
	@Column(name = "cidade_endereco", length = 45, nullable = false)
	private String cidade;
	
	@Column(name = "estado_endereco", length = 45, nullable = false)
	private String estado;
	
	@Column(name = "referencia_endereco", length = 45, nullable = false)
	private String referencia;
	

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_usuario", nullable = false)
	private Instituicao instituicao;
	
	public Endereco() {}
	
	public Endereco(String logradouro, int numero,String cep, String bairro, String cidade, String estado, String referencia, Instituicao instituicao) {
		setLogradouro(logradouro);
		setNumero(numero);
		setCep(cep);
		setBairro (bairro);
		setCidade(cidade);
		setEstado(estado);
		setReferencia(referencia);
		setInstituicao(instituicao);
	}
	
	public Endereco(Long id, String logradouro, String cep, String bairro, String cidade, String estado, String referencia, Instituicao instituicao) {
		setId(id);
		setLogradouro(logradouro);
		setNumero(numero);
		setCep(cep);
		setBairro (bairro);
		setCidade(cidade);
		setEstado(estado);
		setReferencia(referencia);
		setInstituicao(instituicao);
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
	 
	 public String getBairro() {
		 return bairro;
	 }
	 
	 public void setBairro(String bairro) {
		 this.bairro = bairro;
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

	 public Instituicao getInstituicao() {
			return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
			this.instituicao = instituicao;
	}
}