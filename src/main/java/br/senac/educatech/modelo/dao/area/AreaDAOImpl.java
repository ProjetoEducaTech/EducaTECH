package br.senac.educatech.modelo.dao.area;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.educatech.modelo.entidade.area.Area;
import br.senac.educatech.modelo.entidade.area.Area_;
import br.senac.educatech.modelo.factory.conexao.ConexaoFactory;

public class AreaDAOImpl implements AreaDAO {

	private ConexaoFactory conexao;

	public AreaDAOImpl() {
		conexao = new ConexaoFactory();
	}

	public Area inserirArea(Area area) {

		Session sessao = null;
		Area novaArea = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			novaArea = (Area) sessao.save(area);

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

		return novaArea;
	}

	public void atualizarArea(Area area) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
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

	public void deletarArea(Area area) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
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

	public List<Area> recuperarAreas() {

		Session sessao = null;
		List<Area> areas = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Area> criteria = construtor.createQuery(Area.class);
			Root<Area> raizArea = criteria.from(Area.class);

			criteria.select(raizArea);

			areas = sessao.createQuery(criteria).getResultList();

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

		return areas;
	}
	public Area recuperarAreaPeloId(Area area) {

		Session sessao = null;
		Area areaRecuperada = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Area> criteria = construtor.createQuery(Area.class);
			Root<Area> raizArea = criteria.from(Area.class);

			criteria.where(construtor.equal(raizArea.get(Area_.ID), area.getId()));

			areaRecuperada = sessao.createQuery(criteria).getSingleResult();

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

		return areaRecuperada;
	}
}