package sistema.modelo.dao;

import java.util.List;

import sistema.modelo.entidade.Contato;
import sistema.modelo.entidade.Usuario;

public interface ContatoDAO {
	
	void cadastrarContato(Contato contato);
	void deletarContato(Contato contato);
	void atualizaContato(Contato contato);
	
	List<Contato> recuperarContatos();

	Contato recuperarContatoCliente(Usuario usuario);

}
