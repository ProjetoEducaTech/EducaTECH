package sistema;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import sistema.modelo.dao.aluno.AlunoDAO;
import sistema.modelo.dao.aluno.AlunoDAOImpl;
import sistema.modelo.dao.area.AreaDAO;
import sistema.modelo.dao.area.AreaDAOImpl;
import sistema.modelo.dao.contato.ContatoDAO;
import sistema.modelo.dao.contato.ContatoDAOImpl;
import sistema.modelo.dao.curso.CursoDAO;
import sistema.modelo.dao.curso.CursoDAOlmpl;
import sistema.modelo.dao.endereco.EnderecoDAO;
import sistema.modelo.dao.endereco.EnderecoDAOImpl;
import sistema.modelo.dao.instituicao.InstituicaoDAO;
import sistema.modelo.dao.instituicao.InstituicaoDAOImpl;
import sistema.modelo.entidade.aluno.Aluno;
import sistema.modelo.entidade.area.Area;
import sistema.modelo.entidade.contato.Contato;
import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.entidade.endereco.Endereco;
import sistema.modelo.entidade.instituicao.Instituicao;
import sistema.modelo.entidade.usuario.Usuario;
import sistema.modelo.enumeracao.Turno;
import sistema.modelo.enumeracao.genero.Genero;
import sistema.modelo.enumeracao.metodoentrada.MetodoEntrada;
import sistema.modelo.enumeracao.modalidade.Modalidade;

public class Principal {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);

		InstituicaoDAO instituicaoDAO = new InstituicaoDAOImpl();
		EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
		ContatoDAO contatoDAO = new ContatoDAOImpl();
		AreaDAO areaDAO = new AreaDAOImpl();
		CursoDAO cursoDAO = new CursoDAOlmpl();
		AlunoDAO alunoDAO = new AlunoDAOImpl();

		String nome = "Teste ";
		String senha = "13ee3";

		String logradouro = "teste";
		int numero = 43;
		String cep = "1234";
		String bairro = "bairro teste";
		String cidade = "blumenau";
		String estado = "Santa Catarina";
		String referencia = "referencia teste";

		Endereco endereco = new Endereco();

		String cnpj = "1223";
		String desc = "Somo uma instituicao de teste";

		Instituicao instituicao = new Instituicao();

		instituicao.setNome(nome);
		instituicao.setSenha(senha);
		instituicao.setCnpj(cnpj);
		instituicao.setDescricao(desc);

		instituicaoDAO.inserirInstituicao(instituicao);

		String nomeArea = "teste";

		Area area = new Area();

		area.setNomeArea(nomeArea);
		areaDAO.inserirArea(area);

		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setCep(cep);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setReferencia(referencia);
		endereco.setInstituicao(instituicao);

		enderecoDAO.inserirEndereco(endereco);

		String telefone = "3332-3232";
		String celular = "5432-3232";
		String email = "teste@email.com.br";

		Contato contato = new Contato();

		contato.setTelefone(telefone);
		contato.setCelular(celular);
		contato.setEmail(email);
		contato.setUsuario(instituicao);

		contatoDAO.inserirContato(contato);

		nome = "Teste instituicao";
		senha = "senha";

		logradouro = "rua teste";
		numero = 34;
		cep = "1234567";
		bairro = "bairro teste2";
		cidade = "Blumenau";
		estado = "Santa Catarina";
		referencia = "referencia teste";

		endereco = new Endereco();

		cnpj = "12236785";
		desc = "Somo a segunda instituicao de teste";

		Instituicao instituicao2 = new Instituicao();

		instituicao2.setNome(nome);
		instituicao2.setSenha(senha);
		instituicao2.setCnpj(cnpj);
		instituicao2.setDescricao(desc);

		instituicaoDAO.inserirInstituicao(instituicao2);

		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setCep(cep);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setReferencia(referencia);
		endereco.setInstituicao(instituicao2);

		enderecoDAO.inserirEndereco(endereco);

		telefone = "3982-3232";
		celular = "5432-2176";
		email = "teste2@email.com.br";

		contato = new Contato();

		contato.setTelefone(telefone);
		contato.setCelular(celular);
		contato.setEmail(email);
		contato.setUsuario(instituicao2);

		contatoDAO.inserirContato(contato);

		String nomeCurso = "nome curso";
		String descurso = "descri curso";
		int duracao = 23;
		MetodoEntrada enem = MetodoEntrada.ENEM;
		double preco = 120.3;
		double nota = 300.4;
		String link = "link";
		Modalidade modal = Modalidade.AOVIVO;
		Turno turno = Turno.NOTURNO;

		Curso curso = new Curso();

		curso.setNomeCurso(nomeCurso);
		curso.setDescricaoCurso(descurso);
		curso.setDuracaoCurso(duracao);
		curso.setMetodoEntrada(enem);
		curso.setPreco(preco);
		curso.setNotaCorte(nota);
		curso.setLink(link);
		curso.setTipoModalidade(modal);
		curso.setTipoTurno(turno);
		curso.setArea(area);
		curso.setInstituicao(instituicao);

		cursoDAO.inserirCurso(curso);

		String nomeCurso2 = "nome curso2";
		String descurso2 = "descricao curso";
		int duracao2 = 230;
		MetodoEntrada enem2 = MetodoEntrada.FINACIAMENTO;
		double preco2 = 320.50;
		double nota2 = 450.4;
		String link2 = "link teste";
		Modalidade modal2 = Modalidade.PRESENCIAL;
		Turno turno2 = Turno.NOTURNO;

		curso = new Curso();

		curso.setNomeCurso(nomeCurso2);
		curso.setDescricaoCurso(descurso2);
		curso.setDuracaoCurso(duracao2);
		curso.setMetodoEntrada(enem2);
		curso.setPreco(preco2);
		curso.setNotaCorte(nota2);
		curso.setLink(link2);
		curso.setTipoModalidade(modal2);
		curso.setTipoTurno(turno2);
		curso.setArea(area);
		curso.setInstituicao(instituicao2);

		cursoDAO.inserirCurso(curso);

		String alunoNome = "Aluno";
		String alunoSenha = "12345";
		String cpf = "342";
		String sobrenome = "sobrenome";
		LocalDate dataNasc = LocalDate.parse("2022-05-25");
		double notaCorte = 500.5;
		Genero genero = Genero.MASCULINO;

		Aluno aluno = new Aluno();

		aluno.setNome(alunoNome);
		aluno.setSenha(alunoSenha);
		aluno.setCpf(cpf);
		aluno.setSobrenome(sobrenome);
		aluno.setDataNascimento(dataNasc);
		aluno.setNota(notaCorte);
		aluno.setGenero(genero);
		aluno.adicionarCursoFavorito(curso);

		alunoDAO.inserirAluno(aluno);

		String telefonea = "3332-9898";
		String celulara = "2341-3232";
		String emaila = "testealuno@email.com.br";

		contato = new Contato();

		contato.setTelefone(telefonea);
		contato.setCelular(celulara);
		contato.setEmail(emaila);
		contato.setUsuario(aluno);

		contatoDAO.inserirContato(contato);

		int resposta;

		int sair = 0;

		while (sair != 1) {

			resposta = 0;

			List<Instituicao> instituicoes = instituicaoDAO.recuperarInstituicoes();
			List<Aluno> alunos = alunoDAO.recuperarAlunos();
			List<Endereco> enderecos = enderecoDAO.recuperarEndereco();
			Contato contatoRecuperado = null;
			List<Endereco> enderecosRecuperados = null;
			List<Curso> consultascurso = null;
			List<Curso> favoritos = cursoDAO.exibirCursosFavoritos(aluno);
			List<Curso> cursos = cursoDAO.recuperarCursos();
			Usuario loginUsuarioInstituicao = null;
			Usuario loginUsuarioAluno = null;

			System.out.print("\n Qual funcao voce deseja acessar? \n");
			String[] opc = new String[] { "", " Fazer login Instituicao ", " Fazer login Aluno ",
					" Exibir instituicao ", " Exibir aluno ", " Exibir cursos favoritos", " Exibir enderecos",
					" Exibir Cursos", " Exibir Cursos por instituicao", " Exibir Cursos por area",
					"Exibir Cursos por nota de corte", "Exibir Cursos por modalidade", "Exibir Cursos por preco",
					"Exibir Cursos por turno" };
			for (int i = 1; i < 14; i++) {
				System.out.println(i + " - " + opc[i]);
			}

			resposta = leitor.nextInt();

			switch (resposta) {

			case 1: {
				loginUsuarioInstituicao = instituicaoDAO.loginUsuarioInstituicao(instituicao);

				System.out.println("Nome: " + loginUsuarioInstituicao.getNome());
				System.out.println("Senha: " + loginUsuarioInstituicao.getSenha());
				break;
			}

			case 2: {
				loginUsuarioAluno = alunoDAO.loginUsuarioAluno(aluno);

				System.out.println("Nome: " + loginUsuarioAluno.getNome());
				System.out.println("Senha: " + loginUsuarioAluno.getSenha());
				break;
			}

			case 3: {
				for (Instituicao instituicaoCadastrado : instituicoes) {
					System.out.println("Nome: " + instituicaoCadastrado.getNome());
					System.out.println("Descricao: " + instituicaoCadastrado.getDescricao());
					System.out.println("CNPJ: " + instituicaoCadastrado.getCnpj());
					System.out.println();

					contatoRecuperado = contatoDAO.recuperarContatoUsuario(instituicaoCadastrado);

					System.out.println("Contato: ");
					System.out.println();
					System.out.println("Telefone: " + contatoRecuperado.getTelefone());
					System.out.println("Celular: " + contatoRecuperado.getCelular());
					System.out.println("E-mail: " + contatoRecuperado.getEmail());
					System.out.println();

					System.out.println("Enderecos: ");
					System.out.println();

					enderecosRecuperados = enderecoDAO.recuperarEnderecoInstituicao(instituicaoCadastrado);
					for (Endereco enderecoRecuperado : enderecosRecuperados) {
						System.out.println("Logradouro: " + enderecoRecuperado.getLogradouro());
						System.out.println("Referencia: " + enderecoRecuperado.getReferencia());
						System.out.println("Numero: " + enderecoRecuperado.getNumero());
						System.out.println();

					}
				}
				break;

			}

			case 4: {
				for (Aluno alunosCadastrados : alunos) {
					System.out.println("Nome: " + alunosCadastrados.getNome());
					System.out.println("Sobrenome: " + alunosCadastrados.getSobrenome());
					System.out.println("CPF: " + alunosCadastrados.getCpf());
					System.out.println("Genero: " + alunosCadastrados.getGenero());
					System.out.println();

					contatoRecuperado = contatoDAO.recuperarContatoUsuario(alunosCadastrados);

					System.out.println("Contato: ");
					System.out.println();
					System.out.println("Telefone: " + contatoRecuperado.getTelefone());
					System.out.println("Celular: " + contatoRecuperado.getCelular());
					System.out.println("E-mail: " + contatoRecuperado.getEmail());
					System.out.println();

				}
				break;

			}

			case 5: {
				for (Curso cursosCadastrados : favoritos) {
					System.out.println("Nome: " + cursosCadastrados.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrados.getMetodoEntrada());
					System.out.println("Preco: " + cursosCadastrados.getPreco());
					System.out.println();

				}
				break;
			}

			case 6: {
				for (Endereco enderecosCadastrado : enderecos) {
					System.out.println("Logradouro: " + enderecosCadastrado.getLogradouro());
					System.out.println("Referencia: " + enderecosCadastrado.getReferencia());
					System.out.println("Numero: " + enderecosCadastrado.getNumero());
					System.out.println();

				}
				break;
			}

			case 7: {
				for (Curso cursosCadastrado : cursos) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println();

				}
				break;
			}

			case 8: {
				for (Instituicao instituicaoCadastrado : instituicoes) {
					System.out.println("Nome: " + instituicaoCadastrado.getNome());
					System.out.println("Descricao: " + instituicaoCadastrado.getDescricao());
					System.out.println("CNPJ: " + instituicaoCadastrado.getCnpj());
					System.out.println();

					consultascurso = cursoDAO.consultaInstituicaoCurso(instituicao);

					for (Curso cursosCadastrado : consultascurso) {
						System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
						System.out.println("Area: " + area.getNomeArea());
						System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
						System.out.println("Preco: " + cursosCadastrado.getPreco());
						System.out.println();
					}
				}
				break;
			}

			case 9: {

				consultascurso = cursoDAO.consultaAreaCurso(area);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println();
				}
				break;
			}

			case 10: {

				consultascurso = cursoDAO.consultaNotaCurso(aluno);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println();
				}
				break;
			}

			case 11: {

				consultascurso = cursoDAO.consultaModalidadeCurso(modal2);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println();
				}
				break;
			}

			case 12: {

				System.out.println("Informe o o preco: ");
				double custo = leitor.nextDouble();

				consultascurso = cursoDAO.consultaPrecoCurso(custo);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println();
				}
				break;
			}

			case 13: {
				consultascurso = cursoDAO.consultaTurnoCurso(turno);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println();
				}
			}
			}

			System.out.println("sair");
			sair = leitor.nextInt();

		}

		resposta = 0;
		sair = 0;

		while (sair != 1) {

			System.out.print("\n O que você gostaria de executar? \n");
			String[] opc2 = new String[] { "", " atualizar area ", " atualizar endereço ", " atualizar instituicao ",
					" atualizar curso ", " deletar area ", " deletar endereco, instituica e contato ",
					" deletar tudo" };

			for (int i = 1; i < 8; i++) {
				System.out.println(i + " - " + opc2[i]);
			}
			resposta = leitor.nextInt();

			switch (resposta) {

			case 1: {

				String areaNome = "testenome";

				area.setNomeArea(areaNome);

				areaDAO.atualizarArea(area);

				break;
			}

			case 2: {

				String logeradourotu = "teste t";
				int numerotu = 3;
				String ceptu = "1234567";
				String bairrotu = "bairro teste t";
				String cidadetu = "blumenau t";
				String estadotu = "Santa Catarina t";
				String referenciatu = "referencia teste t";

				endereco.setLogradouro(logeradourotu);
				endereco.setNumero(numerotu);
				endereco.setCep(ceptu);
				endereco.setBairro(bairrotu);
				endereco.setCidade(cidadetu);
				endereco.setEstado(estadotu);
				endereco.setReferencia(referenciatu);

				enderecoDAO.atualizarEndereco(endereco);

				break;
			}

			case 3: {

				String nometu = "Teste instituicao t";
				String senhatu = "13ee3 t";
				String cnpjtu = "1223 t";
				String desctu = "Somo uma instituicao t";

				instituicao.setNome(nometu);
				instituicao.setSenha(senhatu);
				instituicao.setCnpj(cnpjtu);
				instituicao.setDescricao(desctu);

				instituicaoDAO.atualizarInstituicao(instituicao);
				System.out.println("nome da instituicao" + instituicao.getNome());

				break;
			}

			case 4: {

				String nomeCursot = "nomet cursot";
				String descursot = "descrit cursot";
				int duracaot = 27;
				MetodoEntrada enemt = MetodoEntrada.FINACIAMENTO;
				double precot = 11.3;
				String linkt = "linkt";
				Modalidade modalt = Modalidade.SEMIPRESENCIAL;
				Turno turnot = Turno.INTEGRAL;

				curso.setNomeCurso(nomeCursot);
				curso.setDescricaoCurso(descursot);
				curso.setDuracaoCurso(duracaot);
				curso.setMetodoEntrada(enemt);
				curso.setPreco(precot);
				curso.setLink(linkt);
				curso.setTipoModalidade(modalt);
				curso.setTipoTurno(turnot);
				curso.setArea(area);
				curso.setInstituicao(instituicao);

				cursoDAO.atualizarCurso(curso);

				break;

			}

			case 5: {
				areaDAO.deletarArea(area);

				break;
			}

			case 6: {
				instituicaoDAO.deletarInstituicao(instituicao);
				enderecoDAO.deletarEndereco(endereco);
				contatoDAO.deletarContato(contato);

				break;
			}

			case 7: {

				enderecoDAO.deletarEndereco(endereco);
				contatoDAO.deletarContato(contato);
				contatoDAO.deletarContato(contato);
				instituicaoDAO.deletarInstituicao(instituicao);
				alunoDAO.deletarAluno(aluno);
				cursoDAO.deletarCurso(curso);
				areaDAO.deletarArea(area);
				instituicaoDAO.deletarInstituicao(instituicao);

				break;

			}
			}

			System.out.println("sair");
			sair = leitor.nextInt();
		}

		leitor.close();
	}

}