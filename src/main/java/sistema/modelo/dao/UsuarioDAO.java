package sistema.modelo.dao;
import java.util.List;


import sistema.modelo.entidade.*;


public interface UsuarioDAO {

	void deletarConta(String cpf);
	void atualizarNomeUsuario(String cpf, String novoNome);
	void atualizarCpfUsuario(String cpf, String novoCpf);
	void atualizarSenhaUsuario(String cpf, String novaSenha);
	void cadastrarUsuario(Usuario usuario);
	

	List<Curso> listaCursosFavoritos(String cpfUsuario);
	void favoritarCurso(String cpfUsuario, int idCurso);
}
