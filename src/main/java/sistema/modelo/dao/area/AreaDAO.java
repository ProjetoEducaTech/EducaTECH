package sistema.modelo.dao.area;

import java.util.List;

import sistema.modelo.entidade.area.Area;
import sistema.modelo.entidade.curso.Curso;

public interface AreaDAO {
	
	void inserirArea(Area area);
	
	void deletarArea(Area area);
	
	void atualizarArea(Area area);
	
	List<Curso> consultaAreaCurso(Area area);
}