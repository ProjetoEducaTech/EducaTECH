package br.senac.educatech.modelo.dao.area;

import java.util.List;

import br.senac.educatech.modelo.entidade.area.Area;

public interface AreaDAO {

	Long inserirArea(Area area);

	void atualizarArea(Area area);

	void deletarArea(Area area);

	List<Area> recuperarAreas();
	
	Area recuperarAreaPeloId(Area area);
}