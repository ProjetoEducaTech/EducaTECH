package sistema.modelo.dao.avaliacao;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import sistema.modelo.entidade.avaliacao.Avaliacao;
import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.factory.conexao.FactoryConexao;

public class AvaliacaoDAOImpl implements AvaliacaoDAO {
	private FactoryConexao banco;
	public AvaliacaoDAOImpl() {
		banco = new FactoryConexao();
	}
	public void inserirAvaliacao(Avaliacao avaliacao) {
		Session sessao = null;
		try {
			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();
			sessao.save(avaliacao);
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
	public void deletarAvaliacao(Avaliacao avaliacao) {
		Session sessao = null;
		try {
			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();
			sessao.delete(avaliacao);
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
	public void atualizarAvaliacao(Avaliacao avaliacao) {
		Session sessao = null;
		try {
			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();
			sessao.update(avaliacao);
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

	public List<Avaliacao> avaliacoesCurso(Curso curso) {

		Session sessao = null;
		List<Avaliacao> avaliacoes = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Avaliacao> criteria = construtor.createQuery(Avaliacao.class);
			Root<Avaliacao> raizAvaliacao = criteria.from(Avaliacao.class);

			Join<Avaliacao, Curso> juncaoCurso = raizAvaliacao.join("curso");

			ParameterExpression<Long> idcurso = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoCurso.get("idCurso"), idcurso));

			avaliacoes = sessao.createQuery(criteria).setParameter(idcurso, curso.getIdCurso()).getResultList();

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

		return avaliacoes;
	}

public double mediaAvaliacoesCurso(Curso curso) {
		
		double mediaCurso = 0;
		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Double> criteria = construtor.createQuery(Double.class);
			Root<Avaliacao> raizAvaliacao = criteria.from(Avaliacao.class);
			
			Join<Avaliacao, Curso> juncaoCurso = raizAvaliacao.join("curso");

			ParameterExpression<Long> idCurso = construtor.parameter(Long.class);
			criteria.select(construtor.avg(raizAvaliacao.get("nota"))).where(construtor.equal(juncaoCurso.get("idCurso"), idCurso)).groupBy(juncaoCurso.get("idCurso"));

			mediaCurso = sessao.createQuery(criteria).setParameter(idCurso, curso.getIdCurso()).getSingleResult();
			
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

		return mediaCurso;
	}
	
}