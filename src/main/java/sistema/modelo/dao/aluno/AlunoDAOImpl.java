package sistema.modelo.dao.aluno;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;

import javax.persistence.criteria.Root;

import org.hibernate.Session;

import sistema.modelo.entidade.aluno.Aluno;
import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.factory.conexao.FactoryConexao;

public class AlunoDAOImpl implements AlunoDAO {

	private FactoryConexao banco;

	public AlunoDAOImpl() {

		banco = new FactoryConexao();

	}

	public void inserirAluno(Aluno aluno) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
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
	}

	public void deletarAluno(Aluno aluno) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
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

	public void atualizarAluno(Aluno aluno) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
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

	public void favoritarCurso(Curso curso) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
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

			sessao = banco.getConectarBanco().openSession();
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

	public List<Aluno> recuperarAlunos() {

		Session sessao = null;
		List<Aluno> aluno = null;

		try {

			sessao = banco.getConectarBanco().openSession();
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

	public Aluno loginUsuarioAluno(Long id) {

		Session sessao = null;
		Aluno loginUsuarioAluno = null;

		try {

			sessao = banco.getConectarBanco().openSession();
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
	
public List<Aluno> recuperarAlunosFavoritaramCurso(Curso curso) {
		
		Session sessao = null;
		List<Aluno> alunos = null;
		
		try {
			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);
			
			Join<Aluno, Curso> joinCurso = raizAluno.join("cursosFavorito");
			ParameterExpression<Long> idCurso = construtor.parameter(Long.class);
			
			criteria.where(construtor.equal(joinCurso.get("idCurso"), idCurso));
			
			alunos = sessao.createQuery(criteria).setParameter(idCurso, curso.getIdCurso()).getResultList();
			
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
