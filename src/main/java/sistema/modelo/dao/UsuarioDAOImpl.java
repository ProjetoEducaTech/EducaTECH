package sistema.modelo.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import sistema.modelo.entidade.Area;
import sistema.modelo.entidade.Curso;
import sistema.modelo.entidade.Instituicao;
import sistema.modelo.entidade.Usuario;


public class UsuarioDAOImpl implements UsuarioDAO {
	
	public void cadastrarUsuario(Usuario usuario) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(usuario);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void deletarConta(Usuario usuario) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(usuario);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void atualizarNomeUsuario(String novoNome) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(novoNome);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	/*public void atualizarCpfUsuario(String cpf, String novoCpf) {

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
	} */

	public void atualizarSenhaUsuario(String novaSenha) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(novaSenha);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void favoritarCurso(String cpfUsuario, int idCurso) {
		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO usuario_favorita_curso ( cpf_usuario, id_curso ) VALUES (?,?)");

			insert.setString(1, cpfUsuario);
			insert.setInt(2, idCurso);

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

	public List<Curso> listaCursosFavoritos(String cpfUsuario) {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curso> cursosFavoritos = new ArrayList<Curso>();

		try {

			conexao = conectarBanco();

			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(
					"SELECT usuario_favorita_curso.cpf_usuario, usuario_favorita_curso.id_curso, curso.nome_curso  \r\n"
					+ "FROM usuario_favorita_curso  \r\n"
					+ "INNER JOIN curso  ON usuario_favorita_curso.id_curso = curso.id_curso  \r\n"
					+ "INNER JOIN usuario ON usuario.cpf_usuario = usuario_favorita_curso.cpf_usuario \r\n"
					+ "WHERE usuario_favorita_curso.cpf_usuario = ?");

			while (resultado.next()) {

				int id = resultado.getInt("id_curso");
				
				String nomeCurso = resultado.getString("nome_Curso");
				String nomeArea = resultado.getString("id_area");
				int idInstituicao = resultado.getInt("instituicao");
				float notaCorte = resultado.getFloat("nota_corte");
				String t =  resultado.getString("nome_instituicao");
				String endereco =  resultado.getString("endereco_instituicao");

				cursosFavoritos.add(new Curso(id, notaCorte, nomeCurso, new Area(nomeArea), new Instituicao(idInstituicao, t, endereco)));
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
	

	private SessionFactory conectarBanco() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(sistema.modelo.entidade.Area.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Curso.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Instituicao.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Usuario.class);

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
}
}
