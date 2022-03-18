package sistema.modelo.dao.instituicao;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import sistema.modelo.entidade.instituicao.Instituicao;
import sistema.modelo.factory.conexao.FactoryConexao;

public class InstituicaoDAOImpl implements InstituicaoDAO {
	
	private FactoryConexao banco;

	public InstituicaoDAOImpl() {
		
		banco = new FactoryConexao();
	}

	public void inserirInstituicao(Instituicao instituicao) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(instituicao);

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

	public void deletarInstituicao(Instituicao instituicao) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(instituicao);

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

	public void atualizarInstituicao(Instituicao instituicao) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(instituicao);

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

	public List<Instituicao> recuperarInstituicoes() {

		Session sessao = null;
		List<Instituicao> instituicao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Instituicao> criteria = construtor.createQuery(Instituicao.class);
			Root<Instituicao> raizInstituicao = criteria.from(Instituicao.class);

			criteria.select(raizInstituicao);

			instituicao = sessao.createQuery(criteria).getResultList();

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

		return instituicao;
	}
	
}