package br.senac.educatech.modelo.dto.avaliacao;

public class AvaliacaoDTO {

	private String nome;
	private String sobrenome;
	private String pronome;
	private String foto;
	private String extensao;
	private String comentario;
	private int nota;
	private String data;
	private Long id;

	public AvaliacaoDTO(String nome, String sobrenome, String pronome, String foto, String extesao, String comentario, int nota, String data, Long id) {
		setNome(nome);
		setSobrenome(sobrenome);
		setPronome(pronome);
		setFoto(foto);
		setExtensao(extesao);
		setComentario(comentario);
		setNota(nota);
		setData(data);
		setId(id);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getPronome() {
		return pronome;
	}

	public void setPronome(String pronome) {
		this.pronome = pronome;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}