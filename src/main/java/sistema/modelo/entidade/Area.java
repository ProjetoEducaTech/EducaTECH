package sistema.modelo.entidade;

public class Area {

	private int id;
	private String nome;

	public Area(int id, String nome) {
		setId(id);
		setNome(nome);
	}

	public Area(String nome) {
		setNome(nome);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}