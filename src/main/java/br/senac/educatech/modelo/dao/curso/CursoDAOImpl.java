package br.senac.educatech.modelo.dao.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.educatech.modelo.entidade.aluno.Aluno;
import br.senac.educatech.modelo.entidade.aluno.Aluno_;
import br.senac.educatech.modelo.entidade.area.Area;
import br.senac.educatech.modelo.entidade.area.Area_;
import br.senac.educatech.modelo.entidade.curso.Curso;
import br.senac.educatech.modelo.entidade.curso.Curso_;
import br.senac.educatech.modelo.entidade.instituicao.Instituicao;
import br.senac.educatech.modelo.entidade.instituicao.Instituicao_;
import br.senac.educatech.modelo.enumeracao.modalidade.Modalidade;
import br.senac.educatech.modelo.enumeracao.turno.Turno;
import br.senac.educatech.modelo.factory.conexao.ConexaoFactory;

public class CursoDAOImpl implements CursoDAO {

	private ConexaoFactory conexao;

	public CursoDAOImpl() {

		conexao = new ConexaoFactory();

	}

	public Long inserirCurso(Curso curso) {

		Session sessao = null;
		Long idCurso = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			idCurso = (Long) sessao.save(curso);

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

		return idCurso;
	}

	public void atualizarCurso(Curso curso) {

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
	}

	public void deletarCurso(Curso curso) {

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
	}

	public Curso recuperarCursoPeloId(Curso curso) {

		Session sessao = null;
		Curso cursosRecuperados = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.where(construtor.equal(raizCurso.get(Curso_.ID), curso.getId()));

			cursosRecuperados = sessao.createQuery(criteria).getSingleResult();

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

		return cursosRecuperados;
	}
	
	public Curso recuperarCursoComAvaliacoesPeloId(Curso curso) {
		
		Session sessao = null;
		Curso cursosRecuperados = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);
			raizCurso.fetch(Curso_.AVALIACOES, JoinType.LEFT);

			criteria.where(construtor.equal(raizCurso.get(Curso_.ID), curso.getId()));

			cursosRecuperados = sessao.createQuery(criteria).getSingleResult();

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

		return cursosRecuperados;
	}
	
	public Curso recuperarCursoComAlunosPeloId(Curso curso) {

		Session sessao = null;
		Curso cursosRecuperados = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);
			raizCurso.fetch(Curso_.ALUNOS, JoinType.LEFT);

			criteria.where(construtor.equal(raizCurso.get(Curso_.ID), curso.getId()));

			cursosRecuperados = sessao.createQuery(criteria).getSingleResult();

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

		return cursosRecuperados;
	}
		
	

	public List<Curso> recuperarCursos() {

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

	public List<Curso> recuperarCursosPelaInstituicao(Instituicao instituicao) {

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

	public List<Curso> recuperarCursosPelaArea(Area area) {

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

	public List<Curso> recuperarCursosPelaNota(Aluno aluno) {

		Session sessao = null;
		List<Curso> consultaNota = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			//criteria.where(construtor.lessThanOrEqualTo(raizCurso.<Double>get(Curso_.NOTA_CORTE), aluno.getNota()));

		//	criteria.orderBy(construtor.desc(raizCurso.get(Curso_.NOTA_CORTE)),
		//			construtor.asc(raizCurso.get(Curso_.NOME)));

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

	public List<Curso> recuperarCursosFavoritos(Aluno aluno) {

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

	public List<Curso> recuperarCursosPeloPreco(double custo) {

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

	public List<Curso> recuperarCursosPelaModalidade(Modalidade modalidade) {

		Session sessao = null;
		List<Curso> consultaModalidadeCurso = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.where(construtor.equal(raizCurso.get(Curso_.MODALIDADE), modalidade));

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

	public List<Curso> recuperarCursosPeloTurno(Turno turno) {

		Session sessao = null;
		List<Curso> consultaTurnoCurso = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.where(construtor.equal(raizCurso.get(Curso_.TURNO), turno));

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

	public double recuperaMenorPrecoCurso() {

		Session sessao = null;
		double menorPreco = 0;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Double> criteria = construtor.createQuery(Double.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.multiselect(construtor.min(raizCurso.<Double>get(Curso_.PRECO)));

			menorPreco = sessao.createQuery(criteria).getSingleResult();

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

		return menorPreco;
	}

	public double recuperarMaiorPrecoCurso() {

		Session sessao = null;
		double maiorPreco = 0;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Double> criteria = construtor.createQuery(Double.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			criteria.multiselect(construtor.max(raizCurso.<Double>get(Curso_.PRECO)));

			maiorPreco = sessao.createQuery(criteria).getSingleResult();

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

		return maiorPreco;
	}

	public List<Curso> recuperarPaginaPorAvaliacaoNomePreco(int numeroDaPagina, int tamanhoDaPagina) {

		Session sessao = null;
		List<Curso> paginaAtual = new ArrayList<>();

		try {
			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Long> queryContador = construtor.createQuery(Long.class);

			queryContador.select(construtor.count(queryContador.from(Curso.class)));
			Long contar = sessao.createQuery(queryContador).getSingleResult();

			CriteriaQuery<Curso> criteriaQuery = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteriaQuery.from(Curso.class);
			CriteriaQuery<Curso> select = criteriaQuery.select(raizCurso);

			criteriaQuery.orderBy(construtor.desc(raizCurso.get(Curso_.AVALIACOES)),
					construtor.asc(raizCurso.get(Curso_.NOME)), construtor.asc(raizCurso.get(Curso_.PRECO)));
			TypedQuery<Curso> typedQuery = sessao.createQuery(select);
			paginaAtual.addAll(typedQuery.getResultList());

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
		return paginaAtual;
	}

	public List<Curso> recuperarCursoPorFiltro(Optional<Long> idInstituicao, Optional<Long> idArea,
			Optional<Double> nota, Optional<Turno> turno, Optional<Modalidade> modalidade, Optional<Double> preco,
			Optional<Double> duracao) {

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

			if (modalidade.isPresent() && (modalidade.get().ordinal() < 4)) {
				predicates.add(construtor.and(construtor.equal(raizCurso.get(Curso_.MODALIDADE), modalidade.get())));
			}
			
			if (turno.isPresent() && (turno.get().ordinal() < 5)) {
				predicates.add(construtor.and(construtor.equal(raizCurso.get(Curso_.TURNO), turno.get())));
			}

			if (nota.isPresent() && (nota.get() > 0)) {
				predicates.add(construtor
						.and(construtor.lessThanOrEqualTo(raizCurso.<Double>get(Curso_.NOTA_CORTE), nota.get())));
			}

			if (idArea.isPresent() && (idArea.get() > 0)) {


				predicates.add(construtor.and(construtor.equal(raizCurso.get(Curso_.AREA), idArea.get())));
			}

			if (preco.isPresent() && (preco.get() != 0)) {
				predicates
						.add(construtor.or(construtor.between(raizCurso.<Double>get(Curso_.PRECO), 50.0, preco.get())));
			}

			if (duracao.isPresent() && (duracao.get() != 0)) {
				predicates.add(
						construtor.or(construtor.between(raizCurso.<Double>get(Curso_.DURACAO), 50.0, duracao.get())));
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

	public List<Curso> recuperarCursosPorFiltroInicial(Optional<Modalidade> modalidade, Optional<Double> notaDeCorte,
			Optional<Turno> turno, Optional<Long> idArea) {

		Session sessao = null;
		List<Curso> consultaFiltroInicial = null;
		List<Predicate> predicates = new ArrayList<>();
		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Curso> criteria = construtor.createQuery(Curso.class);
			Root<Curso> raizCurso = criteria.from(Curso.class);

			if (modalidade.isPresent() && (modalidade.get().ordinal() < 4)) {
				predicates.add(construtor.and(construtor.equal(raizCurso.get(Curso_.MODALIDADE), modalidade.get())));
			}
			
			if (turno.isPresent() && (turno.get().ordinal() < 5)) {
				predicates.add(construtor.and(construtor.equal(raizCurso.get(Curso_.TURNO), turno.get())));
			}

			if (notaDeCorte.isPresent() && (notaDeCorte.get() > 0)) {
				predicates.add(construtor
						.and(construtor.lessThanOrEqualTo(raizCurso.<Double>get(Curso_.NOTA_CORTE), notaDeCorte.get())));
			}

			if (idArea.isPresent() && (idArea.get() > 0)) {


				predicates.add(construtor.and(construtor.equal(raizCurso.get(Curso_.AREA), idArea.get())));
			}

			criteria.where(construtor.and(predicates.toArray(new Predicate[predicates.size()])));

			criteria.orderBy(construtor.desc(raizCurso.get(Curso_.NOTA_CORTE)));

			consultaFiltroInicial = sessao.createQuery(criteria).getResultList();

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

		return consultaFiltroInicial;
	}

}
