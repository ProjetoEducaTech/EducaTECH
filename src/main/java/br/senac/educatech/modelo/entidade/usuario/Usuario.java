package br.senac.educatech.modelo.entidade.usuario;

import java.io.Serializable;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.educatech.modelo.entidade.contato.Contato;
import br.senac.educatech.modelo.entidade.foto.Foto;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 6644934388433828388L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "nome_usuario", length = 25, nullable = false)
	private String nome;

	@Column(name = "senha_usuario", length = 32, nullable = false)
	private String senha;

	@Lob
	@Column(name = "sal_usuario", unique = true, nullable = false, updatable = false)
	private byte[] sal;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Contato contato;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Foto foto;

	public Usuario() {}

	public Usuario(Long id, String nome, String senha, byte[] sal, Foto foto) {
		setId(id);
		setNome(nome);
		setSenha(senha);
		setSal(sal);
		setFoto(foto);
	}

	public Usuario(String nome, String senha, byte[] sal, Foto foto) {
		setNome(nome);
		setSenha(senha);
		setSal(sal);
		setFoto(foto);
	}
	
	public Usuario(Long id, String nome, String senha, byte[] sal) {
		setId(id);
		setNome(nome);
		setSenha(senha);
		setSal(sal);
	}

	public Usuario(Long id) {
		setId(id);
	}
	
	public Usuario(String senha) {
		setSenha(senha);
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

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(this instanceof Usuario))
			return false;

		Usuario usuario = (Usuario) obj;

		return this.getId().equals(usuario.getId()) && this.getNome().equals(usuario.getNome())
				&& this.getSenha().equals(usuario.getSenha());
	}
}