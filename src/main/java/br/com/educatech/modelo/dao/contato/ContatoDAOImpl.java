package br.com.educatech.modelo.dao.contato;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.educatech.modelo.entidade.contato.Contato;
import br.com.educatech.modelo.entidade.usuario.Usuario;
import br.com.educatech.modelo.factory.conexao.ConexaoFactory;

public class ContatoDAOImpl implements ContatoDAO {

	private ConexaoFactory conexao;

	public ContatoDAOImpl() {
		conexao = new ConexaoFactory();
	}

	public Contato inserirContato(Contato contato) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(contato);

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

		return contato;
	}

	public Contato atualizarContato(Contato contato) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(contato);

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

		return contato;
	}

	public Contato deletarContato(Contato contato) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(contato);

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

		return contato;
	}

	public Contato recuperarPorContatoUsuario(Usuario usuario) {

		Session sessao = null;
		Contato contato = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
			Root<Contato> raizContato = criteria.from(Contato.class);

			Join<Contato, Usuario> juncaoUsuario = raizContato.join("usuario");

			ParameterExpression<Long> idUsuario = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoUsuario.get("id"), idUsuario));

			contato = sessao.createQuery(criteria).setParameter(idUsuario, usuario.getId()).getSingleResult();

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

		return contato;
	}

	public List<Contato> recuperarContato() {

		Session sessao = null;
		List<Contato> contatos = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
			Root<Contato> raizContato = criteria.from(Contato.class);

			criteria.select(raizContato);

			contatos = sessao.createQuery(criteria).getResultList();

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

		return contatos;
	}

}