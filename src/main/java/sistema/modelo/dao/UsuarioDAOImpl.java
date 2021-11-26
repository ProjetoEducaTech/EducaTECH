package sistema.modelo.dao;

import sistema.modelo.entidade.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
;


public class UsuarioDAOImpl implements UsuarioDAO {
	
	public void cadastrarUsuario(Usuario usuario) {
		
		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO usuario (nome_usuario, cpf_usuario, senha_usuario ) VALUES (?,?,?)");

			insert.setString(1, usuario.getNome());
			insert.setString(2, usuario.getCpf());
			insert.setString(3, usuario.getSenha());
			
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
	
public void deletarConta(String senha) {
		
		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM usuario WHERE senha_usuario = ?");

			delete.setString(1, senha);

			delete.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

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

public void atualizarNomeUsuario(String cpf, String novoNome) {
	
	Connection conexao = null;
	PreparedStatement update = null;

	try {

		conexao = conectarBanco();
		update = conexao.prepareStatement("UPDATE usuario SET nome_usuario = ? WHERE cpf_usuario = ?");
		
		update.setString(1, novoNome);
		update.setString(2, cpf);

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

		} catch (SQLException erro) {

			erro.printStackTrace();
		}
	}
}

public void atualizarCpfUsuario(String cpf, String novoCpf) {
	
	Connection conexao = null;
	PreparedStatement update = null;

	try {

		conexao = conectarBanco();
		update = conexao.prepareStatement("UPDATE usuario SET cpf_usuario = ? WHERE cpf_usuario = ?");
		
		update.setString(1, novoCpf);
		update.setString(2, cpf);

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

		} catch (SQLException erro) {

			erro.printStackTrace();
		}
	}
}

public void atualizarSenhaUsuario(String cpf, String novaSenha) {
	
	Connection conexao = null;
	PreparedStatement update = null;

	try {

		conexao = conectarBanco();
		update = conexao.prepareStatement("UPDATE usuario SET senha_usuario = ? WHERE cpf_usuario = ?");
		
		update.setString(1, novaSenha);
		update.setString(2, cpf);

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

		} catch (SQLException erro) {

			erro.printStackTrace();
		}
	}
}

public void favoritarCurso(String cpf, String idCurso) {
	
	Connection conexao = null;
	PreparedStatement update = null;

	try {

		conexao = conectarBanco();
		update = conexao.prepareStatement("INSERT INTO usuario_favorita_curso ( cpf_usuario, id_curso ) VALUES (?,?)");
		
		update.setString(1, cpf);
		update.setString(2, idCurso);

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

		} catch (SQLException erro) {

			erro.printStackTrace();
		}
	}
}
	

private Connection conectarBanco() throws SQLException {
	return DriverManager.getConnection("jdbc:mysql://localhost/db_atualizado?user=root&password=4b96d5c1jp36&useTimezone=true&serverTimezone=UTC");
}





//public List<Curso> listaCursosFavoritos() {
	// TODO Auto-generated method stub
	//return null;
//}
}

