package br.senac.educatech.modelo.dao.aluno;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.educatech.modelo.entidade.aluno.Aluno;
import br.senac.educatech.modelo.entidade.aluno.Aluno_;
import br.senac.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.senac.educatech.modelo.entidade.curso.Curso;
import br.senac.educatech.modelo.factory.conexao.ConexaoFactory;

public class AlunoDAOImpl implements AlunoDAO {

	private ConexaoFactory conexao;

	public AlunoDAOImpl() {

		conexao = new ConexaoFactory();

	}

	public Long inserirAluno(Aluno aluno) {

		Session sessao = null;
		Long idAluno = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			idAluno = (Long) sessao.save(aluno);

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

		return idAluno;
	}

	public void atualizarAluno(Aluno aluno) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(aluno);

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

	public void deletarAluno(Aluno aluno) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(aluno);

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

	public Aluno recuperarAlunoPeloId(Aluno aluno) {

		Session sessao = null;
		Aluno alunoRecuperado = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);

			criteria.where(construtor.equal(raizAluno.get(Aluno_.ID), aluno.getId()));

			alunoRecuperado = sessao.createQuery(criteria).getSingleResult();

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

		return alunoRecuperado;
	}
	
	public Aluno recuperarAlunoComCursosPeloId(Aluno aluno) {

		Session sessao = null;
		Aluno alunosRecuperados = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);
			raizAluno.fetch(Aluno_.CURSOS_FAVORITOS, JoinType.LEFT);

			criteria.where(construtor.equal(raizAluno.get(Aluno_.ID), aluno.getId()));

			alunosRecuperados = sessao.createQuery(criteria).getSingleResult();

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

		return alunosRecuperados;
	}

	public List<Aluno> recuperarAlunos() {

		Session sessao = null;
		List<Aluno> alunos = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);

			criteria.select(raizAluno);

			criteria.orderBy(construtor.asc(raizAluno.get(Aluno_.NOME)));

			alunos = sessao.createQuery(criteria).getResultList();

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

		return alunos;
	}
	
	public List<Aluno> recuperarAlunosAvaliaramCurso(Curso curso) {
		Session sessao = null;
		List<Aluno> alunos = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);

			Join<Aluno, Avaliacao> juncaoAvalicao = raizAluno.join(Aluno_.AVALIACOES);
			
			ParameterExpression<Long> idCurso = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoAvalicao.get(Curso_.ID), idCurso));

			alunos = sessao.createQuery(criteria).setParameter(idCurso, curso.getId()).getResultList();

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

		return alunos;
	}
}