package br.senac.educatech.modelo.entidade.foto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.educatech.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "foto")
public class Foto implements Serializable {
	
	
	private static final long serialVersionUID = -4351007305966822535L;

	@Id
	@Column(name = "id_foto")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Lob
	@Column(name = "conteudo_foto")
	private byte[] conteudo;

	@Column(name = "extensao_foto")
	private String extensao;

	public Foto() {}
	
	public Foto(Long id, byte[] conteudo, String extensao, Usuario usuario) {
		setId(id);
		setConteudo(conteudo);
		setExtensao(extensao);
	}
	
	public Foto(byte[] conteudo, String extensao, Usuario usuario) {
		setConteudo(conteudo);
		setExtensao(extensao);
		setUsuario(usuario);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}
	
	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}