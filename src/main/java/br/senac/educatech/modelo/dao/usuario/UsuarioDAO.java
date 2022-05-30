package br.senac.educatech.modelo.dao.usuario;

import java.util.List;

import br.senac.educatech.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {

	Long inserirUsuario(Usuario usuario);

	void atualizarUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	Usuario loginUsuario(String email, String senha);
	
	Usuario recuperarUsuarioPeloId(Usuario usuario);

	List<Usuario> recuperarUsuarios();
}