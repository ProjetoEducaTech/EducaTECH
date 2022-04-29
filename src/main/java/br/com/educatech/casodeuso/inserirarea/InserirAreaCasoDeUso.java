package br.com.educatech.casodeuso.inserirarea;

import br.com.educatech.modelo.dao.area.AreaDAO;
import br.com.educatech.modelo.entidade.area.Area;

public class InserirAreaCasoDeUso {

	private AreaDAO areaDAO;

	public InserirAreaCasoDeUso(AreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}

	public Area inserirArea(Area area) {

		return areaDAO.inserirArea(area);

	}

}
