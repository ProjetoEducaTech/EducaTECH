package br.com.educatech.modelo.entidade.usuario;

import br.com.educatech.modelo.entidade.contato.Contato;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, Long> id;
	public static volatile SingularAttribute<Usuario, Contato> contato;
	public static volatile SingularAttribute<Usuario, byte[]> sal;

	public static final String SENHA = "senha";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String CONTATO = "contato";
	public static final String SAL = "sal";

}

