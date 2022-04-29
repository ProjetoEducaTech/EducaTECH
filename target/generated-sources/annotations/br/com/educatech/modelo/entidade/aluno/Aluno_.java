package br.com.educatech.modelo.entidade.aluno;

import br.com.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.com.educatech.modelo.entidade.curso.Curso;
import br.com.educatech.modelo.enumeraco.genero.TipoGenero;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluno.class)
public abstract class Aluno_ extends br.com.educatech.modelo.entidade.usuario.Usuario_ {

	public static volatile ListAttribute<Aluno, Avaliacao> avaliacoes;
	public static volatile SingularAttribute<Aluno, String> cpf;
	public static volatile SingularAttribute<Aluno, String> sobrenome;
	public static volatile SingularAttribute<Aluno, LocalDate> dataNascimento;
	public static volatile SingularAttribute<Aluno, Double> nota;
	public static volatile SingularAttribute<Aluno, TipoGenero> tipoGenero;
	public static volatile ListAttribute<Aluno, Curso> cursosFavorito;

	public static final String AVALIACOES = "avaliacoes";
	public static final String CPF = "cpf";
	public static final String SOBRENOME = "sobrenome";
	public static final String DATA_NASCIMENTO = "dataNascimento";
	public static final String NOTA = "nota";
	public static final String TIPO_GENERO = "tipoGenero";
	public static final String CURSOS_FAVORITO = "cursosFavorito";

}

