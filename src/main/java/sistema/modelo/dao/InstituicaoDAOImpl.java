package sistema.modelo.dao;

import java.lang.module.Configuration;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import sistema.modelo.entidade.Instituicao;

public class InstituicaoDAOImpl implements InstituicaoDAO {

	public void inserirInstituicao(Instituicao instituicao) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(instituicao);

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

	public void deletarInstituicao(Instituicao instituicao) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(instituicao);

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

	public void atualizarInstituicao(Instituicao instituicao) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(instituicao);

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

	public List<Instituicao> recuperarInstituicoes() {

		Session sessao = null;
		List<Instituicao> instituicao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Instituicao> criteria = construtor.createQuery(Instituicao.class);
			Root<Instituicao> raizInstituicao = criteria.from(Instituicao.class);

			criteria.select(raizInstituicao);

			instituicao = sessao.createQuery(criteria).getResultList();

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

		return instituicao;
	}

	private SessionFactory conectarBanco() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(sistema.modelo.entidade.Area.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Aluno.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Curso.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Instituicao.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Usuario.class);
		configuracao.addAnnotatedEnum(sistema.modelo.entidade.Turno.enum);
		configuracao.addAnnotatedEnum(sistema.modelo.entidade.Modalidade.enum);
		configuracao.addAnnotatedEnum(sistema.modelo.entidade.Genero.enum);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Contato.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Endereco.class);

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
   }

}