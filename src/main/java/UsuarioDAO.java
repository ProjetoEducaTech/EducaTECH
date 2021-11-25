import java.util.List;

public interface UsuarioDAO {

void cadastrarUsuario(Usuario usuario);//cadastro de usuario
void deletarConta(Usuario usuario);
void atualizarNomeUsuario(Usuario usuario, String novoNome);
void atualizarCpfUsuario(Usuario usuario, String novoCpf);
void atualizarSenhaUsuario(Usuario usuario, String novaSenha);
void favoritarCurso(Usuario usuario, Curso curso);//usuario favoritar cursos 

List<Curso> listaCursosFavoritos();//listar cursos favoritos do usuario (join)
}
