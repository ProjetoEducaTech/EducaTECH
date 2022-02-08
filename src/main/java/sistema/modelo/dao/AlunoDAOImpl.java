package sistema.modelo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import sistema.modelo.entidade.Curso;

public class AlunoDAOImpl implements AlunoDAO {

	public void inserirAluno(Aluno aluno) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSessio();
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

	private SessionFactory conectarBanco() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(sistema.modelo.entidade.Area.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Curso.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Instituicao.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Usuario.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Aluno.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Contato.class);
		configuracao.addAnnotatedClass(sistema.modelo.entidade.Endereco.class);
		configuracao.addAnnotatedEnum(sistema.modelo.entidade.Genero.enum);
		configuracao.addAnnotatedEnum(sistema.modelo.entidade.Turno.enum);
		configuracao.addAnnotatedEnum(sistema.modelo.entidade.Modalidade.enum);
		

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
   }
}
