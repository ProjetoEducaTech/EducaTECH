package br.com.educatech.modelo.dao.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.educatech.modelo.entidade.aluno.Aluno;
import br.com.educatech.modelo.entidade.aluno.Aluno_;
import br.com.educatech.modelo.entidade.area.Area;
import br.com.educatech.modelo.entidade.area.Area_;
import br.com.educatech.modelo.entidade.curso.Curso;
import br.com.educatech.modelo.entidade.curso.Curso_;
import br.com.educatech.modelo.entidade.instituicao.Instituicao;
import br.com.educatech.modelo.entidade.instituicao.Instituicao_;
import br.com.educatech.modelo.enumeraco.modalidade.TipoModalidade;
import br.com.educatech.modelo.enumeraco.turno.TipoTurno;
import br.com.educatech.modelo.factory.conexao.ConexaoFactory;

public class CursoDAOImpl implements CursoDAO {

	private ConexaoFactory conexao;

	public CursoDAOImpl() {

		conexao = new ConexaoFactory();

	}

	public Curso inserirCurso(Curso curso) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
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

		return curso;
	}

	public Curso atualizarCurso(Curso curso) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(curso);

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

		return curso;
	}

	public Curso deletarCurso(Curso curso) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(curso);

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

		return curso;
	}
	
	public Curso recuperarCursoPorId(Curso curso) {

		Session sessao = null;
		Curso  cursosRecuperadas = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.where(construtor.equal(raizCurso.get(Curso_.ID), curso.getId()));

			cursosRecuperadas = sessao.createQuery(criteria).getSingleResult();

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

		return cursosRecuperadas;
	}

	public List<Curso> recuperarCurso() {

		Session sessao = null;
		List<Curso> curso = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.select(raizCurso);
			criteria.orderBy(construtor.asc(raizCurso.get(Curso_.NOME)));

			curso = sessao.createQuery(criteria).getResultList();

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

		return curso;
	}

	public List<Curso> recuperarPorInstituicaoCurso(Instituicao instituicao) {

		Session sessao = null;
		List<Curso> consultaCurso = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			Join<Curso, Instituicao> juncaoInstituicao = raizCurso.join(Curso_.INSTITUICAO);

			ParameterExpression<Long> idinst = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoInstituicao.get(Instituicao_.ID), idinst));

			criteria.orderBy(construtor.asc(raizCurso.get(Curso_.NOME)));

			consultaCurso = sessao.createQuery(criteria).setParameter(idinst, instituicao.getId()).getResultList();

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

		return consultaCurso;
	}

	public List<Curso> recuperarPorAreaCurso(Area area) {

		Session sessao = null;
		List<Curso> consultaArea = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			Join<Curso, Area> juncaoArea = raizCurso.join(Curso_.AREA);

			ParameterExpression<Long> idArea = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoArea.get(Area_.ID), idArea));

			criteria.orderBy(construtor.asc(raizCurso.get(Curso_.NOME)));

			consultaArea = sessao.createQuery(criteria).setParameter(idArea, area.getId()).getResultList();

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

	public List<Curso> recuperarPorNotaCurso(Aluno aluno) {

		Session sessao = null;
		List<Curso> consultaNota = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.where(construtor.lessThanOrEqualTo(raizCurso.<Double>get(Curso_.NOTA_CORTE), aluno.getNota()));

			criteria.orderBy(construtor.desc(raizCurso.get(Curso_.NOTA_CORTE)),
					construtor.asc(raizCurso.get(Curso_.NOME)));

			consultaNota = sessao.createQuery(criteria).getResultList();

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

	public List<Curso> recuperarPorCursoFavorito(Aluno aluno) {

		Session sessao = null;
		List<Curso> favoritos = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizFavorito = criteria.from(Curso.class);

			Join<Curso, Aluno> juncaoAluno = raizFavorito.join(Curso_.ALUNOS);

			ParameterExpression<Long> idAluno = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoAluno.get(Aluno_.ID), idAluno));

			criteria.orderBy(construtor.asc(raizFavorito.get(Curso_.NOME)));

			favoritos = sessao.createQuery(criteria).setParameter(idAluno, aluno.getId()).getResultList();

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

	public List<Curso> recuperarPorPrecoCurso(double custo) {

		Session sessao = null;
		List<Curso> cursos = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.where(construtor.between(raizCurso.<Double>get(Curso_.PRECO), 50.0, custo));

			criteria.orderBy(construtor.desc(raizCurso.get(Curso_.PRECO)), construtor.asc(raizCurso.get(Curso_.NOME)));

			cursos = sessao.createQuery(criteria).getResultList();

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

		return cursos;
	}

	public List<Curso> recuperarPorModalidadeCurso(TipoModalidade tipoModalidade) {

		Session sessao = null;
		List<Curso> consultaModalidadeCurso = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.where(construtor.equal(raizCurso.get(Curso_.TIPO_MODALIDADE), tipoModalidade));

			criteria.orderBy(construtor.asc(raizCurso.get(Curso_.NOME)));

			consultaModalidadeCurso = sessao.createQuery(criteria).getResultList();

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

		return consultaModalidadeCurso;
	}

	public List<Curso> recuperarPorTurnoCurso(TipoTurno tipoTurno) {

		Session sessao = null;
		List<Curso> consultaTurnoCurso = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.where(construtor.equal(raizCurso.get(Curso_.TIPO_TURNO), tipoTurno));

			criteria.orderBy(construtor.asc(raizCurso.get(Curso_.NOME)));

			consultaTurnoCurso = sessao.createQuery(criteria).getResultList();

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

		return consultaTurnoCurso;
	}

	public List<Curso> recuperarPaginaPorAvaliacaoNomePreco(int pageNumber, int pageSize) {

		Session sessao = null;
		List<Curso> currentPage = new ArrayList<>();

		try {
			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Long> queryContador = construtor.createQuery(Long.class);

			queryContador.select(construtor.count(queryContador.from(Curso.class)));
			Long count = sessao.createQuery(queryContador).getSingleResult();

			CriteriaQuery<Curso> criteriaQuery = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteriaQuery.from(Curso.class);
			CriteriaQuery<Curso> select = criteriaQuery.select(raizCurso);

			criteriaQuery.orderBy(construtor.desc(raizCurso.get(Curso_.AVALIACAO)),
					construtor.asc(raizCurso.get(Curso_.NOME)), construtor.asc(raizCurso.get(Curso_.PRECO)));
			TypedQuery<Curso> typedQuery = sessao.createQuery(select);
			currentPage.addAll(typedQuery.getResultList());

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
		return currentPage;
	}

	public List<Curso> recuperarPorFiltroCurso(Optional<Long> idInstituicao, Optional<Long> idArea,
			Optional<Double> nota, Optional<TipoTurno> tipoTurno, Optional<TipoModalidade> tipoModalidade,
			Optional<Double> preco) {

		Session sessao = null;
		List<Curso> consultaFiltroCurso = null;
		List<Predicate> predicates = new ArrayList<>();
		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			if (idInstituicao.isPresent() && (idInstituicao.get() > 0)) {

				Join<Curso, Instituicao> juncaoInstituicao = raizCurso.join(Curso_.INSTITUICAO);

				predicates.add(
						construtor.or(construtor.equal(juncaoInstituicao.get(Instituicao_.ID), idInstituicao.get())));
			}

			if (idArea.isPresent() && (idArea.get() > 0)) {

				Join<Curso, Area> juncaoArea = raizCurso.join(Curso_.AREA);

				predicates.add(construtor.or(construtor.equal(juncaoArea.get(Area_.ID), idArea.get())));
			}

			if (nota.isPresent()) {
				predicates.add(construtor
						.or(construtor.lessThanOrEqualTo(raizCurso.<Double>get(Curso_.NOTA_CORTE), nota.get())));
			}

			if (tipoTurno.isPresent()) {
				predicates.add(construtor.or(construtor.equal(raizCurso.get(Curso_.TIPO_TURNO), tipoTurno.get())));
			}

			if (tipoModalidade.isPresent()) {
				predicates.add(
						construtor.or(construtor.equal(raizCurso.get(Curso_.TIPO_MODALIDADE), tipoModalidade.get())));
			}

			if (preco.isPresent() && (preco.get() != 0)) {
				predicates
						.add(construtor.or(construtor.between(raizCurso.<Double>get(Curso_.PRECO), 50.0, preco.get())));
			}

			criteria.where(construtor.and(predicates.toArray(new Predicate[predicates.size()])));

			criteria.orderBy(construtor.desc(raizCurso.get(Curso_.NOTA_CORTE)),
					construtor.desc(raizCurso.get(Curso_.PRECO)), construtor.asc(raizCurso.get(Curso_.NOME)));

			consultaFiltroCurso = sessao.createQuery(criteria).getResultList();

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

		return consultaFiltroCurso;
	}

}
