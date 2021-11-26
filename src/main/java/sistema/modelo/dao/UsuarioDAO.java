package sistema.modelo.dao;
//import java.util.List;
import sistema.modelo.entidade.Usuario;


public interface UsuarioDAO {

		void deletarConta(String senha);
		void atualizarNomeUsuario(String cpf, String novoNome);
		void atualizarCpfUsuario(String cpf, String novoCpf);
		void atualizarSenhaUsuario(String cpf, String novaSenha);
		void cadastrarUsuario(Usuario usuario);
		//void favoritarCurso(Usuario usuario, Curso curso);//usuario favoritar cursos 

		//List<Curso> listaCursosFavoritos();//listar cursos favoritos do usuario (join)
}
