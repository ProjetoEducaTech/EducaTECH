package br.com.educatech.casodeuso.recuperarporendereco;

import java.util.List;

import br.com.educatech.modelo.dao.endereco.EnderecoDAO;
import br.com.educatech.modelo.entidade.endereco.Endereco;

public class RecuperarPorEnderecoCasoDeUso {

	private EnderecoDAO enderecoDAO;

	public void RecuperarEnderecoCasoDeUso(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}

	public List<Endereco> recuperarEndereco() {

		return enderecoDAO.recuperarEndereco();

	}

}
