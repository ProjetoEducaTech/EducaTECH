package br.com.educatech.casodeuso.deletarendereco;

import br.com.educatech.modelo.dao.endereco.EnderecoDAO;
import br.com.educatech.modelo.entidade.endereco.Endereco;

public class DeletarEnderecoCasoDeUso {

	private EnderecoDAO enderecoDAO;

	public DeletarEnderecoCasoDeUso(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}

	public Endereco deletarEndereco(Endereco endereco) {

		return enderecoDAO.deletarEndereco(endereco);

	}

}
