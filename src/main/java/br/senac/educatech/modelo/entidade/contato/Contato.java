package br.senac.educatech.modelo.entidade.contato;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.educatech.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 2568928573471678269L;

	@Id
	@Column(name = "id_contato")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Column(name = "telefone_contato", length = 16, unique = true, nullable = false)
	private String telefone;

	@Column(name = "celular_contato", length = 16, unique = true, nullable = false)
	private String celular;

	@Column(name = "email_contato", length = 40, unique = true, nullable = false)
	private String email;

	public Contato() {}

	public Contato(Long id, String telefone, String celular, String email, Usuario usuario) {
		setId(id);
		setTelefone(telefone);
		setCelular(celular);
		setEmail(email);
		setUsuario(usuario);
	}

	public Contato(String telefone, String celular, String email, Usuario usuario) {
		setTelefone(telefone);
		setCelular(celular);
		setEmail(email);
		setUsuario(usuario);
	}

	public Contato(Long id) {
		setId(id);
	}
	
	public Contato(String email) {
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