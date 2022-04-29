package br.com.educatech.modelo.entidade.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.educatech.modelo.entidade.contato.Contato;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", length = 14, unique = true, nullable = false)
	private Long id;

	@Column(name = "nome_usuario", length = 25, nullable = false)
	private String nome;

	@Column(name = "senha_usuario", length = 32, nullable = false)
	private String senha;

	@Lob
	@Column(name = "sal_usuario", unique = true, nullable = false, updatable = false)
	private byte[] sal;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contato> contatos = new ArrayList<>();

	public Usuario() {
	}

	public Usuario(String nome, String senha, byte[] sal) {
		setNome(nome);
		setSenha(senha);
		setSal(sal);
	}

	public Usuario(Long id, String nome, String senha, byte[] sal) {
		setId(id);
		setNome(nome);
		setSenha(senha);
		setSal(sal);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public byte[] getSal() {
		return sal;
	}

	public void setSal(byte[] sal) {
		this.sal = sal;
	}

}
