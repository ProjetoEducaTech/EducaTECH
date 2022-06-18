package br.senac.educatech.modelo.dto.usuario;

public class UsuarioDTO {

	private Long id;
	private String foto;
	private String extensao;

	public UsuarioDTO(Long id, String foto, String extensao) {
		setId(id);
		setFoto(foto);
		setExtensao(extensao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
}