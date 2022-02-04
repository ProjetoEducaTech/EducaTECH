package sistema.modelo.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import sistema.modelo.entidade.Endereco;
import sistema.modelo.entidade.Usuario;
import sistema.modelo.entidade.Usuario_;

public class EnderecoDAOImpl implements EnderecoDAO{
	
	public void cadastrarEndereco(Endereco endereco) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(endereco);
			
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
	
	public void atualizarEndereco(Endereco endereco) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(endereco);

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
	
	public void deletarEndereco(Endereco endereco) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(endereco);

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
	
	public List<Endereco> recuperarEnderecos() {

		Session sessao = null;
		List<Endereco> enderecos = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
			Root<Endereco> raizEndereco = criteria.from(Endereco.class);

			criteria.select(raizEndereco);

			enderecos = sessao.createQuery(criteria).getResultList();

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

		return enderecos;
	}
	
public List<Endereco> recuperarEnderecosCliente(Usuario usuario) {
		
		Session sessao = null;
		List<Endereco> enderecos = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
			Root<Endereco> raizEndereco = criteria.from(Endereco.class);
			
			Join<Endereco, Usuario> juncaoUsuario = raizEndereco.join(Endereco_.usuario);
			
			ParameterExpression<String> idUsuario = construtor.parameter(String.class);
			criteria.where(construtor.equal(juncaoUsuario.get(Usuario_.ID), idUsuario));

			enderecos = sessao.createQuery(criteria).setParameter(idUsuario, usuario.getId()).getResultList();

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

		return enderecos;
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
