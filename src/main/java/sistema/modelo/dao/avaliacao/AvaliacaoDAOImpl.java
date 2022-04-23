package sistema.modelo.dao.avaliacao;
import org.hibernate.Session;

import sistema.modelo.entidade.avaliacao.Avaliacao;
import sistema.modelo.factory.conexao.FactoryConexao;

public class AvaliacaoDAOImpl implements AvaliacaoDAO {

	private FactoryConexao banco;

	public AvaliacaoDAOImpl() {
		banco = new FactoryConexao();
	}

	public void inserirAvaliacao(Avaliacao avaliacao) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(avaliacao);

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

	public void deletarAvaliacao(Avaliacao avaliacao) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(avaliacao);

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

	public void atualizarAvaliacao(Avaliacao avaliacao) {

		Session sessao = null;

		try {

			sessao = banco.getConectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(avaliacao);

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

}