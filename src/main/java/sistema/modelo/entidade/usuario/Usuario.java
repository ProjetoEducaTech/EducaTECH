package sistema.modelo.entidade.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", length = 14, nullable = false, unique = true)
	private Long id;

	@Column(name = "nome_usuario", length = 25, nullable = false, unique = false)
	private String nome;

	@Column(name = "senha_usuario", length = 20, nullable = false, unique = false)
	private String senha;

	public Usuario() {
	}

	public Usuario(String nome, String senha) {

		setNome(nome);
		setSenha(senha);
	}

	public Usuario(Long id, String nome, String senha) {

		setId(id);
		setNome(nome);
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

	@Override
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