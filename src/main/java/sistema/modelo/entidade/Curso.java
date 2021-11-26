package sistema.modelo.entidade;
import java.util.ArrayList;
import java.util.List;

public class Curso {

	private int id;
	private float notaCorte;
	private String nomeCurso;
	private Area area;
	private Instituicao instituicao;
	private List<Usuario> usuariosFavoritos;// Lista de alunos que favoritam o curso

	public Curso(int id, float notaCorte, String nomeCurso, Area area, Instituicao instituicao) {

		setId(id);
		setNotaCorte(notaCorte);
		setNomeCurso(nomeCurso);
		setArea(area);
		setInstituicao(instituicao);

		usuariosFavoritos = new ArrayList<Usuario>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getNotaCorte() {
		return notaCorte;
	}

	public void setNotaCorte(float notaCorte) {
		this.notaCorte = notaCorte;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public void adicionarUsuarioFavorito(Usuario usuario) {
		usuariosFavoritos.add(usuario);
	}

	public List<Usuario> recuperarUsuariosFavoritos() {
		return usuariosFavoritos;
	}
}