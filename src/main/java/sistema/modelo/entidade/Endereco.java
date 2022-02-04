package sistema.modelo.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
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
	
	@Column(name = "rua_endereco", length = 50, nullable = false)
	private String rua;
	
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
	
	public Endereco(Long id, String rua, String cep, String cidade, String estado, String referencia) {
		setId(id);
		setRua(rua);
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
	 
	 public String getRua() {
		 return rua;
	 }
	 
	 public void setRua(String rua) {
		 this.rua = rua;
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
