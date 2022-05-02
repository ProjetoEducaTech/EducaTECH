package br.com.educatech.modelo.dao.usuario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.educatech.modelo.entidade.contato.Contato;
import br.com.educatech.modelo.entidade.usuario.Usuario;
import br.com.educatech.modelo.factory.conexao.ConexaoFactory;

public class UsuarioDAOImpl implements UsuarioDAO {

	private ConexaoFactory conexao;

	public UsuarioDAOImpl() {

		conexao = new ConexaoFactory();
	}

	public void inserirUsuario(Usuario usuario) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
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

	public void atualizarUsuario(Usuario usuario) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
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

	public void deletarUsuario(Usuario usuario) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
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

	public Usuario loginUsuario(String email, String senha) {

		Session sessao = null;
		Usuario loginUsuario = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			Join<Usuario, Contato> juncaoContato = raizUsuario.join("contatos");

			Predicate predicateEmail = construtor.equal(juncaoContato.get("email"), email);
			Predicate predicateSenha = construtor.equal(raizUsuario.get("senha"), senha);
			Predicate predicateLogin = construtor.and(predicateEmail, predicateSenha);

			criteria.where(predicateLogin);

			loginUsuario = sessao.createQuery(criteria).getSingleResult();

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
	}

	public List<Usuario> recuperarUsuario() {

		Session sessao = null;
		List<Usuario> usuario = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario);

			usuario = sessao.createQuery(criteria).getResultList();

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

		return usuario;
	}

}