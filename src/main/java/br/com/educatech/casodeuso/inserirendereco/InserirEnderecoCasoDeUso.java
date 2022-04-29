package br.com.educatech.casodeuso.inserirendereco;

import br.com.educatech.modelo.dao.endereco.EnderecoDAO;
import br.com.educatech.modelo.entidade.endereco.Endereco;

public class InserirEnderecoCasoDeUso {

	private EnderecoDAO enderecoDAO;

	public InserirEnderecoCasoDeUso(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}

	public Endereco inserirEndereco(Endereco endereco) {

		return enderecoDAO.inserirEndereco(endereco);

	}

}
