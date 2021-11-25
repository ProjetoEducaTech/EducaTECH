
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class InstituicaoDAOImpl implements InstituicaoDAO {

	public void inserirInstituicao(Instituicao instituicao) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();

			insert = conexao.prepareStatement("insert into instituicao (nome) values (?)");
			insert.setString(1, instituicao.getNome());
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

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}

	public void deletarInstituicao(Instituicao instituicao) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();

			delete = conexao.prepareStatement("delete from instituicao where id_instituicao = ?");
			delete.setInt(1, instituicao.getId());
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

	public void atualizarNomeInstituicao(Instituicao instituicao, String nome) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("update instituicao set nome  = ? where id_instituicao = ?");

			update.setString(1, nome);
			update.setInt(2, instituicao.getId());
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

	public Instituicao recuperarInstituicao(Instituicao instituicao) {

		Connection conexao = null;
		PreparedStatement select = null;
		Instituicao instituicaoRetornada = null;
		ResultSet resultado = null;

		try {

			conexao = conectarBanco();

			select = conexao.prepareStatement("select * from instituicao where id_instituicao = ?");
			select.setInt(1, instituicao.getId());
			resultado = select.executeQuery();

			while (resultado.next()) {

				int id = resultado.getInt("id_instituicao");
				String nome = resultado.getString("nome_instituicao");

				instituicaoRetornada = new Instituicao(id, nome);
			}

		} catch (SQLException erro) {
			erro.printStackTrace();

		}

		finally {

			try {

				if (select != null)
					select.close();

				if (conexao != null)
					conexao.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
		
		return instituicaoRetornada;
	}

	public List<Instituicao> recuperarInstituicoes() {
		// TODO Auto-generated method stub
		return null;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}

}