package br.com.educatech.modelo.dao.usuario;

import java.util.List;

import br.com.educatech.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {

	void inserirUsuario(Usuario usuario);

	void atualizarUsuario(Usuario usuario);

	Usuario deletarUsuario(Usuario usuario);

	Usuario loginUsuario(String email, String senha);
	
	Usuario recuperarUsuarioPorId(Usuario usuario);

	List<Usuario> recuperarUsuario();

}
