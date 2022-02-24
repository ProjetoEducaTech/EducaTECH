package sistema.modelo.dao.usuario;

import org.hibernate.Session;

import sistema.modelo.entidade.usuario.Usuario;
import sistema.modelo.factory.conexao.FactoryConexao;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private FactoryConexao banco;

	public UsuarioDAOImpl() {
		
		banco = new FactoryConexao();
	}

	public void inserirUsuario(Usuario usuario) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
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

			sessao = banco.getConectarBanco().openSession();
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

	public void atualizarUsuario(Usuario usuario) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(usuario);

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

	/*public Usuario loginUsuario(Usuario usuario) {

		Session sessao = null;
		Usuario loginUsuario = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			ParameterExpression<String> senha = construtor.parameter(String.class);
			criteria.where(construtor.equal(Usuario.get(Usuario_.SENHA), senha));

			loginUsuario = sessao.createQuery(criteria).setParameter(senha, usuario.getSenha()).getResultList();

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

		return loginUsuario;
	}*/

}