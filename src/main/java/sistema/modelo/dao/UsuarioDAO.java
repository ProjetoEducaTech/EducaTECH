package sistema.modelo.dao;
import java.util.List;


import sistema.modelo.entidade.*;


public interface UsuarioDAO {

	void deletarConta(Usuario usuario);
	void atualizarUsuario(Usuario usuario);
	void cadastrarUsuario(Usuario usuario);
	
	List<Usuario> loginAluno(Aluno aluno);
	List<Usuario> loginInstituicao(Instituicao instituicao);
}
