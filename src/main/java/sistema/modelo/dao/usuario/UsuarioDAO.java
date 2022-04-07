package sistema.modelo.dao.usuario;

import java.util.List;
import sistema.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {

	void deletarConta(Usuario usuario);

	void atualizarUsuario(Usuario usuario);

	void inserirUsuario(Usuario usuario);

	List<Usuario> recuperarUsuario();

}