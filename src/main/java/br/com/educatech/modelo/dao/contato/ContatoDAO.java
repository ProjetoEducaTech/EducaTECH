package br.com.educatech.modelo.dao.contato;

import java.util.List;

import br.com.educatech.modelo.entidade.contato.Contato;
import br.com.educatech.modelo.entidade.usuario.Usuario;

public interface ContatoDAO {

	Contato inserirContato(Contato contato);

	Contato atualizarContato(Contato contato);

	Contato deletarContato(Contato contato);

	Contato recuperarPorContatoUsuario(Usuario usuario);

	List<Contato> recuperarContato();
	
	Contato recuperarContatoPorId(Contato contato);

}
