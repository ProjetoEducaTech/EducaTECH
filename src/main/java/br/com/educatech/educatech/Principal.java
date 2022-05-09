package br.com.educatech.educatech;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import br.com.educatech.casodeuso.atualizaraluno.AtualizarAlunoCasoDeUso;
import br.com.educatech.casodeuso.atualizararea.AtualizarAreaCasoDeUso;
import br.com.educatech.casodeuso.atualizaravaliacao.AtualizarAvaliacaoCasoDeUso;
import br.com.educatech.casodeuso.atualizarcontato.AtualizarContatoCasoDeUso;
import br.com.educatech.casodeuso.atualizarcurso.AtualizarCursoCasoDeUso;
import br.com.educatech.casodeuso.atualizarendereco.AtualizarEnderecoCasoDeUso;
import br.com.educatech.casodeuso.atualizarinstituicao.AtualizarInstituicaoCasoDeUso;
import br.com.educatech.casodeuso.deletarUsuario.DeletarUsuarioCasoDeUso;
import br.com.educatech.casodeuso.deletararea.DeletarAreaCasoDeUso;
import br.com.educatech.casodeuso.deletaravaliacao.DeletarAvaliacaoCasoDeUso;
import br.com.educatech.casodeuso.deletarcontato.DeletarContatoCasoDeUso;
import br.com.educatech.casodeuso.deletarcurso.DeletarCursoCasoDeUso;
import br.com.educatech.casodeuso.deletarendereco.DeletarEnderecoCasoDeUso;
import br.com.educatech.casodeuso.inseriraluno.InserirAlunoCasoDeUso;
import br.com.educatech.casodeuso.inserirarea.InserirAreaCasoDeUso;
import br.com.educatech.casodeuso.inseriravaliacao.InserirAvaliacaoCasoDeUso;
import br.com.educatech.casodeuso.inserircontato.InserirContatoCasoDeUso;
import br.com.educatech.casodeuso.inserircurso.InserirCursoCasoDeUso;
import br.com.educatech.casodeuso.inserirendereco.InserirEnderecoCasoDeUso;
import br.com.educatech.casodeuso.inseririnstituicao.InserirInstituicaoCasoDeUso;
import br.com.educatech.casodeuso.loginusuario.LoginUsuarioCasoDeUso;
import br.com.educatech.casodeuso.recuperarporcurso.RecuperarPorCursoCasoDeUso;
import br.com.educatech.casodeuso.recuperarporendereco.RecuperarPorEnderecoCasoDeUso;
import br.com.educatech.casodeuso.recuperarporinstituicao.RecuperarPorInstituicaoCasoDeUso;
import br.com.educatech.modelo.dao.aluno.AlunoDAO;
import br.com.educatech.modelo.dao.aluno.AlunoDAOImpl;
import br.com.educatech.modelo.dao.area.AreaDAO;
import br.com.educatech.modelo.dao.area.AreaDAOImpl;
import br.com.educatech.modelo.dao.avaliacao.AvaliacaoDAO;
import br.com.educatech.modelo.dao.avaliacao.AvaliacaoDAOImpl;
import br.com.educatech.modelo.dao.contato.ContatoDAO;
import br.com.educatech.modelo.dao.contato.ContatoDAOImpl;
import br.com.educatech.modelo.dao.curso.CursoDAO;
import br.com.educatech.modelo.dao.curso.CursoDAOImpl;
import br.com.educatech.modelo.dao.endereco.EnderecoDAO;
import br.com.educatech.modelo.dao.endereco.EnderecoDAOImpl;
import br.com.educatech.modelo.dao.instituicao.InstituicaoDAO;
import br.com.educatech.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.com.educatech.modelo.dao.usuario.UsuarioDAO;
import br.com.educatech.modelo.dao.usuario.UsuarioDAOImpl;
import br.com.educatech.modelo.entidade.aluno.Aluno;
import br.com.educatech.modelo.entidade.area.Area;
import br.com.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.com.educatech.modelo.entidade.contato.Contato;
import br.com.educatech.modelo.entidade.curso.Curso;
import br.com.educatech.modelo.entidade.endereco.Endereco;
import br.com.educatech.modelo.entidade.instituicao.Instituicao;
import br.com.educatech.modelo.entidade.usuario.Usuario;
import br.com.educatech.modelo.enumeraco.genero.TipoGenero;
import br.com.educatech.modelo.enumeraco.ingresso.TipoIngresso;
import br.com.educatech.modelo.enumeraco.menualuno.TipoMenuAluno;
import br.com.educatech.modelo.enumeraco.menuinicio.TipoMenuInicio;
import br.com.educatech.modelo.enumeraco.menuinstituicao.TipoMenuInstituicao;
import br.com.educatech.modelo.enumeraco.menuusuario.TipoMenuUsuario;
import br.com.educatech.modelo.enumeraco.modalidade.TipoModalidade;
import br.com.educatech.modelo.enumeraco.turno.TipoTurno;
import br.com.educatech.modelo.util.hash.Hash;

public class Principal {

	AlunoDAO alunoDAO = null;
	AreaDAO areaDAO = null;
	AvaliacaoDAO avaliacaoDAO = null;
	ContatoDAO contatoDAO = null;
	CursoDAO cursoDAO = null;
	EnderecoDAO enderecoDAO = null;
	InstituicaoDAO instituicaoDAO = null;
	UsuarioDAO usuarioDAO = null;

	static Scanner leitor = null;

	public static void main(String[] args) {

		new Principal();
	}

	Principal() {

		instituicaoDAO = new InstituicaoDAOImpl();
		enderecoDAO = new EnderecoDAOImpl();
		contatoDAO = new ContatoDAOImpl();
		areaDAO = new AreaDAOImpl();
		cursoDAO = new CursoDAOImpl();
		alunoDAO = new AlunoDAOImpl();
		usuarioDAO = new UsuarioDAOImpl();
		avaliacaoDAO = new AvaliacaoDAOImpl();
		leitor = new Scanner(System.in);

		TipoMenuInicio menuInicio = null;
		TipoMenuUsuario menuUsuario = null;
		TipoMenuAluno menuAluno = null;
		TipoMenuInstituicao menuInstituicao = null;

		System.out.println("Olá, obrigado por usar nosso sistema!");
		System.out.println("=====================================");

		do {

			try {
				menuInicio();

				menuInicio = TipoMenuInicio.values()[Integer.parseInt(leitor.nextLine()) - 1];

				switch (menuInicio) {

				case CADASTRAR:
					menuUsuario();

					menuUsuario = TipoMenuUsuario.values()[Integer.parseInt(leitor.nextLine()) - 1];

					if (menuUsuario == TipoMenuUsuario.ALUNO)
						inserirUsuarioAluno();
					else
						inserirUsuarioInstituicao();
					break;

				case LOGAR:
					loginUsuario();
					break;

				default:
					break;

				}

			} catch (Exception e) {
				System.err.println("Opção inválida!");
			}

		} while (menuInicio != TipoMenuInicio.SAIR);

		leitor.close();

	}

	public void menuInstituicao(Instituicao instituicao, Endereco endereco, Area area, Curso curso)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		List<Instituicao> instituicoes = recuperarInstituicao();
		List<Curso> cursos = recuperarCurso();
		List<Endereco> enderecos = recuperarEndereco();
		Contato contatoRecuperado = null;
		Endereco enderecoRecuperado;
		int sair = 0;

		while (sair != 1) {

			System.out.print("\n Qual funcao voce deseja acessar? \n");
			String[] opc = new String[] { "", " Exibir instituicao ", " Exibir enderecos", " Exibir Cursos",
					"Cadastrar curso", " atualizar area ", " atualizar endereço ", " atualizar instituicao ",
					" atualizar curso ", "Sair" };
			for (int i = 1; i < opc.length; i++) {
				System.out.println(i + " - " + opc[i]);
			}

			switch (leitor.nextInt()) {

			case 1: {
				for (Instituicao instituicaoCadastrado : instituicoes) {
					System.out.println("Nome: " + instituicaoCadastrado.getNome());
					System.out.println("Descricao: " + instituicaoCadastrado.getDescricao());
					System.out.println("CNPJ: " + instituicaoCadastrado.getCnpj());
					System.out.println();

					contatoRecuperado = contatoDAO.recuperarPorContatoUsuario(instituicaoCadastrado);

					System.out.println("Contato: ");
					System.out.println();
					System.out.println("Telefone: " + contatoRecuperado.getTelefone());
					System.out.println("Celular: " + contatoRecuperado.getCelular());
					System.out.println("E-mail: " + contatoRecuperado.getEmail());
					System.out.println();

					System.out.println("Enderecos: ");
					System.out.println();

					enderecoRecuperado = enderecoDAO.recuperarPorEnderecoInstituicao(instituicaoCadastrado);

					System.out.println("Logradouro: " + enderecoRecuperado.getLogradouro());
					System.out.println("Referencia: " + enderecoRecuperado.getReferencia());
					System.out.println("Numero: " + enderecoRecuperado.getNumero());
					System.out.println();
				}
				break;
			}

			case 2: {
				for (Endereco enderecosCadastrado : enderecos) {
					System.out.println("Logradouro: " + enderecosCadastrado.getLogradouro());
					System.out.println("Referencia: " + enderecosCadastrado.getReferencia());
					System.out.println("Numero: " + enderecosCadastrado.getNumero());
					System.out.println();
				}
				break;
			}

			case 3: {
				for (Curso cursosCadastrado : cursos) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoIngresso());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 4: {
				inserirCurso(area, instituicao);
				break;
			}

			case 5: {

				String areaNome = "testenome";

				area.setNome(areaNome);
				atualizarArea(area);
				break;
			}

			case 6: {

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

				atualizarEndereco(endereco);
				break;
			}

			case 7: {
				String nometu = "Teste instituicao t";
				String senhatu = "13ee3 t";
				String cnpjtu = "1223 t";
				String desctu = "Somo uma instituicao t";

				instituicao.setNome(nometu);
				instituicao.setSenha(senhatu);
				instituicao.setCnpj(cnpjtu);
				instituicao.setDescricao(desctu);

				atualizarInstituicao(instituicao);
				System.out.println("nome da instituicao" + instituicao.getNome());
				break;
			}

			case 8: {
				String nomeCursot = "nomet cursot";
				String descursot = "descrit cursot";
				int duracaot = 27;
				TipoIngresso enemt = TipoIngresso.FINANCIAMENTO;
				double precot = 11.3;
				String linkt = "linkt";
				TipoModalidade tipoModalt = TipoModalidade.SEMI_PRESENCIAL;
				TipoTurno tipoTurnot = TipoTurno.INTEGRAL;

				curso.setNome(nomeCursot);
				curso.setDescricao(descursot);
				curso.setDuracao(duracaot);
				curso.setTipoIngresso(enemt);
				curso.setPreco(precot);
				curso.setLink(linkt);
				curso.setTipoModalidade(tipoModalt);
				curso.setTipoTurno(tipoTurnot);
				curso.setArea(area);
				curso.setInstituicao(instituicao);

				atualizarCurso(curso);
				break;
			}
			}
		}
	}

	public void menuAluno(Usuario usuario, Area area, Curso curso, Instituicao instituicao)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		Aluno aluno = alunoDAO.recuperarAlunoPorId(usuario.getId());
		List<Instituicao> instituicoes = instituicaoDAO.recuperarInstituicao();
		List<Aluno> alunos = alunoDAO.recuperarAlunos();
		Contato contatoRecuperado = null;
		List<Curso> consultascurso = null;
		List<Avaliacao> consultasAvaliacoes = null;
		List<Curso> favoritos = cursoDAO.recuperarPorCursoFavorito(aluno);
		List<Curso> cursos = cursoDAO.recuperarCurso();
		double mediaCurso;
		int resposta;
		int sair = 0;

		Optional<Long> idInstituicao = Optional.of(instituicao.getId());
		Optional<Long> idArea = Optional.of(area.getId());
		Optional<TipoModalidade> tipoModalidadeOp = Optional.of(curso.getTipoModalidade());
		Optional<TipoTurno> tipoTurnoOp = Optional.of(curso.getTipoTurno());
		Optional<Double> notaAluno = Optional.of(aluno.getNota());

		leitor = new Scanner(System.in);

		while (sair != 1) {
			System.out.print("\n Qual funcao voce deseja acessar? \n");
			String[] opc = new String[] { "", " Exibir aluno ", " Exibir cursos favoritos", " Exibir Cursos",
					" Exibir Cursos por instituicao", " Exibir Cursos por area", " Exibir Cursos por nota de corte",
					"Exibir Cursos por modalidade", "Exibir Cursos por preco", "Exibir Cursos por turno",
					"Exibir filtros de Cursos", "Remover curso favorito", "Avaliacoes do curso", "Sair" };

			for (int i = 1; i < opc.length; i++) {
				System.out.println(i + " - " + opc[i]);
			}

			resposta = leitor.nextInt();

			switch (resposta) {

			case 1: {

				for (Aluno alunosCadastrados : alunos) {
					System.out.println("Nome: " + alunosCadastrados.getNome());
					System.out.println("Sobrenome: " + alunosCadastrados.getSobrenome());
					System.out.println("CPF: " + alunosCadastrados.getCpf());
					System.out.println("Genero: " + alunosCadastrados.getTipoGenero());
					System.out.println();

					contatoRecuperado = contatoDAO.recuperarPorContatoUsuario(alunosCadastrados);

					System.out.println("Contato: ");
					System.out.println();
					System.out.println("Telefone: " + contatoRecuperado.getTelefone());
					System.out.println("Celular: " + contatoRecuperado.getCelular());
					System.out.println("E-mail: " + contatoRecuperado.getEmail());
					System.out.println();
				}
				break;

			}

			case 2: {
				for (Curso cursosCadastrados : favoritos) {
					System.out.println("Nome: " + cursosCadastrados.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrados.getTipoIngresso());
					System.out.println("Preco: " + cursosCadastrados.getPreco());
					System.out.println("nota: " + cursosCadastrados.getNotaCorte());
					System.out.println();

				}
				break;
			}

			case 3: {
				for (Curso cursosCadastrado : cursos) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoIngresso());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 4: {
				for (Instituicao instituicaoCadastrado : instituicoes) {
					System.out.println("Nome: " + instituicaoCadastrado.getNome());
					System.out.println("Descricao: " + instituicaoCadastrado.getDescricao());
					System.out.println("CNPJ: " + instituicaoCadastrado.getCnpj());
					System.out.println();

					consultascurso = cursoDAO.recuperarPorInstituicaoCurso(instituicao);

					for (Curso cursosCadastrado : consultascurso) {
						System.out.println("Nome: " + cursosCadastrado.getNome());
						System.out.println("Area: " + area.getNome());
						System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoIngresso());
						System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
						System.out.println("Preco: " + cursosCadastrado.getPreco());
						System.out.println("nota: " + cursosCadastrado.getNotaCorte());
						System.out.println();
					}
				}
				break;
			}

			case 5: {

				consultascurso = cursoDAO.recuperarPorAreaCurso(area);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoIngresso());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 6: {

				consultascurso = cursoDAO.recuperarPorNotaCurso(aluno);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoIngresso());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 7: {

				consultascurso = cursoDAO.recuperarPorModalidadeCurso(curso.getTipoModalidade());

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoIngresso());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 8: {

				System.out.println("Informe o o preco: ");
				double custo = leitor.nextDouble();

				consultascurso = cursoDAO.recuperarPorPrecoCurso(custo);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoIngresso());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 9: {
				consultascurso = cursoDAO.recuperarPorTurnoCurso(curso.getTipoTurno());

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoIngresso());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 10: {

				System.out.println("Informe o o preco: ");
				double custo = leitor.nextDouble();
				Optional<Double> precoAluno = Optional.of(custo);

				consultascurso = cursoDAO.recuperarPorFiltroCurso(idInstituicao, idArea, notaAluno, tipoTurnoOp,
						tipoModalidadeOp, precoAluno);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoIngresso());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 11: {
				aluno.removerCursoFavorito(curso);
				curso.removerAluno(aluno);
				alunoDAO.atualizarAluno(aluno);
				cursoDAO.atualizarCurso(curso);
				break;
			}

			case 12: {
				consultasAvaliacoes = avaliacaoDAO.recuperarAvaliacaoCurso(curso);

				for (Avaliacao avaliacoes : consultasAvaliacoes) {
					System.out.println("Nota: " + avaliacoes.getNota());
					System.out.println("Comentario: " + avaliacoes.getComentario());
					System.out.println("");

				}

				mediaCurso = avaliacaoDAO.recuperarMediaAvaliacaoCurso(curso);
				System.out.println("Media do curso: " + mediaCurso);
				break;
			}

			case 13: {
				System.out.println("Saindo");
				break;
			}
			}
		}
		leitor.close();
	}

	public void menuInicio() {

		System.out.println("\nQual opção deseja inciar?\n");
		System.out.println("1 - Cadastrar Usuário");
		System.out.println("2 - Logar Usuário");
		System.out.println("3 - Sair do Sistema");

	}

	public void menuUsuario() {
		System.out.println("\nQual usuário?\n");
		System.out.println("1 - Candidato");
		System.out.println("2 - Recrutador");

	}

	public void menuAluno() {

		System.out.println("\nQual opção deseja continuar?\n");
		System.out.println("1 - Mostrar perfil");
		System.out.println("2 - Editar perfil");
		System.out.println("3 - Mostrar currículo");
		System.out.println("4 - Cadastrar currículo");
		System.out.println("5 - Sair do usuário");

	}

	public void menuInstituicao() {

		System.out.println("\nQual opção deseja continuar?\n");
		System.out.println("1 - Mostrar perfil");
		System.out.println("2 - Editar perfil");
		System.out.println("3 - Mostrar vagas");
		System.out.println("4 - Cadastrar vaga");
		System.out.println("5 - Excluir vaga");
		System.out.println("6 - Sair do usuário");

	}

	public void inserirUsuarioAluno() throws InvalidKeySpecException, NoSuchAlgorithmException {

		Aluno aluno = inserirAluno();
		atualizarAluno(aluno);

		Contato contato = inserirContato(aluno);
		atualizarContato(contato);

	}

	public void inserirUsuarioInstituicao() throws InvalidKeySpecException, NoSuchAlgorithmException {

		Instituicao instituicao = inserirInstituicao();
		atualizarInstituicao(instituicao);

		Contato contato = inserirContato(instituicao);
		atualizarContato(contato);

		Endereco endereco = inserirEndereco(instituicao);
		atualizarEndereco(endereco);

	}

	public void loginUsuario() {

		Usuario login = null;

		System.out.println("Para proseguir digite seu email e senha");

		System.out.println(" Email: ");
		String email = leitor.next();

		System.out.println(" Senha: ");
		String senha = leitor.next();

		LoginUsuarioCasoDeUso loginUsuarioCasoDeUso = new LoginUsuarioCasoDeUso(usuarioDAO);

		login = loginUsuarioCasoDeUso.loginUsuario(email, senha);

		Aluno idAluno = alunoDAO.recuperarAlunoPorId(login.getId());

		Instituicao idInstituicao = instituicaoDAO.recuperarInstituicaoPorId(login.getId());

		if (idAluno != null) {
			menuAluno();
		} else if (idInstituicao != null) {
			menuInstituicao();
		} else
			System.out.println("Usuário não encontrado!");

	}

	public Endereco inserirEndereco(Instituicao instituicao) {

		System.out.println("Logradouro: ");
		String logradouro = leitor.next();

		System.out.println("Numero: ");
		int numero = leitor.nextInt();

		System.out.println("CEP: ");
		String cep = leitor.next();

		System.out.println("Bairro: ");
		String bairro = leitor.next();

		System.out.println("Cidade ");
		String cidade = leitor.next();

		System.out.println("Estado: ");
		String estado = leitor.next();

		System.out.println("Referencia: ");
		String referencia = leitor.next();

		InserirEnderecoCasoDeUso inserirEnderecoCasoDeUso = new InserirEnderecoCasoDeUso(enderecoDAO);

		return inserirEnderecoCasoDeUso.inserirEndereco(
				new Endereco(logradouro, bairro, numero, cep, cidade, estado, referencia, instituicao));

	}

	public List<Endereco> recuperarEndereco() {

		RecuperarPorEnderecoCasoDeUso recuperarPorEnderecoCasoDeUso = new RecuperarPorEnderecoCasoDeUso();

		return recuperarPorEnderecoCasoDeUso.recuperarEndereco();

	}

	public Endereco atualizarEndereco(Endereco endereco) {

		AtualizarEnderecoCasoDeUso atualizarEnderecoCasoDeUso = new AtualizarEnderecoCasoDeUso(enderecoDAO);

		return atualizarEnderecoCasoDeUso.atualizarEndereco(endereco);

	}

	public Endereco deletarEndereco(Endereco endereco) {

		DeletarEnderecoCasoDeUso deletarEnderecoCasoDeUso = new DeletarEnderecoCasoDeUso(enderecoDAO);

		return deletarEnderecoCasoDeUso.deletarEndereco(endereco);

	}

	public Contato inserirContato(Usuario usuario) {

		System.out.println("Telefone: ");
		String telefone = leitor.next();

		System.out.println("Celular: ");
		String celular = leitor.next();

		System.out.println("E-mail:");
		String email = leitor.next();

		InserirContatoCasoDeUso inserirContatoCasoDeUso = new InserirContatoCasoDeUso(contatoDAO);

		return inserirContatoCasoDeUso.inserirContato(new Contato(telefone, celular, email, usuario));

	}

	public Contato atualizarContato(Contato contato) {

		AtualizarContatoCasoDeUso atualizarContatoCasoDeUso = new AtualizarContatoCasoDeUso(contatoDAO);

		return atualizarContatoCasoDeUso.atualizarContato(contato);

	}

	public Contato deletarContato(Contato contato) {

		DeletarContatoCasoDeUso deletarContatoCasoDeUso = new DeletarContatoCasoDeUso(contatoDAO);

		return deletarContatoCasoDeUso.deletarContato(contato);

	}

	public Instituicao inserirInstituicao() throws InvalidKeySpecException, NoSuchAlgorithmException {

		byte[] sal = Hash.gerarSal();

		System.out.println("Nome: ");
		String nome = leitor.next();

		System.out.println("Senha: ");
		String senha = leitor.next();

		System.out.println("CNPJ: ");
		String cnpj = leitor.next();

		System.out.println("Descricao: ");
		String desc = leitor.next();

		InserirInstituicaoCasoDeUso inserirInstituicaoCasoDeUso = new InserirInstituicaoCasoDeUso(instituicaoDAO);

		return inserirInstituicaoCasoDeUso
				.inserirInstituicao(new Instituicao(nome, Hash.gerarHash(sal, senha), sal, cnpj, desc));

	}

	public List<Instituicao> recuperarInstituicao() {

		RecuperarPorInstituicaoCasoDeUso recuperarPorInstituicaoCasoDeUso = new RecuperarPorInstituicaoCasoDeUso();

		return recuperarPorInstituicaoCasoDeUso.recuperarInstituicao();

	}

	public Instituicao atualizarInstituicao(Instituicao instituicao) {

		AtualizarInstituicaoCasoDeUso atualizarInstituicaoCasoDeUso = new AtualizarInstituicaoCasoDeUso(instituicaoDAO);

		return atualizarInstituicaoCasoDeUso.atualizarInstituicao(instituicao);

	}

	public Instituicao deletarInstituicao(Instituicao instituicao) {

		DeletarUsuarioCasoDeUso deletarUsuarioCasoDeUso = new DeletarUsuarioCasoDeUso(usuarioDAO);

		return (Instituicao) deletarUsuarioCasoDeUso.deletarUsuario(instituicao);

	}

	public Aluno inserirAluno() throws InvalidKeySpecException, NoSuchAlgorithmException {

		byte[] sal = Hash.gerarSal();

		System.out.println("Nome: ");
		String nome = leitor.next();

		System.out.println("Sobrenome: ");
		String sobrenome = leitor.next();

		System.out.println("CPF: ");
		String cpf = leitor.next();

		System.out.println("Data de nascimento(AAAA-MM-DD):");
		String data = leitor.next();
		LocalDate dataNascimento = LocalDate.parse(data);

		System.out.println("Nota: ");
		double notaCorte = leitor.nextDouble();

		System.out.println("Senha: ");
		String senha = leitor.next();

		System.out.println("Qual o seu genero: masculino, feminino ou outro:");
		String gen = leitor.next();
		TipoGenero tipoGenero = TipoGenero.valueOf(gen.toUpperCase());

		InserirAlunoCasoDeUso inserirAlunoCasoDeUso = new InserirAlunoCasoDeUso(alunoDAO);

		return inserirAlunoCasoDeUso.inserirAluno(new Aluno(nome, Hash.gerarHash(sal, senha), sal, cpf, sobrenome,
				notaCorte, dataNascimento, tipoGenero));

	}

	public Aluno atualizarAluno(Aluno aluno) {

		AtualizarAlunoCasoDeUso atualizarAlunoCasoDeUso = new AtualizarAlunoCasoDeUso(alunoDAO);

		return atualizarAlunoCasoDeUso.atualizarAluno(aluno);

	}

	public Aluno deletarAluno(Aluno aluno) {

		DeletarUsuarioCasoDeUso deletarUsuarioCasoDeUso = new DeletarUsuarioCasoDeUso(usuarioDAO);

		return (Aluno) deletarUsuarioCasoDeUso.deletarUsuario(aluno);

	}

	public Area inserirArea() {

		System.out.println("Nome da area: ");
		String nomeArea = leitor.next();

		InserirAreaCasoDeUso inserirAreaCasoDeUso = new InserirAreaCasoDeUso(areaDAO);

		return inserirAreaCasoDeUso.inserirArea(new Area(nomeArea));

	}

	public Area atualizarArea(Area area) {
		AtualizarAreaCasoDeUso atualizarAreaCasoDeUso = new AtualizarAreaCasoDeUso(areaDAO);

		return atualizarAreaCasoDeUso.atualizarArea(area);

	}

	public Area deletarArea(Area area) {

		DeletarAreaCasoDeUso deletarAreaCasoDeUso = new DeletarAreaCasoDeUso(areaDAO);

		return deletarAreaCasoDeUso.deletarArea(area);

	}

	public Curso inserirCurso(Area area, Instituicao instituicao) {

		System.out.println("Nome do curso: ");
		String nomeCurso = leitor.next();

		System.out.println("Descricao do curso: ");
		String descurso = leitor.next();

		System.out.println("Duracao em horas: ");
		int duracao = leitor.nextInt();

		System.out.println("Preco: ");
		double preco = leitor.nextDouble();

		System.out.println("Nota de corte: ");
		double nota = leitor.nextDouble();

		System.out.println("Link: ");
		String link = leitor.next();

		System.out.println(
				"Metodo de ingresso enem, transferencia, vestibular, bolsa de estudos, segunda graduacao, financiamento, historico escolar: ");
		String entrada = leitor.next();
		TipoIngresso tipoIngresso = TipoIngresso.valueOf(entrada.toUpperCase());

		System.out.println("Modalidade EAD, presencial, semi_presencial, AO_VIVO: ");
		String modalidade = leitor.next();
		TipoModalidade tipoModal = TipoModalidade.valueOf(modalidade.toUpperCase());

		System.out.println("Turno matutino, vespertino, noturno, integral: ");
		String turnoCurso = leitor.next();
		TipoTurno tipoTurno = TipoTurno.valueOf(turnoCurso.toUpperCase());

		InserirCursoCasoDeUso inserirCursoCasoDeUso = new InserirCursoCasoDeUso(cursoDAO);

		return inserirCursoCasoDeUso.inserirCurso(new Curso(nomeCurso, descurso, duracao, preco, link, nota,
				tipoIngresso, tipoModal, tipoTurno, area, instituicao));

	}

	public List<Curso> recuperarCurso() {

		RecuperarPorCursoCasoDeUso recuperarPorCursoCasoDeUso = new RecuperarPorCursoCasoDeUso();

		return recuperarPorCursoCasoDeUso.recuperarCurso();

	}

	public Curso atualizarCurso(Curso curso) {

		AtualizarCursoCasoDeUso atualizarCursoCasoDeUso = new AtualizarCursoCasoDeUso(cursoDAO);

		return atualizarCursoCasoDeUso.atualizarCurso(curso);

	}

	public Curso deletarCurso(Curso curso) {

		DeletarCursoCasoDeUso deletarCursoCasoDeUso = new DeletarCursoCasoDeUso(cursoDAO);

		return deletarCursoCasoDeUso.deletarCurso(curso);

	}

	public Avaliacao inserirAvalicao(Aluno aluno, Curso curso) {

		int notaAvaliacao = 5;
		String comentario = "Adorei testar esse curso muito bom";

		InserirAvaliacaoCasoDeUso inserirAvaliacaoCasoDeUso = new InserirAvaliacaoCasoDeUso(avaliacaoDAO);

		return inserirAvaliacaoCasoDeUso.inserirAvaliacao(new Avaliacao(notaAvaliacao, comentario, aluno, curso));

	}

	public Avaliacao atualizarAvaliacao(Avaliacao avaliacao) {

		AtualizarAvaliacaoCasoDeUso atualizarAvaliacaoCasoDeUso = new AtualizarAvaliacaoCasoDeUso(avaliacaoDAO);

		return atualizarAvaliacaoCasoDeUso.atualizarAvaliacao(avaliacao);

	}

	public Avaliacao deletarAvaliacao(Avaliacao avaliacao) {

		DeletarAvaliacaoCasoDeUso deletarAvaliacaoCasoDeUso = new DeletarAvaliacaoCasoDeUso(avaliacaoDAO);

		return deletarAvaliacaoCasoDeUso.deletarAvaliacao(avaliacao);

	}

}
