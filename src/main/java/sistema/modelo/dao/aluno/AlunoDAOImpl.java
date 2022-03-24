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
import sistema.modelo.entidade.usuario.Usuario;
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

public Usuario loginUsuarioAluno(Usuario usuario) {

	Session sessao = null;
	Usuario loginUsuarioAluno = null;

	try {

		sessao = banco.getConectarBanco().openSession();
		sessao.beginTransaction();

		CriteriaBuilder construtor = sessao.getCriteriaBuilder();

		CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
		Root<Usuario> raizUsuario = criteria.from(Usuario.class);

		Join<Usuario, Aluno> juncaoLoginAluno = raizUsuario.join("aluno");

		ParameterExpression<String> cpfAluno = construtor.parameter(String.class);
		ParameterExpression<String> senhaAluno = construtor.parameter(String.class);
		
		Predicate predicateCpfAluno = construtor.equal(juncaoLoginAluno.get("cpf"), cpfAluno);
		Predicate predicateSenhaAluno = construtor.equal(raizUsuario.get("senha"), senhaAluno);
		Predicate predicateLoginAluno = construtor.and(predicateCpfAluno, predicateSenhaAluno);
		
		criteria.where(predicateLoginAluno);
		
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
}
