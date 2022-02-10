package sistema.modelo.dao.contato;

import java.util.List;

import sistema.modelo.entidade.contato.Contato;

public interface ContatoDAO {
	
	void cadastrarContato(Contato contato);
	void atualizarContato(Contato contato);
	void deletarContato(Contato contato);
	
	List<Contato> recuperarContatos();
	//Contato recuperarContatoUsuario(Usuario usuario);

}
