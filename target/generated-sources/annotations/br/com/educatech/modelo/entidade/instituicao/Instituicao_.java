package br.com.educatech.modelo.entidade.instituicao;

import br.com.educatech.modelo.entidade.curso.Curso;
import br.com.educatech.modelo.entidade.endereco.Endereco;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Instituicao.class)
public abstract class Instituicao_ extends br.com.educatech.modelo.entidade.usuario.Usuario_ {

	public static volatile ListAttribute<Instituicao, Curso> cursos;
	public static volatile SingularAttribute<Instituicao, Endereco> endereco;
	public static volatile SingularAttribute<Instituicao, String> cnpj;
	public static volatile SingularAttribute<Instituicao, String> descricao;

	public static final String CURSOS = "cursos";
	public static final String ENDERECO = "endereco";
	public static final String CNPJ = "cnpj";
	public static final String DESCRICAO = "descricao";

}

