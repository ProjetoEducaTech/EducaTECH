package sistema.modelo.dao.area;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import sistema.modelo.entidade.*;
import sistema.modelo.entidade.area.Area;

public class AreaDAOImpl {
	public void inserirArea(Area area) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			//insert.setString(1, area.getNome());
			insert = conexao.prepareStatement("insert into area (nome) values (?)");

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

	public void deletarArea(Area area) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("delete from area where id_area = ?");
			//delete.setInt(1, area.getId());

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

	public void atualizarNomeArea(Area area, String nome) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			//update.setString(1, area.getNome());

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

	private Connection conectarBanco() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}

}
