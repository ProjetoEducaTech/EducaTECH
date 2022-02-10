package sistema.modelo.dao.endereco;

import sistema.modelo.entidade.endereco.Endereco;

public interface EnderecoDAO {
	
	void cadastrarEndereco(Endereco endereco);
	void atualizarEndereco(Endereco endereco);
	void deletarEndereco(Endereco endereco);
	

}
