package sistema.modelo.entidade;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nome;
	private String cpf;
	private String senha;
	private List<Curso> cursosFavoritos;
	
	public Usuario(String senha, String cpf,String nome ) {
		
		setCpf(cpf);
		setSenha(senha);
		setNome(nome);
		
		cursosFavoritos = new ArrayList<Curso>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/*public boolean inserirCursoFavorito(Curso cursosFavoritos) {
		return cursosFavoritos.add;
	}*/

	public List<Curso> recuperarCursosFavoritos() {
		return cursosFavoritos;
	}

}
