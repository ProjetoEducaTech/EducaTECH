package br.com.educatech.casodeuso.deletararea;

import br.com.educatech.modelo.dao.area.AreaDAO;
import br.com.educatech.modelo.entidade.area.Area;

public class DeletarAreaCasoDeUso {

	private AreaDAO areaDAO;

	public DeletarAreaCasoDeUso(AreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}

	public Area deletarArea(Area area) {

		return areaDAO.deletarArea(area);

	}

}
