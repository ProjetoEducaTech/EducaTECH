import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	public void cadastrarUsuario(Usuario usuario) {
		
		Connection conexao = null;
		PreparedStatement insert = null;
		
		try {
			
			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO cliente (nome_usuario, cpf, senha ) VALUES (?,?,?)");
			insert.setString(1, usuario.getNome());
			insert.setString(2, usuario.getCpf());
			insert.setString(3, usuario.getSenha());
			insert.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
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

	public void deletarConta(Usuario usuario) {
		Connection conexao = null;
		PreparedStatement delete = null;
		try {
			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM cliente WHERE cpf = ?");
			delete.setString(1, usuario.getCpf());
			delete.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (delete != null)
					delete.close();
				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public void atualizarNomeUsuario(Usuario usuario, String novoNome) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente SET nome_cliente = ? WHERE cpf = ?");
			update.setString(1, novoNome);
			update.setString(2, usuario.getCpf());
			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();
				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public void atualizarCpfUsuario(Usuario cliente, String novoCpf) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente SET cpf_cliente = ? WHERE cpf = ?");
			update.setString(1, novoCpf);
			update.setString(2, cliente.getCpf());
			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();
				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public void atualizarSenhaUsuario(Usuario cliente, String novaSenha) {
		Connection conexao = null;
		PreparedStatement update = null;
		try {
			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente SET set = ? WHERE cpf = ?");
			update.setString(1, novaSenha);
			update.setString(2, cliente.getCpf());
			update.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			try {
				if (update != null)
					update.close();
				if (conexao != null)
					conexao.close();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}

	public void favoritarCurso(Usuario usuario, Curso curso) {

	}

	public List<Curso> listaCursosFavoritos() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curso> cursosFavoritos = new ArrayList<Curso>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curso ");// join

			while (resultado.next()) {

				int id = resultado.getInt("id_curso");
				float notaCorte = resultado.getFloat("notaCorte");
				String nomeCurso = resultado.getString("nomeCurso");
				String nomeArea = resultado.getString("area");
				int idInstituicao = resultado.getInt("instituicao");

				cursosFavoritos
						.add(new Curso(id, notaCorte, nomeCurso, new Area(nomeArea), new Instituicao(idInstituicao)));
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

		return cursosFavoritos;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}
