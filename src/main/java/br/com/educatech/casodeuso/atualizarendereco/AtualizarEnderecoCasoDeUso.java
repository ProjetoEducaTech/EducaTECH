package br.com.educatech.casodeuso.atualizarendereco;

import br.com.educatech.modelo.dao.endereco.EnderecoDAO;
import br.com.educatech.modelo.entidade.endereco.Endereco;

public class AtualizarEnderecoCasoDeUso {

	private EnderecoDAO enderecoDAO;

	public AtualizarEnderecoCasoDeUso(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}

	public Endereco atualizarEndereco(Endereco endereco) {

		return enderecoDAO.atualizarEndereco(endereco);

	}

}
