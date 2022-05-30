package br.senac.educatech.modelo.dao.foto;

import java.util.List;

import br.senac.educatech.modelo.entidade.foto.Foto;

public interface FotoDAO {

	Long inserirFoto(Foto foto);
	
	void atualizarFoto(Foto foto);
	
	void deletarFoto(Foto foto);
	
	Foto recuperarFotoPeloId(Foto foto);
	
	List<Foto> recuperarFotos();
}
