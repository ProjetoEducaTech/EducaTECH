package br.senac.educatech.modelo.dao.foto;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.educatech.modelo.entidade.endereco.Endereco;
import br.senac.educatech.modelo.entidade.endereco.Endereco_;
import br.senac.educatech.modelo.entidade.foto.Foto;
import br.senac.educatech.modelo.entidade.foto.Foto_;
import br.senac.educatech.modelo.entidade.instituicao.Instituicao;
import br.senac.educatech.modelo.entidade.usuario.Usuario;
import br.senac.educatech.modelo.entidade.usuario.Usuario_;
import br.senac.educatech.modelo.factory.conexao.ConexaoFactory;

public class FotoDAOImpl implements FotoDAO {

	private ConexaoFactory conexao;

	public FotoDAOImpl() {

		conexao = new ConexaoFactory();
	}

	public Long inserirFoto(Foto foto) {

		Session sessao = null;
		Long idFoto = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			idFoto = (Long) sessao.save(foto);

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

		return idFoto;
	}

	public void atualizarFoto(Foto foto) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(foto);

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

	public void deletarFoto(Foto foto) {

		Session sessao = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(foto);

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

	public Foto recuperarFotoPeloId(Foto foto) {

		Session sessao = null;
		Foto fotoRecuperadaPeloId = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
			Root<Foto> raizFoto = criteria.from(Foto.class);

			criteria.where(construtor.equal(raizFoto.get(Foto_.ID), foto.getId()));

			fotoRecuperadaPeloId = sessao.createQuery(criteria).getSingleResult();

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

		return fotoRecuperadaPeloId;
	}

	public Foto recuperarFotoPeloIdUsuario(Usuario usuario) {
		
		Session sessao = null;
		Foto foto = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
			Root<Foto> raizFoto = criteria.from(Foto.class);

			Join<Foto, Usuario> juncaoUsuario = raizFoto.join(Foto_.USUARIO);

			ParameterExpression<Long> idUsuario = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoUsuario.get(Usuario_.ID), idUsuario));

			foto = sessao.createQuery(criteria).setParameter(idUsuario, usuario.getId()).getSingleResult();

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

		return foto;

		
		
	}

	public List<Foto> recuperarFotos() {

		Session sessao = null;
		List<Foto> fotos = null;

		try {

			sessao = conexao.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
			Root<Foto> raizFoto = criteria.from(Foto.class);

			criteria.select(raizFoto);

			fotos = sessao.createQuery(criteria).getResultList();

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

		return fotos;
	}
}