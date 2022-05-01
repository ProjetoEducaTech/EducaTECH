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
import br.com.educatech.modelo.entidade.area.Area;
import br.com.educatech.modelo.entidade.curso.Curso;
import br.com.educatech.modelo.entidade.instituicao.Instituicao;
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
			criteria.orderBy(construtor.asc(raizCurso.get("nome")));

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

			Join<Curso, Instituicao> juncaoInstituicao = raizCurso.join("instituicao");

			ParameterExpression<Long> idinst = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoInstituicao.get("id"), idinst));

			criteria.orderBy(construtor.asc(raizCurso.get("nome")));

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

			Join<Curso, Area> juncaoArea = raizCurso.join("area");

			ParameterExpression<Long> idArea = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoArea.get("id"), idArea));

			criteria.orderBy(construtor.asc(raizCurso.get("nome")));

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

			criteria.where(construtor.lessThanOrEqualTo(raizCurso.<Double>get("notaCorte"), aluno.getNota()));

			criteria.orderBy(construtor.desc(raizCurso.get("notaCorte")), construtor.asc(raizCurso.get("nome")));

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

			Join<Curso, Aluno> juncaoAluno = raizFavorito.join("alunos");

			ParameterExpression<Long> idAluno = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoAluno.get("id"), idAluno));

			criteria.orderBy(construtor.asc(raizFavorito.get("nome")));

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

			criteria.where(construtor.between(raizCurso.<Double>get("preco"), 50.0, custo));

			criteria.orderBy(construtor.desc(raizCurso.get("preco")), construtor.asc(raizCurso.get("nome")));

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

			criteria.where(construtor.equal(raizCurso.get("tipoModalidade"), tipoModalidade));

			criteria.orderBy(construtor.asc(raizCurso.get("nome")));

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

			criteria.where(construtor.equal(raizCurso.get("tipoTurno"), tipoTurno));

			criteria.orderBy(construtor.asc(raizCurso.get("nome")));

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

				Join<Curso, Instituicao> juncaoInstituicao = raizCurso.join("instituicao");

				predicates.add(construtor.or(construtor.equal(juncaoInstituicao.get("id"), idInstituicao.get())));
			}

			if (idArea.isPresent() && (idArea.get() > 0)) {

				Join<Curso, Area> juncaoArea = raizCurso.join("area");

				predicates.add(construtor.or(construtor.equal(juncaoArea.get("id"), idArea.get())));
			}

			if (nota.isPresent()) {
				predicates.add(
						construtor.or(construtor.lessThanOrEqualTo(raizCurso.<Double>get("notaCorte"), nota.get())));
			}

			if (tipoTurno.isPresent()) {
				predicates.add(construtor.or(construtor.equal(raizCurso.get("tipoTurno"), tipoTurno.get())));
			}

			if (tipoModalidade.isPresent()) {
				predicates.add(construtor.or(construtor.equal(raizCurso.get("tipoModalidade"), tipoModalidade.get())));
			}

			if (preco.isPresent() && (preco.get() != 0)) {
				predicates.add(construtor.or(construtor.between(raizCurso.<Double>get("preco"), 50.0, preco.get())));
			}

			criteria.where(construtor.and(predicates.toArray(new Predicate[predicates.size()])));

			criteria.orderBy(construtor.desc(raizCurso.get("notaCorte")), construtor.desc(raizCurso.get("preco")),
					construtor.asc(raizCurso.get("nome")));

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

	public List<Curso> paginaPorAvaliacaoNomePreco(int pageNumber, int pageSize) {

		Session sessao = null;
		List<Curso> currentPage = new ArrayList<>();

		try{
			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Long> queryContador = construtor.createQuery(Long.class);

			queryContador.select(construtor.count(queryContador.from(Curso.class)));
			Long count = sessao.createQuery(queryContador).getSingleResult();

			CriteriaQuery<Curso> criteriaQuery = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteriaQuery.from(Curso.class);
			CriteriaQuery<Curso> select = criteriaQuery.select(raizCurso);

			criteriaQuery.orderBy(construtor.desc(raizCurso.get("avaliacao")), construtor.asc(raizCurso.get("nomeCurso")), construtor.asc(raizCurso.get("preco")));
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

}
