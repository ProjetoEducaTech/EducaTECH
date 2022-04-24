package sistema;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import sistema.modelo.dao.aluno.AlunoDAO;
import sistema.modelo.dao.aluno.AlunoDAOImpl;
import sistema.modelo.dao.area.AreaDAO;
import sistema.modelo.dao.area.AreaDAOImpl;
import sistema.modelo.dao.avaliacao.AvaliacaoDAO;
import sistema.modelo.dao.avaliacao.AvaliacaoDAOImpl;
import sistema.modelo.dao.contato.ContatoDAO;
import sistema.modelo.dao.contato.ContatoDAOImpl;
import sistema.modelo.dao.curso.CursoDAO;
import sistema.modelo.dao.curso.CursoDAOlmpl;
import sistema.modelo.dao.endereco.EnderecoDAO;
import sistema.modelo.dao.endereco.EnderecoDAOImpl;
import sistema.modelo.dao.instituicao.InstituicaoDAO;
import sistema.modelo.dao.instituicao.InstituicaoDAOImpl;
import sistema.modelo.dao.usuario.UsuarioDAO;
import sistema.modelo.dao.usuario.UsuarioDAOImpl;
import sistema.modelo.entidade.aluno.Aluno;
import sistema.modelo.entidade.area.Area;
import sistema.modelo.entidade.avaliacao.Avaliacao;
import sistema.modelo.entidade.contato.Contato;
import sistema.modelo.entidade.curso.Curso;
import sistema.modelo.entidade.endereco.Endereco;
import sistema.modelo.entidade.instituicao.Instituicao;
import sistema.modelo.entidade.usuario.Usuario;
import sistema.modelo.enumeracao.genero.Genero;
import sistema.modelo.enumeracao.metodoentrada.MetodoEntrada;
import sistema.modelo.enumeracao.modalidade.Modalidade;
import sistema.modelo.enumeracao.turno.Turno;
import sistema.modelo.util.hash.Hash;

public class Principal {

	public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {

		Scanner leitor = new Scanner(System.in);

		InstituicaoDAO instituicaoDAO = new InstituicaoDAOImpl();
		EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
		ContatoDAO contatoDAO = new ContatoDAOImpl();
		AreaDAO areaDAO = new AreaDAOImpl();
		CursoDAO cursoDAO = new CursoDAOlmpl();
		AlunoDAO alunoDAO = new AlunoDAOImpl();
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl();

		String nome = "Teste ";
		String senha = "13ee3";
		byte[] sal = Hash.gerarSal();

		String logradouro = "teste";
		int numero = 43;
		String cep = "1234";
		String bairro = "bairro teste";
		String cidade = "blumenau";
		String estado = "Santa Catarina";
		String referencia = "referencia teste";

		Endereco endereco = new Endereco();

		String cnpj = "1223";
		String desc = "Somos uma instituicao de teste";

		Instituicao instituicao = new Instituicao();

		instituicao.setNome(nome);
		instituicao.setSenha(Hash.gerarHash(sal, senha));
		instituicao.setSal(sal);
		instituicao.setCnpj(cnpj);
		instituicao.setDescricao(desc);

		instituicaoDAO.inserirInstituicao(instituicao);
		Optional<Long> idInstituicao = Optional.of(instituicao.getId());

		String nomeArea = "teste";

		Area area = new Area();

		area.setNomeArea(nomeArea);
		areaDAO.inserirArea(area);
		Optional<Long> idArea = Optional.of(area.getIdArea());

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
		sal = Hash.gerarSal();
		

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
		instituicao2.setSenha(Hash.gerarHash(sal, senha));
		instituicao2.setSal(sal);
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
		double nota = 500.4;
		String link = "link";
		Modalidade modal = Modalidade.PRESENCIAL;
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
		instituicao.inserirCurso(curso);
		Optional<Modalidade> modalidadeOp = Optional.of(modal);
		Optional<Turno> turnoOp = Optional.of(turno);

		String alunoNome = "Aluno";
		String alunoSenha = "12345";
		String cpf = "342";
		String sobrenome = "sobrenome";
		LocalDate dataNasc = LocalDate.parse("2022-05-25");
		sal = Hash.gerarSal();
		double notaCorte = 500.5;
		Genero genero = Genero.MASCULINO;

		Aluno aluno = new Aluno();
		
		
		aluno.setNome(alunoNome);
		aluno.setSenha(Hash.gerarHash(sal, alunoSenha));
		aluno.setSal(sal);
		aluno.setCpf(cpf);
		aluno.setSobrenome(sobrenome);
		aluno.setDataNascimento(dataNasc);
		aluno.setNota(notaCorte);
		aluno.setGenero(genero);
		aluno.setCursoFavorito(curso);
		alunoDAO.inserirAluno(aluno);
		Optional<Double> notaAluno = Optional.of(notaCorte);
		
		int notaAvaliacao = 5;
		String comentario = "Adorei testar esse curso muito bom";
		
		Avaliacao avaliacao = new Avaliacao();
		
		avaliacao.setNota(notaAvaliacao);
		avaliacao.setComentario(comentario);
		avaliacao.setAluno(aluno);
		avaliacao.setCursosAvaliados(curso);
		avaliacaoDAO.inserirAvaliacao(avaliacao);

		String telefonea = "3332-9898";
		String celulara = "2341-3232";
		String emaila = "testealuno@email.com.br";

		contato = new Contato();

		contato.setTelefone(telefonea);
		contato.setCelular(celulara);
		contato.setEmail(emaila);
		contato.setUsuario(aluno);

		contatoDAO.inserirContato(contato);

		String nomeCurso2 = " curso";
		String descurso2 = "descricao curso";
		int duracao2 = 230;
		MetodoEntrada enem2 = MetodoEntrada.FINACIAMENTO;
		double preco2 = 320.50;
		double nota2 = 450.4;
		String link2 = "link teste";
		Modalidade modal2 = Modalidade.PRESENCIAL;
		Turno turno2 = Turno.NOTURNO;

		Curso curso2 = new Curso();

		curso2.setNomeCurso(nomeCurso2);
		curso2.setDescricaoCurso(descurso2);
		curso2.setDuracaoCurso(duracao2);
		curso2.setMetodoEntrada(enem2);
		curso2.setPreco(preco2);
		curso2.setNotaCorte(nota2);
		curso2.setLink(link2);
		curso2.setTipoModalidade(modal2);
		curso2.setTipoTurno(turno2);
		curso2.setArea(area);
		curso2.setInstituicao(instituicao);

		cursoDAO.inserirCurso(curso2);
		instituicao.inserirCurso(curso2);

		aluno.setCursoFavorito(curso2);
		alunoDAO.atualizarAluno(aluno);

		alunoNome = "Aluno2";
		alunoSenha = "senha123";
		sal = Hash.gerarSal();
		cpf = "342435";
		sobrenome = "sobrenome2";
		dataNasc = LocalDate.parse("2022-04-25");
		notaCorte = 500.5;
		genero = Genero.FEMININO;

		Aluno aluno2 = new Aluno();

		aluno2.setNome(alunoNome);
		aluno2.setSenha(Hash.gerarHash(sal, alunoSenha));
		aluno2.setSal(sal);
		aluno2.setCpf(cpf);
		aluno2.setSobrenome(sobrenome);
		aluno2.setDataNascimento(dataNasc);
		aluno2.setNota(notaCorte);
		aluno2.setGenero(genero);
		aluno2.setCursoFavorito(curso);

		alunoDAO.inserirAluno(aluno2);

		telefonea = "3124-9898";
		celulara = "2341-2543";
		emaila = "testealuno2@email.com.br";

		contato = new Contato();

		contato.setTelefone(telefonea);
		contato.setCelular(celulara);
		contato.setEmail(emaila);
		contato.setUsuario(aluno2);

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
			Instituicao loginUsuarioInstituicao = null;
			Aluno loginUsuarioAluno = null;
			Usuario login = null;

			System.out.print("\n Qual funcao voce deseja acessar? \n");
			String[] opc = new String[] { "", " Fazer login no sistema", " Exibir instituicao ", " Exibir aluno ",
					" Exibir cursos favoritos", " Exibir enderecos", " Exibir Cursos", " Exibir Cursos por instituicao",
					" Exibir Cursos por area", " Exibir Cursos por nota de corte", "Exibir Cursos por modalidade",
					"Exibir Cursos por preco", "Exibir Cursos por turno", "Exibir filtros de Cursos",
					"Remover curso favorito", "Sair" };
			for (int i = 1; i < opc.length; i++) {
				System.out.println(i + " - " + opc[i]);
			}

			resposta = leitor.nextInt();

			switch (resposta) {

			case 1: {
				email = "testealuno@email.com.br";
				senha = "12345";
				login = usuarioDAO.loginUsuario(email,senha);

				if (login != null) {
					loginUsuarioAluno = alunoDAO.loginUsuarioAluno(login.getId());
					loginUsuarioInstituicao = instituicaoDAO.loginUsuarioInstituicao(login.getId());

					if (loginUsuarioAluno != null) {
						System.out.println("cpf: " + loginUsuarioAluno.getCpf());
						System.out.println("Nome: " + loginUsuarioAluno.getNome());
						System.out.println("Senha: " + loginUsuarioAluno.getSenha());
					} 

					if (loginUsuarioInstituicao != null) {
						System.out.println("cnpj: " + loginUsuarioInstituicao.getCnpj());
						System.out.println("Nome: " + loginUsuarioInstituicao.getNome());
						System.out.println("Senha: " + loginUsuarioInstituicao.getSenha());
					}
					}
				 else {
					System.out.println("Email ou senha invalidos");
				}
				break;
			}

			case 2: {
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

			case 3: {
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

			case 4: {
				for (Curso cursosCadastrados : favoritos) {
					System.out.println("Nome: " + cursosCadastrados.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrados.getMetodoEntrada());
					System.out.println("Preco: " + cursosCadastrados.getPreco());
					System.out.println("nota: " + cursosCadastrados.getNotaCorte());
					System.out.println();

				}
				break;
			}

			case 5: {
				for (Endereco enderecosCadastrado : enderecos) {
					System.out.println("Logradouro: " + enderecosCadastrado.getLogradouro());
					System.out.println("Referencia: " + enderecosCadastrado.getReferencia());
					System.out.println("Numero: " + enderecosCadastrado.getNumero());
					System.out.println();
				}
				break;
			}

			case 6: {
				for (Curso cursosCadastrado : cursos) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 7: {
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
						System.out.println("nota: " + cursosCadastrado.getNotaCorte());
						System.out.println();
					}
				}
				break;
			}

			case 8: {

				consultascurso = cursoDAO.consultaAreaCurso(area);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 9: {

				consultascurso = cursoDAO.consultaNotaCurso(aluno);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 10: {

				consultascurso = cursoDAO.consultaModalidadeCurso(modal2);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 11: {

				System.out.println("Informe o o preco: ");
				double custo = leitor.nextDouble();

				consultascurso = cursoDAO.consultaPrecoCurso(custo);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 12: {
				consultascurso = cursoDAO.consultaTurnoCurso(turno);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 13: {

				System.out.println("Informe o o preco: ");
				double custo = leitor.nextDouble();
				Optional<Double> precoAluno = Optional.of(custo);

				consultascurso = cursoDAO.consultaFiltroCurso(idInstituicao, idArea, notaAluno, turnoOp, modalidadeOp,
						precoAluno);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNomeCurso());
					System.out.println("Area: " + area.getNomeArea());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getMetodoEntrada());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 14: {
				aluno.removerCursoFavorito(curso);
				aluno.removerCursoFavorito(curso2);
				curso.removerAluno(aluno);
				curso2.removerAluno(aluno);
				aluno2.removerCursoFavorito(curso);
				curso.removerAluno(aluno2);
				alunoDAO.atualizarAluno(aluno);
				alunoDAO.atualizarAluno(aluno2);
				cursoDAO.atualizarCurso(curso);
				cursoDAO.atualizarCurso(curso2);
				break;
			}

			case 15: {
				System.out.println("Saindo");
				sair = 1;
				break;
			}
			}
		}

		resposta = 0;
		sair = 0;

		while (sair != 1) {

			System.out.print("\n O que você gostaria de executar? \n");
			String[] opc2 = new String[] { "", " atualizar area ", " atualizar endereço ", " atualizar instituicao ",
					" atualizar curso ", " deletar area ", " deletar endereco, instituica e contato ", " deletar tudo",
					"Sair" };

			for (int i = 1; i < opc2.length; i++) {
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
				instituicao.removerCursoInstituicao(curso);
				instituicao.removerCursoInstituicao(curso2);
				enderecoDAO.deletarEndereco(endereco);
				enderecoDAO.deletarEndereco(endereco);
				contatoDAO.deletarContato(contato);
				contatoDAO.deletarContato(contato);
				instituicaoDAO.deletarInstituicao(instituicao);
				instituicaoDAO.deletarInstituicao(instituicao2);
				alunoDAO.deletarAluno(aluno);
				alunoDAO.deletarAluno(aluno2);
				cursoDAO.deletarCurso(curso);
				cursoDAO.deletarCurso(curso2);
				areaDAO.deletarArea(area);
				break;

			}

			case 8: {
				System.out.println("Saindo");
				sair = 1;
				break;
			}
			}
		}

		leitor.close();
	}
}