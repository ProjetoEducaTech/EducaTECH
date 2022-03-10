package sistema.modelo.dao.aluno;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
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
	
public List<Curso> consultaNotaCurso(Aluno aluno) {

	Session sessao = null;
	List<Curso> consultaNota = null;

	try {

		sessao = banco.getConectarBanco().openSession();
		sessao.beginTransaction();

		CriteriaBuilder construtor = sessao.getCriteriaBuilder();

		CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
		Root<Curso> raizCurso = criteria.from(Curso.class);

		Join<Curso, Aluno> juncaoNota = raizCurso.join("aluno");

		ParameterExpression<Double> notaCorteAluno = construtor.parameter(double.class);
		criteria.where(construtor.lessThanOrEqualTo(juncaoNota.get("nota"), notaCorteAluno));

		consultaNota = sessao.createQuery(criteria).setParameter(notaCorteAluno, aluno.getNota())
				.getResultList();

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

	return consultaNota;
}
	
	public List<Curso> exibirCursosFavoritos() {
		
		Session sessao = null;
		List<Curso> favoritos = null;

	try {

		sessao =  banco.getConectarBanco().openSession();
		sessao.beginTransaction();

		CriteriaBuilder construtor = sessao.getCriteriaBuilder();

		CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
		Root<Curso> raizFavorito = criteria.from(Curso.class);

		criteria.select(raizFavorito);

		favoritos = sessao.createQuery(criteria).getResultList();

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

	return favoritos;
}
}
