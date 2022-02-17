package sistema.modelo.dao.endereco;

import java.util.List;

import sistema.modelo.entidade.endereco.Endereco;
import sistema.modelo.entidade.usuario.Usuario;

public interface EnderecoDAO {
	
	void inserirEndereco(Endereco endereco);
	void atualizarEndereco(Endereco endereco);
	void deletarEndereco(Endereco endereco);
	List<Endereco> recuperarEndereco();
	List<Endereco> recuperarEnderecoUsuario(Usuario usuario);

}