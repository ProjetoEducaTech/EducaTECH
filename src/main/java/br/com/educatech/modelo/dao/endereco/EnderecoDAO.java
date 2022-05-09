package br.com.educatech.modelo.dao.endereco;

import java.util.List;

import br.com.educatech.modelo.entidade.endereco.Endereco;
import br.com.educatech.modelo.entidade.instituicao.Instituicao;

public interface EnderecoDAO {

	Endereco inserirEndereco(Endereco endereco);

	Endereco atualizarEndereco(Endereco endereco);

	Endereco deletarEndereco(Endereco endereco);

	Endereco recuperarPorEnderecoInstituicao(Instituicao instituicao);

	Endereco recuperarEnderecoPorId(Endereco endereco);
	
	List<Endereco> recuperarEndereco();

}
