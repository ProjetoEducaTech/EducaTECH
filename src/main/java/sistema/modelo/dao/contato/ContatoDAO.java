package sistema.modelo.dao.contato;

import java.util.List;

import sistema.modelo.entidade.contato.Contato;
import sistema.modelo.entidade.usuario.Usuario;

public interface ContatoDAO {
	
	void inserirContato(Contato contato);
	void atualizarContato(Contato contato);
	void deletarContato(Contato contato);
	
	List<Contato> recuperarContatos();
	Contato recuperarContatoUsuario(Usuario usuario);
}