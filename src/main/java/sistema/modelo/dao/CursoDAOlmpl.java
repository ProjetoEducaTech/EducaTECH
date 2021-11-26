package sistema.modelo.dao;

import sistema.modelo.entidade.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistema.modelo.entidade.Curso;

public class CursoDAOlmpl implements CursoDAO {

	public void inserirCurso(Curso curso) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();

			insert = conexao
					.prepareStatement("insert into curso (notaCorte,nomeCurso, area, instituicao) values (?,?,?,?)");
			insert.setFloat(1, curso.getNotaCorte());
			insert.setString(2, curso.getNomeCurso());
			insert.setInt(3, curso.getArea().getId());
			insert.setInt(4, curso.getInstituicao().getId());

			insert.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (insert != null)
					insert.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}

	public void deletarCurso(Curso curso) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("delete from curso where id_curso = ?");

			delete.setInt(1, curso.getId());

			delete.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();

		}

		finally {

			try {

				if (delete != null)
					((Statement) delete).close();

				if (conexao != null)
					conexao.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}

	}

	public void atualizarNotaCorteCurso(Curso curso, float notaCorte) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("update curso set notaCorte = ? where id_curso = ?");

			update.setFloat(1, notaCorte);
			update.setInt(2, curso.getId());
			update.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();

		}

		finally {

			try {

				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}

	}

	public void atualizarNomeCurso(Curso curso, String nomeCurso) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("update curso set nomeCurso = ? where id_curso = ?");

			update.setString(1, nomeCurso);
			update.setInt(2, curso.getId());
			update.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();

		}

		finally {

			try {

				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}

	}

	public List<Curso> recuperarCursos() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curso> cursos = new ArrayList<Curso>();

		try {

			conexao = conectarBanco();

			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM Curso");

			while (resultado.next()) {

				int id = resultado.getInt("id_curso");
				float notaCorte = resultado.getFloat("notaCorte");
				String nomeCurso = resultado.getString("nomeCurso");
				String nomeArea = resultado.getString("area");
				int idInstituicao = resultado.getInt("instituicao");

				cursos.add(new Curso(id, notaCorte, nomeCurso, new Area(nomeArea), new Instituicao(idInstituicao)));
			}

		} catch (SQLException erro) {
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

		return cursos;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}
