package sistema.modelo.dao.usuario;

import org.hibernate.Session;

import sistema.modelo.entidade.usuario.Usuario;
import sistema.modelo.factory.conexao.FactoryConexao;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private FactoryConexao banco;

	public UsuarioDAOImpl() {
		banco = new FactoryConexao();
	}

	public void cadastrarUsuario(Usuario usuario) {

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

	/*
	 * public List<Usuario> loginAluno() {
	 * 
	 * Session sessao = null; List<Usuario> loginAluno = null;
	 * 
	 * try {
	 * 
	 * sessao = conectarBanco().openSession(); sessao.beginTransaction();
	 * 
	 * CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	 * 
	 * CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
	 * Root<Usuario> raizUsuario = criteria.from(Usuario.class);
	 * 
	 * Join<Usuario, Aluno> juncaoAluno = raizUsuario.join(cpf_aluno);
	 * 
	 * ParameterExpression<String> cpf = construtor.parameter(String.class);
	 * criteria.where(construtor.equal(juncaoAluno.get(senha_aluno, cpf)));
	 * 
	 * loginAluno = sessao.createQuery(criteria).setParameter(cpf,
	 * usuario.getSenha()).getResultList();
	 * 
	 * sessao.getTransaction().commit();
	 * 
	 * } catch (Exception sqlException) {
	 * 
	 * sqlException.printStackTrace();
	 * 
	 * if (sessao.getTransaction() != null) { sessao.getTransaction().rollback(); }
	 * 
	 * } finally {
	 * 
	 * if (sessao != null) { sessao.close(); } }
	 * 
	 * return loginAluno; }
	 * 
	 * }
	 * 
	 * public List<Usuario> loginInstituicao() {
	 * 
	 * Session sessao = null; List<Usuario> loginInstituicao = null;
	 * 
	 * try {
	 * 
	 * sessao = conectarBanco().openSession(); sessao.beginTransaction();
	 * 
	 * CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	 * 
	 * CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
	 * Root<Usuario> raizUsuario = criteria.from(Usuario.class);
	 * 
	 * Join<Usuario, Instituico> juncaoInstituicao = raizUsuario.join(cnpj);
	 * 
	 * ParameterExpression<String> cnpj = construtor.parameter(String.class);
	 * criteria.where(construtor.equal(juncaoInstituicao.get(senha_usuario, cnpj)));
	 * 
	 * loginInstituicao = sessao.createQuery(criteria).setParameter(cnpj,
	 * usuario.getSenha()).getResultList();
	 * 
	 * sessao.getTransaction().commit();
	 * 
	 * } catch (Exception sqlException) {
	 * 
	 * sqlException.printStackTrace();
	 * 
	 * if (sessao.getTransaction() != null) { sessao.getTransaction().rollback(); }
	 * 
	 * } finally {
	 * 
	 * if (sessao != null) { sessao.close(); } }
	 * 
	 * return loginInstituicao; }
	 * 
	 * public List<Instituicao> cadastrarInstituicao() {
	 * 
	 * Session sessao = null; List<Instituicao> instituicao = null;
	 * 
	 * try {
	 * 
	 * sessao = conectarBanco().openSession(); sessao.beginTransaction();
	 * 
	 * CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	 * 
	 * CriteriaQuery<Instituicao> criteria =
	 * construtor.createQuery(Instituicao.class); Root<Instituicao> raizInstituicao
	 * = criteria.from(Instituicao.class);
	 * 
	 * criteria.select(raizInstituicao);
	 * 
	 * instituicao = sessao.createQuery(criteria).getResultList();
	 * 
	 * sessao.getTransaction().commit();
	 * 
	 * } catch (Exception sqlException) {
	 * 
	 * sqlException.printStackTrace();
	 * 
	 * if (sessao.getTransaction() != null) { sessao.getTransaction().rollback(); }
	 * 
	 * } finally {
	 * 
	 * if (sessao != null) { sessao.close(); } }
	 * 
	 * return instituicao; }
	 * 
	 * public List<Aluno> cadastrarAluno() {
	 * 
	 * Session sessao = null; List<Aluno> alunos = null;
	 * 
	 * try {
	 * 
	 * sessao = conectarBanco().openSession(); sessao.beginTransaction();
	 * 
	 * CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	 * 
	 * CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
	 * Root<Aluno> raizAluno = criteria.from(Aluno.class);
	 * 
	 * criteria.select(raizAluno);
	 * 
	 * alunos = sessao.createQuery(criteria).getResultList();
	 * 
	 * sessao.getTransaction().commit();
	 * 
	 * } catch (Exception sqlException) {
	 * 
	 * sqlException.printStackTrace();
	 * 
	 * if (sessao.getTransaction() != null) { sessao.getTransaction().rollback(); }
	 * 
	 * } finally {
	 * 
	 * if (sessao != null) { sessao.close(); } }
	 * 
	 * return alunos; }
	 */

}