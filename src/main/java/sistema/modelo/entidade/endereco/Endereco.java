package sistema.modelo.entidade.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;


@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;
	
	@Column(name = "logradouro_endereco", length = 50, nullable = false)
	private String logradouro;
	
	@Column(name = "numero_endereco", nullable = false)
	private int numero;
	
	@Column(name = "cep", length = 50, nullable = false)
	private String cep;
	
	@Column(name = "cidade", length = 50, nullable = false)
	private String cidade;
	
	@Column(name = "estado", length = 50, nullable = false)
	private String estado;
	
	@Column(name = "referencia", length = 50, nullable = false)
	private String referencia;
	
	
	public Endereco() {}
	
	public Endereco(String logradouro, int numero,String cep, String cidade, String estado, String referencia) {
		setLogradouro(logradouro);
		setNumero(numero);
		setCep(cep);
		setCidade(cidade);
		setEstado(estado);
		setReferencia(referencia);
	}
	
	public Endereco(Long id, String logradouro, String cep, String cidade, String estado, String referencia) {
		setId(id);
		setLogradouro(logradouro);
		setNumero(numero);
		setCep(cep);
		setCidade(cidade);
		setEstado(estado);
		setReferencia(referencia);
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

}