package agr_vai;

import java.util.List;

public interface CursosFavoritosDAO {
	
	List<CursosFavoritos> recuperarCursosFavoritos(String cpfUsuario);

}
