package sistema.modelo.dao;

import java.util.List;

import sistema.modelo.entidade.Contato;
import sistema.modelo.entidade.Usuario;

public interface ContatoDAO {
	
	void cadastrarContato(Contato contato);
	void atualizarContato(Contato contato);
	void deletarContato(Contato contato);
	
	List<Contato> recuperarContatos();
	Contato recuperarContatoUsuario(Usuario usuario);

}
