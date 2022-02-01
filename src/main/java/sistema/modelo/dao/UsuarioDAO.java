package sistema.modelo.dao;
import java.util.List;


import sistema.modelo.entidade.*;


public interface UsuarioDAO {

	void deletarConta(Usuario usuario);
	void atualizarNomeUsuario( String novoNome);
	//void atualizarCpfUsuario( String novoCpf);
	void atualizarSenhaUsuario(String novaSenha);
	void cadastrarUsuario(Usuario usuario);
	

	//List<Curso> listaCursosFavoritos(String cpfUsuario);
	//void favoritarCurso(String cpfUsuario, int idCurso);
}
