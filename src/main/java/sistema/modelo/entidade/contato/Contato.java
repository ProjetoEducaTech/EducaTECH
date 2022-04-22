package sistema.modelo.entidade.contato;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sistema.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Long id;

	@Column(name = "telefone_contato", length = 20, nullable = true, unique = true)
	private String telefone;

	@Column(name = "celular_contato", length = 20, nullable = false, unique = true)
	private String celular;

	@Column(name = "email_contato", length = 40, nullable = false, unique = true)
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Contato() {
	}

	public Contato(String telefone, String celular, String email) {
		setTelefone(telefone);
		setCelular(celular);
		setEmail(email);
	}

	public Contato(Long id, String telefone, String celular, String email) {
		setId(id);
		setTelefone(telefone);
		setCelular(celular);
		setEmail(email);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(this instanceof Contato))
			return false;

		Contato contato = (Contato) obj;

		return this.getId().equals(contato.getId()) && this.getTelefone().equals(contato.getTelefone())
				&& this.getCelular().equals(contato.getCelular()) && this.getEmail().equals(contato.getEmail())
				&& this.getUsuario().equals(contato.getUsuario());
	}
}