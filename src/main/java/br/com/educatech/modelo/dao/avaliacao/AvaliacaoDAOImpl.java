package br.com.educatech.modelo.dao.avaliacao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.com.educatech.modelo.entidade.avaliacao.Avaliacao_;
import br.com.educatech.modelo.entidade.curso.Curso;
import br.com.educatech.modelo.entidade.curso.Curso_;
import br.com.educatech.modelo.factory.conexao.ConexaoFactory;

public class AvaliacaoDAOImpl implements AvaliacaoDAO {

	private ConexaoFactory conexao;

	public AvaliacaoDAOImpl() {
		conexao = new ConexaoFactory();
	}

	public Avaliacao inserirAvaliacao(Avaliacao avaliacao) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
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

		return avaliacao;
	}

	public Avaliacao atualizarAvaliacao(Avaliacao avaliacao) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
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

		return avaliacao;
	}

	public Avaliacao deletarAvaliacao(Avaliacao avaliacao) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
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

		return avaliacao;
	}

	public Avaliacao recuperarAvaliacaoPorId(Avaliacao avaliacao) {

		Session sessao = null;
		Avaliacao avalicaoesRecuperadas = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Avaliacao> criteria = construtor.createQuery(Avaliacao.class);
			Root<Avaliacao> raizAvaliacao = criteria.from(Avaliacao.class);

			criteria.where(construtor.equal(raizAvaliacao.get(Avaliacao_.ID), avaliacao.getId()));

			avalicaoesRecuperadas = sessao.createQuery(criteria).getSingleResult();

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

		return avalicaoesRecuperadas;
	}

	public double recuperarMediaAvaliacaoCurso(Curso curso) {

		double mediaCurso = 0;
		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Double> criteria = construtor.createQuery(Double.class);
			Root<Avaliacao> raizAvaliacao = criteria.from(Avaliacao.class);

			Join<Avaliacao, Curso> juncaoCurso = raizAvaliacao.join(Avaliacao_.CURSO);

			ParameterExpression<Long> idCurso = construtor.parameter(Long.class);
			criteria.select(construtor.avg(raizAvaliacao.<Double>get(Avaliacao_.NOTA)))
					.where(construtor.equal(juncaoCurso.get(Curso_.ID), idCurso)).groupBy(juncaoCurso.get(Curso_.ID));

			mediaCurso = sessao.createQuery(criteria).setParameter(idCurso, curso.getId()).getSingleResult();

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

	public List<Avaliacao> recuperarAvaliacaoCurso(Curso curso) {

		Session sessao = null;
		List<Avaliacao> avaliacoes = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Avaliacao> criteria = construtor.createQuery(Avaliacao.class);
			Root<Avaliacao> raizAvaliacao = criteria.from(Avaliacao.class);

			Join<Avaliacao, Curso> juncaoCurso = raizAvaliacao.join(Avaliacao_.CURSO);

			ParameterExpression<Long> idCurso = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoCurso.get(Curso_.ID), idCurso));

			avaliacoes = sessao.createQuery(criteria).setParameter(idCurso, curso.getId()).getResultList();

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

}