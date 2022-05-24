package br.senac.educatech.modelo.dao.contato;

import java.util.List;

import br.senac.educatech.modelo.entidade.contato.Contato;
import br.senac.educatech.modelo.entidade.usuario.Usuario;

public interface ContatoDAO {

	Contato inserirContato(Contato contato);

	void atualizarContato(Contato contato);

	void deletarContato(Contato contato);

	Contato recuperarContatoPeloUsuario(Usuario usuario);

	List<Contato> recuperarContatos();

	Contato recuperarContatoPeloId(Contato contato);

}