package sistema.modelo.dao.area;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import sistema.modelo.entidade.area.Area;
import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.factory.conexao.FactoryConexao;

public class AreaDAOImpl implements AreaDAO{
	
	private FactoryConexao banco;
	
	public AreaDAOImpl() {
		banco = new FactoryConexao();
	}
	
	public void inserirArea(Area area) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(area);
			
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

	public void deletarArea(Area area) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(area);

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

	public void atualizarArea(Area area) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(area);

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
	
public List<Curso> consultaAreaCurso(Area area) {
		
		Session sessao = null;
		List<Curso> consultaArea = null;

		try {

			sessao =  banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			Join<Curso, Area> juncaoArea = raizCurso.join("area");

			ParameterExpression<Long> idArea = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoArea.get("idArea"), idArea));

			consultaArea = sessao.createQuery(criteria).setParameter(idArea, area.getIdArea()).getResultList();

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
	
}