package br.com.educatech.modelo.entidade.contato;

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

import br.com.educatech.modelo.entidade.aluno.Aluno;
import br.com.educatech.modelo.entidade.instituicao.Instituicao;
import br.com.educatech.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2568928573471678269L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato", nullable = false)
	private Long id;

	@Column(name = "telefone_contato", length = 20, unique = true, nullable = false)
	private String telefone;

	@Column(name = "celular_contato", length = 20, unique = true, nullable = false)
	private String celular;

	@Column(name = "email_contato", length = 40, unique = true, nullable = false)
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_contato")
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

	public Contato(String telefone, String celular, String email, Instituicao instituicao) {
		setTelefone(telefone);
		setCelular(celular);
		setEmail(email);
		setUsuario(instituicao);
	}

	public Contato(String telefone, String celular, String email, Aluno aluno) {
		setTelefone(telefone);
		setCelular(celular);
		setEmail(email);
		setUsuario(aluno);
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

}
