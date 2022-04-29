package br.com.educatech.modelo.dao.usuario;

import java.util.List;

import br.com.educatech.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {

	void inserirUsuario(Usuario usuario);

	void atualizarUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	Usuario loginUsuario(String email, String senha);

	List<Usuario> recuperarUsuario();

}
