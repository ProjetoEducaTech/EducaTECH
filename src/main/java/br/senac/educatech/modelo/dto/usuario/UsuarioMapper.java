package br.senac.educatech.modelo.dto.usuario;

import br.senac.educatech.modelo.entidade.usuario.Usuario;
import br.senac.educatech.util.foto.ConversorFoto;

public class UsuarioMapper {

	public UsuarioDTO paraDTO(Usuario usuario) {

		Long id = usuario.getId();
		String foto = ConversorFoto.converterByteParaBase64(usuario.getFoto());
		String extensao = usuario.getFoto().getExtensao();

		return new UsuarioDTO(id, foto, extensao);
	}
}