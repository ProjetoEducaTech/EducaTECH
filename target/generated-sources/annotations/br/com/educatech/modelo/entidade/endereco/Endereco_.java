package br.com.educatech.modelo.entidade.endereco;

import br.com.educatech.modelo.entidade.instituicao.Instituicao;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Endereco.class)
public abstract class Endereco_ {

	public static volatile SingularAttribute<Endereco, String> cidade;
	public static volatile SingularAttribute<Endereco, String> estado;
	public static volatile SingularAttribute<Endereco, Integer> numero;
	public static volatile SingularAttribute<Endereco, String> logradouro;
	public static volatile SingularAttribute<Endereco, String> bairro;
	public static volatile SingularAttribute<Endereco, Instituicao> instituicao;
	public static volatile SingularAttribute<Endereco, Long> id;
	public static volatile SingularAttribute<Endereco, String> referencia;
	public static volatile SingularAttribute<Endereco, String> cep;

	public static final String CIDADE = "cidade";
	public static final String ESTADO = "estado";
	public static final String NUMERO = "numero";
	public static final String LOGRADOURO = "logradouro";
	public static final String BAIRRO = "bairro";
	public static final String INSTITUICAO = "instituicao";
	public static final String ID = "id";
	public static final String REFERENCIA = "referencia";
	public static final String CEP = "cep";

}

