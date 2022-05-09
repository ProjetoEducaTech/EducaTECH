package br.com.educatech.modelo.entidade.curso;

import br.com.educatech.modelo.entidade.aluno.Aluno;
import br.com.educatech.modelo.entidade.area.Area;
import br.com.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.com.educatech.modelo.entidade.instituicao.Instituicao;
import br.com.educatech.modelo.enumeraco.ingresso.TipoIngresso;
import br.com.educatech.modelo.enumeraco.modalidade.TipoModalidade;
import br.com.educatech.modelo.enumeraco.turno.TipoTurno;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Curso.class)
public abstract class Curso_ {

	public static volatile SingularAttribute<Curso, Area> area;
	public static volatile SingularAttribute<Curso, TipoTurno> tipoTurno;
	public static volatile ListAttribute<Curso, Aluno> alunos;
	public static volatile SingularAttribute<Curso, String> link;
	public static volatile SingularAttribute<Curso, Instituicao> instituicao;
	public static volatile SingularAttribute<Curso, String> nome;
	public static volatile ListAttribute<Curso, Avaliacao> avaliacao;
	public static volatile SingularAttribute<Curso, Double> notaCorte;
	public static volatile SingularAttribute<Curso, String> descricao;
	public static volatile SingularAttribute<Curso, Double> preco;
	public static volatile SingularAttribute<Curso, TipoIngresso> tipoIngresso;
	public static volatile SingularAttribute<Curso, Long> id;
	public static volatile SingularAttribute<Curso, Integer> duracao;
	public static volatile SingularAttribute<Curso, TipoModalidade> tipoModalidade;

	public static final String AREA = "area";
	public static final String TIPO_TURNO = "tipoTurno";
	public static final String ALUNOS = "alunos";
	public static final String LINK = "link";
	public static final String INSTITUICAO = "instituicao";
	public static final String NOME = "nome";
	public static final String AVALIACAO = "avaliacao";
	public static final String NOTA_CORTE = "notaCorte";
	public static final String DESCRICAO = "descricao";
	public static final String PRECO = "preco";
	public static final String TIPO_INGRESSO = "tipoIngresso";
	public static final String ID = "id";
	public static final String DURACAO = "duracao";
	public static final String TIPO_MODALIDADE = "tipoModalidade";

}

