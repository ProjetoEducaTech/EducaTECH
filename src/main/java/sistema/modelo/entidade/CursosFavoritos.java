package agr_vai;

public class CursosFavoritos {
	
	private int id;
	private String nomeCurso;
	
	public CursosFavoritos(int id, String nomeCurso) {
		setId(id);
		setNomeCurso(nomeCurso);
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

}
