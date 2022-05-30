package br.senac.educatech.modelo.dao.foto;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.educatech.modelo.entidade.foto.Foto;
import br.senac.educatech.modelo.entidade.foto.Foto_;
import br.senac.educatech.modelo.factory.conexao.ConexaoFactory;

public class FotoDAOImpl implements FotoDAO {
	
	private ConexaoFactory conexao;

	public FotoDAOImpl() {

		conexao = new ConexaoFactory();
	}
	
	public Long inserirFoto(Foto foto) {

		Session sessao = null;
		Long idFoto =  null;

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