package br.senac.educatech.modelo.dao.area;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.educatech.modelo.entidade.area.Area;
import br.senac.educatech.modelo.entidade.area.Area_;
import br.senac.educatech.modelo.entidade.curso.Curso;
import br.senac.educatech.modelo.entidade.instituicao.Instituicao;
import br.senac.educatech.modelo.entidade.instituicao.Instituicao_;
import br.senac.educatech.modelo.factory.conexao.ConexaoFactory;

public class AreaDAOImpl implements AreaDAO {

	private ConexaoFactory conexao;

	public AreaDAOImpl() {
		conexao = new ConexaoFactory();
	}

	public Long inserirArea(Area area) {

		Session sessao = null;
		Long idArea = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			idArea = (Long) sessao.save(area);

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

		return idArea;
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
	
	public Area recuperarAreaPeloCurso(Curso curso) {
		
		Session sessao = null;
		Area areaRecuperada = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Area> criteria = construtor.createQuery(Area.class);
			Root<Area> raizArea = criteria.from(Area.class);
			
			criteria.where(construtor.equal(raizArea.get(Area_.ID), curso.getArea().getId()));

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
	
	public List<Area> recuperarAreasPelaInstituicao(Instituicao instituicao){
		
		Session sessao = null;
		List<Area> consultaArea = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Area> criteria = construtor.createQuery(Area.class);
			Root<Area> raizArea = criteria.from(Area.class);

			Join<Area, Instituicao> juncaoInstituicao = raizArea.join(Area_.INSTITUICAO);

			ParameterExpression<Long> idinst = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoInstituicao.get(Instituicao_.ID), idinst));

			criteria.orderBy(construtor.asc(raizArea.get(Area_.NOME)));

			consultaArea = sessao.createQuery(criteria).setParameter(idinst, instituicao.getId()).getResultList();

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
