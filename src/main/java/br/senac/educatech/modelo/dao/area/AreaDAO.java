package br.senac.educatech.modelo.dao.area;

import java.util.List;

import br.senac.educatech.modelo.entidade.area.Area;
import br.senac.educatech.modelo.entidade.curso.Curso;
import br.senac.educatech.modelo.entidade.instituicao.Instituicao;

public interface AreaDAO {

	Long inserirArea(Area area);

	void atualizarArea(Area area);

	void deletarArea(Area area);

	List<Area> recuperarAreas();
	
	Area recuperarAreaPeloId(Area area);
	
	Area recuperarAreaPeloCurso(Curso curso);
	
	List<Area> recuperarAreasPelaInstituicao(Instituicao instituicao);
}