package br.senac.educatech.modelo.dao.instituicao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.educatech.modelo.entidade.instituicao.Instituicao;
import br.senac.educatech.modelo.entidade.instituicao.Instituicao_;
import br.senac.educatech.modelo.entidade.usuario.Usuario;
import br.senac.educatech.modelo.factory.conexao.ConexaoFactory;

public class InstituicaoDAOImpl implements InstituicaoDAO {

	private ConexaoFactory conexao;

	public InstituicaoDAOImpl() {

		conexao = new ConexaoFactory();
	}

	public Long inserirInstituicao(Instituicao instituicao) {

		Session sessao = null;
		Long idInstituicao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			idInstituicao = (Long) sessao.save(instituicao);

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

		return idInstituicao;
	}

	public void atualizarInstituicao(Instituicao instituicao) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
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

	public void deletarInstituicao(Instituicao instituicao) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
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

	public Instituicao recuperarInstituicaoPeloId(Usuario usuario) {

		Session sessao = null;
		Instituicao instituicoesRecuperadasPeloId = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Instituicao> criteria = construtor.createQuery(Instituicao.class);
			Root<Instituicao> raizInstuicao = criteria.from(Instituicao.class);

			criteria.where(construtor.equal(raizInstuicao.get(Instituicao_.ID), usuario.getId()));

			instituicoesRecuperadasPeloId = sessao.createQuery(criteria).getSingleResult();

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

		return instituicoesRecuperadasPeloId;
	}

	public List<Instituicao> recuperarInstituicoes() {

		Session sessao = null;
		List<Instituicao> instituicao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Instituicao> criteria = construtor.createQuery(Instituicao.class);
			Root<Instituicao> raizInstituicao = criteria.from(Instituicao.class);

			criteria.orderBy(construtor.asc(raizInstituicao.get(Instituicao_.NOME)));

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