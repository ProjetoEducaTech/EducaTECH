package sistema.modelo.dao.endereco;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import sistema.modelo.entidade.endereco.Endereco;
import sistema.modelo.entidade.instituicao.Instituicao;
import sistema.modelo.factory.conexao.FactoryConexao;

public class EnderecoDAOImpl implements EnderecoDAO {
	
	private FactoryConexao banco;

	public EnderecoDAOImpl() {
		
		banco = new FactoryConexao();
		
	}
	
	public void inserirEndereco(Endereco endereco) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
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

			sessao = banco.getConectarBanco().openSession();
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

			sessao = banco.getConectarBanco().openSession();
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
	
	public List<Endereco> recuperarEndereco() {

		Session sessao = null;
		List<Endereco> enderecos = null;

		try {

			sessao = banco.getConectarBanco().openSession();
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
	
public List<Endereco> recuperarEnderecoInstituicao(Instituicao instituicao) {
		
		Session sessao = null;
		List<Endereco> enderecos = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
			Root<Endereco> raizEndereco = criteria.from(Endereco.class);
			
			Join<Endereco, Instituicao> juncaoUsuario = raizEndereco.join("instituicao");
			
			ParameterExpression<Long> idUsuario = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoUsuario.get("id"), idUsuario));

			enderecos = sessao.createQuery(criteria).setParameter(idUsuario, instituicao.getId()).getResultList();

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
}