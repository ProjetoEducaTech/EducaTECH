package sistema.modelo.dao;

import sistema.modelo.entidade.Endereco;

public interface EnderecoDAO {
	
	void cadastrarEndereco(Endereco endereco);
	void atualizarEndereco(Endereco endereco);
	void deletarEndereco(Endereco endereco);
	

}
