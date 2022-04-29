package br.com.educatech.modelo.dao.aluno;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.educatech.modelo.entidade.aluno.Aluno;
import br.com.educatech.modelo.entidade.curso.Curso;
import br.com.educatech.modelo.factory.conexao.ConexaoFactory;

public class AlunoDAOImpl implements AlunoDAO {

	private ConexaoFactory conexao;

	public AlunoDAOImpl() {

		conexao = new ConexaoFactory();

	}

	public Aluno inserirAluno(Aluno aluno) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(aluno);

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

		return aluno;
	}

	public Aluno atualizarAluno(Aluno aluno) {

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

		return aluno;
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

	public void favoritarCurso(Curso curso) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(curso);

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

	public void removerCursoFavorito(Curso curso) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			sessao.remove(curso);

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

	public Aluno loginUsuarioAluno(Long id) {

		Session sessao = null;
		Aluno loginUsuarioAluno = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);

			criteria.where(construtor.equal(raizAluno.get("id"), id));

			loginUsuarioAluno = sessao.createQuery(criteria).getSingleResult();

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

		return loginUsuarioAluno;
	}

	public List<Aluno> recuperarAlunos() {

		Session sessao = null;
		List<Aluno> aluno = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);

			criteria.select(raizAluno);

			criteria.orderBy(construtor.asc(raizAluno.get("nome")));

			aluno = sessao.createQuery(criteria).getResultList();

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

		return aluno;
	}

}
