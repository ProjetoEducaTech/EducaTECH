package sistema.modelo.dao.usuario;

//import java.util.List;

import sistema.modelo.entidade.*;
import sistema.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {

	void deletarConta(Usuario usuario);

	void atualizarUsuario(Usuario usuario);

	void cadastrarUsuario(Usuario usuario);
	
	//List<Usuario> loginAluno();
	
	//List<Usuario> loginInstituicao();
	

	// List<Curso> listaCursosFavoritos(String cpfUsuario);
}
