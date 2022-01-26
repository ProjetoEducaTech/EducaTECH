package sistema.modelo.entidade;
import java.util.ArrayList;

import java.util.List;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cpf_usuario" , length = 14, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "nome_usuario", length = 25, nullable = false, unique = false)
	private String nome;
	
	@Column(name = "senha_usuario", length = 20, nullable = false, unique = false)
	private String senha;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "crusos_favoritos", joinColumns = @JoinColumn(name = "cpf_usuario"), inverseJoinColumns = @JoinColumn(name = "id_curso"))
	private List<Curso> cursosFavoritos;
	
	public Usuario() {}
	
	public Usuario(String cpf, String nome,String senha ) {
		
		setCpf(cpf);
		setNome(nome);
		setSenha(senha);
		
		cursosFavoritos = new ArrayList<Curso>();
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	public List<Curso> recuperarCursosFavoritos() {
		return cursosFavoritos;
	}
	
	public void inserirCursoFavorito(Curso cursosFavoritos) {
		 this.cursosFavoritos.add(cursosFavoritos);
	}

	

}
