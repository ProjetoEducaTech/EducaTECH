package sistema.modelo.dao.aluno;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Join;
//import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import sistema.modelo.entidade.curso.Curso;

public class AlunoDAOImpl implements AlunoDAO {

public void favoritarCurso(Curso curso) {
		
		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
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
	
	/*public List<Curso> consultaNota(Aluno aluno) {

		Session sessao = null;
		List<Curso> consultaNota = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			Join<Curso, Aluno> juncaoNota = raizCurso.join(Curso_.aluno);

			ParameterExpression<Double> notaCorteAluno = construtor.parameter(double.class);
			criteria.where(construtor.equal(juncaoNota.get(Aluno_.NOTACORTE), notaCorteAluno));

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

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			Join<Curso, Instituicao> juncaoInstituicao = raizCurso.join(Curso_.instituicao);

			ParameterExpression<String> cnpfinstituicao = construtor.parameter(String.class);
			criteria.where(construtor.equal(juncaoInstituicao.get(Instituicao_.CNPJ), cnpfinstituicao));

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

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			Join<Curso, Area> juncaoArea = raizCurso.join(Curso_.area);

			ParameterExpression<String> cnpjinstituicao = construtor.parameter(String.class);
			criteria.where(construtor.equal(juncaoArea.get(Area_.NOME), cnpjinstituicao));

			consultaArea = sessao.createQuery(criteria).setParameter(cnpjinstituicao, area.getNome()).getResultList();

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
	}*/
	
	public List<Curso> exibirCursosFavoritos() {
		
		Session sessao = null;
		List<Curso> favoritos = null;

	try {

		sessao = conectarBanco().openSession();
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
	
	private SessionFactory conectarBanco() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(sistema.modelo.entidade.area.Area.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.curso.Curso.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.instituicao.Instituicao.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.usuario.Usuario.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.aluno.Aluno.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.contato.Contato.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.endereco.Endereco.class);
		

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
   }
}
