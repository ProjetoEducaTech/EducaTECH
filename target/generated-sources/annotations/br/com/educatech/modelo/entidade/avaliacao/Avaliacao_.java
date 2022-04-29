package br.com.educatech.modelo.entidade.avaliacao;

import br.com.educatech.modelo.entidade.aluno.Aluno;
import br.com.educatech.modelo.entidade.curso.Curso;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Avaliacao.class)
public abstract class Avaliacao_ {

	public static volatile SingularAttribute<Avaliacao, Aluno> aluno;
	public static volatile SingularAttribute<Avaliacao, Curso> curso;
	public static volatile SingularAttribute<Avaliacao, Long> id;
	public static volatile SingularAttribute<Avaliacao, String> comentario;
	public static volatile SingularAttribute<Avaliacao, Integer> nota;

	public static final String ALUNO = "aluno";
	public static final String CURSO = "curso";
	public static final String ID = "id";
	public static final String COMENTARIO = "comentario";
	public static final String NOTA = "nota";

}

