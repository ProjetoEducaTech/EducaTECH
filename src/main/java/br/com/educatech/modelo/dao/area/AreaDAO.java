package br.com.educatech.modelo.dao.area;

import java.util.List;

import br.com.educatech.modelo.entidade.area.Area;

public interface AreaDAO {

	Area inserirArea(Area area);

	Area atualizarArea(Area area);

	Area deletarArea(Area area);

	List<Area> recuperarArea();
	
	Area recuperarAreaPorId(Area area);

}
