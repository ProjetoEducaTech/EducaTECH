package br.senac.educatech.modelo.dao.avaliacao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.educatech.modelo.entidade.aluno.Aluno;
import br.senac.educatech.modelo.entidade.aluno.Aluno_;
import br.senac.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.senac.educatech.modelo.entidade.avaliacao.Avaliacao_;
import br.senac.educatech.modelo.entidade.curso.Curso;
import br.senac.educatech.modelo.entidade.curso.Curso_;
import br.senac.educatech.modelo.factory.conexao.ConexaoFactory;

public class AvaliacaoDAOImpl implements AvaliacaoDAO {

	private ConexaoFactory conexao;

	public AvaliacaoDAOImpl() {
		conexao = new ConexaoFactory();
	}

	public Avaliacao inserirAvaliacao(Avaliacao avaliacao) {

		Session sessao = null;
		Avaliacao novaAvaliacao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			novaAvaliacao = (Avaliacao) sessao.save(avaliacao);

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

		return novaAvaliacao;
	}

	public void atualizarAvaliacao(Avaliacao avaliacao) {

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
	}

	public void deletarAvaliacao(Avaliacao avaliacao) {

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
	}

	public Avaliacao recuperarAvaliacaoPeloId(Avaliacao avaliacao) {

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

	public double recuperarMediaAvaliacaoPeloCurso(Curso curso) {

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

	public List<Avaliacao> recuperarAvaliacoesPeloCurso(Curso curso) {

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

	public List<Avaliacao> recuperarPaginaPelaNotaComentarioNome(int pageNumber, int pageSize) {

		Session sessao = null;
		List<Avaliacao> currentPage = new ArrayList<>();

		try {
			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Long> queryContador = construtor.createQuery(Long.class);

			queryContador.select(construtor.count(queryContador.from(Avaliacao.class)));
			Long count = sessao.createQuery(queryContador).getSingleResult();

			CriteriaQuery<Avaliacao> criteriaQuery = construtor.createQuery(Avaliacao.class);
			Root<Avaliacao> raizAvaliacao = criteriaQuery.from(Avaliacao.class);
			Join<Avaliacao, Aluno> juncaoAluno = raizAvaliacao.join(Avaliacao_.ALUNO);
			CriteriaQuery<Avaliacao> select = criteriaQuery.select(raizAvaliacao);

			ParameterExpression<String> nome = construtor.parameter(String.class);
			criteriaQuery.where(construtor.equal(juncaoAluno.get(Aluno_.NOME), nome));

			criteriaQuery.orderBy(construtor.desc(raizAvaliacao.get(Avaliacao_.NOTA)),
					construtor.desc(raizAvaliacao.get(Avaliacao_.COMENTARIO)),
					construtor.desc(raizAvaliacao.get(Aluno_.NOME)));
			TypedQuery<Avaliacao> typedQuery = sessao.createQuery(select);
			currentPage.addAll(typedQuery.getResultList());

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
		return currentPage;
	}

}