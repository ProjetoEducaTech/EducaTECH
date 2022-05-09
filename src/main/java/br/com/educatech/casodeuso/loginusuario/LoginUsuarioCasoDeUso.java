package br.com.educatech.casodeuso.loginusuario;

import br.com.educatech.modelo.dao.usuario.UsuarioDAO;
import br.com.educatech.modelo.entidade.usuario.Usuario;

public class LoginUsuarioCasoDeUso {

	private UsuarioDAO usuarioDAO;

	public LoginUsuarioCasoDeUso(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public Usuario loginUsuario(String email, String senha) {

		return usuarioDAO.loginUsuario(email, senha);

	}

}
