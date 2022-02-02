package sistema.modelo.dao;
import sistema.modelo.entidade.*;

public interface AreaDAO {
	
	void inserirArea(Area area);
	void deletarArea(Area area);
	void atualizarNomeArea(Area area, String nome);

}
