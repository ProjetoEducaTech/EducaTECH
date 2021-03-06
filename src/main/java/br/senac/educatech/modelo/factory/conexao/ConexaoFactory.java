package br.senac.educatech.modelo.factory.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexaoFactory {

	public SessionFactory getConexao() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(br.senac.educatech.modelo.entidade.aluno.Aluno.class);
		configuracao.addAnnotatedClass(br.senac.educatech.modelo.entidade.area.Area.class);
		configuracao.addAnnotatedClass(br.senac.educatech.modelo.entidade.avaliacao.Avaliacao.class);
		configuracao.addAnnotatedClass(br.senac.educatech.modelo.entidade.contato.Contato.class);
		configuracao.addAnnotatedClass(br.senac.educatech.modelo.entidade.curso.Curso.class);
		configuracao.addAnnotatedClass(br.senac.educatech.modelo.entidade.endereco.Endereco.class);
		configuracao.addAnnotatedClass(br.senac.educatech.modelo.entidade.instituicao.Instituicao.class);
		configuracao.addAnnotatedClass(br.senac.educatech.modelo.entidade.usuario.Usuario.class);
		configuracao.addAnnotatedClass(br.senac.educatech.modelo.entidade.foto.Foto.class);

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
	}
}