package br.com.educatech.casodeuso.atualizararea;

import br.com.educatech.modelo.dao.area.AreaDAO;
import br.com.educatech.modelo.entidade.area.Area;

public class AtualizarAreaCasoDeUso {

	private AreaDAO areaDAO;

	public AtualizarAreaCasoDeUso(AreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}

	public Area atualizarArea(Area area) {

		return areaDAO.atualizarArea(area);

	}

}
