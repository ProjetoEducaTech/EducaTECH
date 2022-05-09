package br.com.educatech.casodeuso.deletarUsuario;

import br.com.educatech.modelo.dao.usuario.UsuarioDAO;
import br.com.educatech.modelo.entidade.usuario.Usuario;

public class DeletarUsuarioCasoDeUso {

	private UsuarioDAO usuarioDAO;

	public DeletarUsuarioCasoDeUso(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public Usuario deletarUsuario(Usuario usuario) {

		return usuarioDAO.deletarUsuario(usuario);

	}

}
