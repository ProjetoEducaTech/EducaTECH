package agr_vai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursosFavoritosDAOImpl implements CursosFavoritosDAO {
	
	private static final List<CursosFavoritos> CursosFavoritos = null;

	public List<CursosFavoritos> recuperarCursosFavoritos(String cpfUsuario) {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<CursosFavoritos> cursos = new ArrayList<CursosFavoritos>();

		try {

			conexao = conectarBanco();

			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT usuario_favorita_curso.cpf_usuario, usuario_favorita_curso.id_curso, curso.nome_curso  FROM usuario_favorita_curso  INNER JOIN curso  ON usuario_favorita_curso.id_curso = curso.id_curso  INNER JOIN usuario ON usuario.cpf_usuario = usuario_favorita_curso.cpf_usuario WHERE usuario.cpf_usuario  = usuario_favorita_curso.cpf_usuario = ?");
			
			resultado.updateString(1, cpfUsuario);
		

			while (resultado.next()) {

				int id = resultado.getInt("id_curso");
				
				String nomeCurso = resultado.getString("nome_curso");


				cursos.add(new CursosFavoritos(id, nomeCurso));
			

		} 
		}catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (resultado != null)
					resultado.close();

				if (consulta != null)
					consulta.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}

		return CursosFavoritos;
	}
	
	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/db_atualizado?user=root&password=4b96d5c1jp36&useTimezone=true&serverTimezone=UTC");
	}
}
