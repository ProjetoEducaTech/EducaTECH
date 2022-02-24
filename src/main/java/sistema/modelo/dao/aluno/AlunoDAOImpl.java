package sistema.modelo.dao.aluno;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import sistema.modelo.entidade.aluno.Aluno;
import sistema.modelo.entidade.area.Area;
import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.entidade.instituicao.Instituicao;
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
	
	public List<Curso> consultaNota(Aluno aluno) {

		Session sessao = null;
		List<Curso> consultaNota = null;

		try {

			sessao =  banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			//Join<Curso, Aluno> juncaoNota = raizCurso.join(Curso_.aluno);

			ParameterExpression<Double> notaCorteAluno = construtor.parameter(double.class);
			//criteria.where(construtor.equal(juncaoNota.get(Aluno_.NOTACORTE), notaCorteAluno));

			consultaNota = sessao.createQuery(criteria).setParameter(notaCorteAluno, aluno.getNotaCorte()).getResultList();

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
	
	public List<Curso> consultaInstituicao(Instituicao instituicao) {

		Session sessao = null;
		List<Curso> consultaInstituicao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			//Join<Curso, Instituicao> juncaoInstituicao = raizCurso.join(Curso_.instituicao);

			ParameterExpression<String> cnpfinstituicao = construtor.parameter(String.class);
			//criteria.where(construtor.equal(juncaoInstituicao.get(Instituicao_.CNPJ), cnpfinstituicao));

			consultaInstituicao = sessao.createQuery(criteria).setParameter(cnpfinstituicao, instituicao.getCnpj()).getResultList();

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

		return consultaInstituicao;
	}
	
	public List<Curso> consultaArea(Area area) {
		
		Session sessao = null;
		List<Curso> consultaArea = null;

		try {

			sessao =  banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			//Join<Curso, Area> juncaoArea = raizCurso.join(Curso_.area);

			ParameterExpression<String> cnpjinstituicao = construtor.parameter(String.class);
		//	criteria.where(construtor.equal(juncaoArea.get(Area_.NOME), cnpjinstituicao));

			//consultaArea = sessao.createQuery(criteria).setParameter(cnpjinstituicao, area.getNome()).getResultList();

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

		return consultaArea;
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
