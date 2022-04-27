package sistema.modelo.dao.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import sistema.modelo.entidade.aluno.Aluno;
import sistema.modelo.entidade.area.Area;
import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.entidade.instituicao.Instituicao;
import sistema.modelo.enumeracao.modalidade.Modalidade;
import sistema.modelo.enumeracao.turno.Turno;
import sistema.modelo.factory.conexao.FactoryConexao;

public class CursoDAOlmpl implements CursoDAO {

	private FactoryConexao banco;

	public CursoDAOlmpl() {

		banco = new FactoryConexao();

	}

	public void inserirCurso(Curso curso) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
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

	public void deletarCurso(Curso curso) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
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
	}

	public void atualizarCurso(Curso curso) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
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
	}

	public List<Curso> consultaCursos() {

		Session sessao = null;
		List<Curso> curso = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.select(raizCurso);
			criteria.orderBy(construtor.asc(raizCurso.get("nomeCurso")));

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

	public List<Curso> consultaInstituicaoCurso(Instituicao instituicao) {

		Session sessao = null;
		List<Curso> consultaCurso = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			Join<Curso, Instituicao> juncaoInstituicao = raizCurso.join("instituicao");

			ParameterExpression<Long> idinst = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoInstituicao.get("id"), idinst));

			criteria.orderBy(construtor.asc(raizCurso.get("nomeCurso")));

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

	public List<Curso> consultaAreaCurso(Area area) {

		Session sessao = null;
		List<Curso> consultaArea = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			Join<Curso, Area> juncaoArea = raizCurso.join("area");

			ParameterExpression<Long> idArea = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoArea.get("idArea"), idArea));

			criteria.orderBy(construtor.asc(raizCurso.get("nomeCurso")));

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

	public List<Curso> consultaNotaCurso(Aluno aluno) {

		Session sessao = null;
		List<Curso> consultaNota = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.where(construtor.lessThanOrEqualTo(raizCurso.get("notaCorte"), aluno.getNota()));

			criteria.orderBy(construtor.desc(raizCurso.get("notaCorte")), construtor.asc(raizCurso.get("nomeCurso")));

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

	public List<Curso> exibirCursosFavoritos(Aluno aluno) {

		Session sessao = null;
		List<Curso> favoritos = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizFavorito = criteria.from(Curso.class);

			Join<Curso, Aluno> juncaoAluno = raizFavorito.join("alunos");

			ParameterExpression<Long> idaluno = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoAluno.get("id"), idaluno));

			criteria.orderBy(construtor.asc(raizFavorito.get("nomeCurso")));

			favoritos = sessao.createQuery(criteria).setParameter(idaluno, aluno.getId()).getResultList();

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

	public List<Curso> consultaPrecoCurso(double custo) {

		Session sessao = null;
		List<Curso> cursos = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.where(construtor.between(raizCurso.get("preco"), 50.0, custo));

			criteria.orderBy(construtor.desc(raizCurso.get("preco")), construtor.asc(raizCurso.get("nomeCurso")));

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

	public List<Curso> consultaModalidadeCurso(Modalidade modalidade) {

		Session sessao = null;
		List<Curso> consultaModalidadeCurso = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.where(construtor.equal(raizCurso.get("tipoModalidade"), modalidade));

			criteria.orderBy(construtor.asc(raizCurso.get("nomeCurso")));

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

	public List<Curso> consultaTurnoCurso(Turno turno) {

		Session sessao = null;
		List<Curso> consultaTurnoCurso = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.where(construtor.equal(raizCurso.get("tipoTurno"), turno));

			criteria.orderBy(construtor.asc(raizCurso.get("nomeCurso")));

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

	public List<Curso> consultaFiltroCurso(Optional<Long> idInsti, Optional<Long> isArea, Optional<Double> notaAluno,
			Optional<Turno> turno, Optional<Modalidade> modalidade, Optional<Double> precoAluno) {

		Session sessao = null;
		List<Curso> consultaFiltroCurso = null;
		List<Predicate> predicates = new ArrayList<>();
		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			if (idInsti.isPresent() && (idInsti.get() > 0)) {

				Join<Curso, Instituicao> juncaoInstituicao = raizCurso.join("instituicao");

				predicates.add(construtor.or(construtor.equal(juncaoInstituicao.get("id"), idInsti.get())));
			}

			if (isArea.isPresent() && (isArea.get() > 0)) {

				Join<Curso, Area> juncaoArea = raizCurso.join("area");

				predicates.add(construtor.or(construtor.equal(juncaoArea.get("idArea"), isArea.get())));
			}

			if (notaAluno.isPresent()) {
				predicates.add(construtor.or(construtor.lessThanOrEqualTo(raizCurso.get("notaCorte"), notaAluno.get())));
			}

			if (turno.isPresent()) {
				predicates.add(construtor.or(construtor.equal(raizCurso.get("tipoTurno"), turno.get())));
			}

			if (modalidade.isPresent()) {
				predicates.add(construtor.or(construtor.equal(raizCurso.get("tipoModalidade"), modalidade.get())));
			}

			if (precoAluno.isPresent() && (precoAluno.get() != 0)) {
				predicates.add(construtor.or(construtor.between(raizCurso.get("preco"), 50.0, precoAluno.get())));
			}

			criteria.where(construtor.and(predicates.toArray(new Predicate[predicates.size()])));

			criteria.orderBy(construtor.desc(raizCurso.get("notaCorte")), construtor.desc(raizCurso.get("preco")),
					construtor.asc(raizCurso.get("nomeCurso")));

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
