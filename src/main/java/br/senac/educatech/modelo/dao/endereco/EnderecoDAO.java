package br.senac.educatech.modelo.dao.endereco;

import java.util.List;

import br.senac.educatech.modelo.entidade.endereco.Endereco;
import br.senac.educatech.modelo.entidade.instituicao.Instituicao;

public interface EnderecoDAO {

	Long inserirEndereco(Endereco endereco);

	void atualizarEndereco(Endereco endereco);

	void deletarEndereco(Endereco endereco);

	Endereco recuperarEnderecoPelaInstituicao(Instituicao instituicao);

	Endereco recuperarEnderecoPeloId(Endereco endereco);
	
	List<Endereco> recuperarEnderecos();

}