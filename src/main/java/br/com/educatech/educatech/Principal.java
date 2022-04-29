package br.com.educatech.educatech;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import br.com.educatech.casodeuso.solicitarlogin.SolicitarLoginCasoDeUso;
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
import br.com.educatech.modelo.enumeraco.metodoentrada.TipoMetodoEntrada;
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

		Instituicao instituicao = new Instituicao();
		Area area = new Area();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();
		Instituicao instituicao2 = new Instituicao();
		Endereco endereco2 = new Endereco();
		Contato contato2 = new Contato();
		Curso curso1 = new Curso();
		Aluno aluno = new Aluno();
		Avaliacao avaliacao1 = new Avaliacao();
		Contato contato3 = new Contato();
		Curso curso2 = new Curso();
		Aluno alunoAtualizado = new Aluno();
		Aluno aluno2 = new Aluno();
		Avaliacao avaliacao2 = new Avaliacao();
		Contato contato4 = new Contato();
		Usuario usuario = new Usuario();

		instituicao = inserirInstituicao1();
		area = inserirArea();
		endereco = inserirEndereco1(instituicao);
		contato = inserirContato1(instituicao);
		instituicao2 = inserirInstituicao2();
		endereco2 = inserirEndereco2(instituicao2);
		contato2 = inserirContato2(instituicao2);
		curso1 = inserirCurso1(area, instituicao);
		aluno = inserirAluno1();
		avaliacao1 = inserirAvalicao1(aluno, curso1);
		contato3 = inserirContato3(aluno);
		curso2 = inserirCurso2(area, instituicao);
		alunoAtualizado = atualizarAluno(aluno);
		aluno2 = inserirAluno2();
		avaliacao2 = inserirAvaliacao2(aluno2, curso1);
		contato4 = inserirContato4(aluno2);
		usuario = new Usuario();

		instituicao.inserirCurso(curso1);

		TipoTurno turno = curso1.getTipoTurno();
		TipoModalidade modal = curso1.getTipoModalidade();
		TipoModalidade modal2 = curso2.getTipoModalidade();

		Optional<Long> idInstituicao = Optional.of(instituicao.getId());
		Optional<Long> idArea = Optional.of(area.getId());
		Optional<TipoModalidade> modalidadeOp = Optional.of(modal);
		Optional<TipoTurno> turnoOp = Optional.of(turno);
		Optional<Double> notaAluno = Optional.of(aluno.getNota());

		instituicao.inserirCurso(curso2);

		aluno.setCursoFavorito(curso2);

		int resposta;

		int sair = 0;

		while (sair != 1) {

			resposta = 0;

			List<Instituicao> instituicoes = instituicaoDAO.recuperarInstituicao();
			List<Aluno> alunos = alunoDAO.recuperarAlunos();
			List<Endereco> enderecos = enderecoDAO.recuperarEndereco();
			List<Integer> media = new ArrayList<>();
			Contato contatoRecuperado = null;
			List<Endereco> enderecosRecuperados = null;
			List<Curso> consultascurso = null;
			List<Avaliacao> consultasAvaliacoes = null;
			List<Curso> favoritos = cursoDAO.recuperarPorCursoFavorito(aluno);
			List<Curso> cursos = cursoDAO.recuperarCurso();
			double mediaCurso;
			Instituicao loginUsuarioInstituicao = null;
			Aluno loginUsuarioAluno = null;
			Usuario login = null;

			System.out.print("\n Qual funcao voce deseja acessar? \n");
			String[] opc = new String[] { "", " Fazer login no sistema", " Exibir instituicao ", " Exibir aluno ",
					" Exibir cursos favoritos", " Exibir enderecos", " Exibir Cursos", " Exibir Cursos por instituicao",
					" Exibir Cursos por area", " Exibir Cursos por nota de corte", "Exibir Cursos por modalidade",
					"Exibir Cursos por preco", "Exibir Cursos por turno", "Exibir filtros de Cursos",
					"Remover curso favorito", "Avaliacoes do curso", "Sair" };

			for (int i = 1; i < opc.length; i++) {
				System.out.println(i + " - " + opc[i]);
			}

			resposta = leitor.nextInt();

			switch (resposta) {

			case 1: {
				String email = "testealuno@email.com.br";
				String senha = "12345";

				SolicitarLoginCasoDeUso solicitarLoginCasoDeUso = new SolicitarLoginCasoDeUso(alunoDAO);

				login = usuarioDAO.loginUsuario(email, senha);

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
				} else {
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

					contatoRecuperado = contatoDAO.recuperarPorContatoUsuario(instituicaoCadastrado);

					System.out.println("Contato: ");
					System.out.println();
					System.out.println("Telefone: " + contatoRecuperado.getTelefone());
					System.out.println("Celular: " + contatoRecuperado.getCelular());
					System.out.println("E-mail: " + contatoRecuperado.getEmail());
					System.out.println();

					System.out.println("Enderecos: ");
					System.out.println();

					enderecosRecuperados = enderecoDAO.recuperarPorEnderecoInstituicao(instituicaoCadastrado);
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

			case 4: {
				for (Curso cursosCadastrados : favoritos) {
					System.out.println("Nome: " + cursosCadastrados.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrados.getTipoMetodoEntrada());
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
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoMetodoEntrada());
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

					consultascurso = cursoDAO.recuperarPorInstituicaoCurso(instituicao);

					for (Curso cursosCadastrado : consultascurso) {
						System.out.println("Nome: " + cursosCadastrado.getNome());
						System.out.println("Area: " + area.getNome());
						System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoMetodoEntrada());
						System.out.println("Preco: " + cursosCadastrado.getPreco());
						System.out.println("nota: " + cursosCadastrado.getNotaCorte());
						System.out.println();
					}
				}
				break;
			}

			case 8: {

				consultascurso = cursoDAO.recuperarPorAreaCurso(area);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 9: {

				consultascurso = cursoDAO.recuperarPorNotaCurso(aluno);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 10: {

				consultascurso = cursoDAO.recuperarPorModalidadeCurso(modal2);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoMetodoEntrada());
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

				consultascurso = cursoDAO.recuperarPorPrecoCurso(custo);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoMetodoEntrada());
					System.out.println("Modalidade: " + cursosCadastrado.getTipoModalidade());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 12: {
				consultascurso = cursoDAO.recuperarPorTurnoCurso(turno);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoMetodoEntrada());
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

				consultascurso = cursoDAO.recuperarPorFiltroCurso(idInstituicao, idArea, notaAluno, turnoOp,
						modalidadeOp, precoAluno);

				for (Curso cursosCadastrado : consultascurso) {
					System.out.println("Nome: " + cursosCadastrado.getNome());
					System.out.println("Area: " + area.getNome());
					System.out.println("Metodo de entrada: " + cursosCadastrado.getTipoMetodoEntrada());
					System.out.println("Preco: " + cursosCadastrado.getPreco());
					System.out.println("nota: " + cursosCadastrado.getNotaCorte());
					System.out.println();
				}
				break;
			}

			case 14: {
				aluno.removerCursoFavorito(curso1);
				aluno.removerCursoFavorito(curso2);
				curso1.removerAluno(aluno);
				curso2.removerAluno(aluno);
				aluno2.removerCursoFavorito(curso1);
				curso1.removerAluno(aluno2);
				atualizarAluno(aluno);
				atualizarAluno(aluno2);
				atualizarCurso(curso1);
				atualizarCurso(curso2);
				break;
			}

			case 15: {
				consultasAvaliacoes = avaliacaoDAO.avaliacaoCurso(curso1);

				for (Avaliacao avaliacoes : consultasAvaliacoes) {
					System.out.println("Nota: " + avaliacoes.getNota());
					System.out.println("Comentario: " + avaliacoes.getComentario());
					System.out.println("");

					media.add(avaliacoes.getNota());
				}

				mediaCurso = avaliacaoDAO.mediaAvaliacoesCurso(media);
				System.out.println("Media do curso: " + mediaCurso);
				break;
			}

			case 16: {
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
			String[] opc2 = new String[] { "", " atualizar area ", " atualizar endere�o ", " atualizar instituicao ",
					" atualizar curso ", " deletar area ", " deletar endereco, instituica e contato ", " deletar tudo",
					"Sair" };

			for (int i = 1; i < opc2.length; i++) {
				System.out.println(i + " - " + opc2[i]);
			}
			resposta = leitor.nextInt();

			switch (resposta) {

			case 1: {

				String areaNome = "testenome";

				area.setNome(areaNome);
				atualizarArea(area);

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

				atualizarEndereco(endereco);

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

				atualizarInstituicao(instituicao);
				System.out.println("nome da instituicao" + instituicao.getNome());

				break;
			}

			case 4: {

				String nomeCursot = "nomet cursot";
				String descursot = "descrit cursot";
				int duracaot = 27;
				TipoMetodoEntrada enemt = TipoMetodoEntrada.FINANCIAMENTO;
				double precot = 11.3;
				String linkt = "linkt";
				TipoModalidade modalt = TipoModalidade.SEMIPRESENCIAL;
				TipoTurno turnot = TipoTurno.INTEGRAL;

				curso1.setNome(nomeCursot);
				curso1.setDescricao(descursot);
				curso1.setDuracao(duracaot);
				curso1.setTipoMetodoEntrada(enemt);
				curso1.setPreco(precot);
				curso1.setLink(linkt);
				curso1.setTipoModalidade(modalt);
				curso1.setTipoTurno(turnot);
				curso1.setArea(area);
				curso1.setInstituicao(instituicao);

				atualizarCurso(curso1);

				break;

			}

			case 5: {
				deletarArea(area);

				break;
			}

			case 6: {
				instituicaoDAO.deletarInstituicao(instituicao);
				deletarEndereco(endereco);
				deletarContato(contato);

				break;
			}

			case 7: {
				instituicao.removerCursoInstituicao(curso1);
				instituicao.removerCursoInstituicao(curso2);
				deletarEndereco(endereco);
				deletarEndereco(endereco);
				deletarContato(contato);
				deletarContato(contato);
				instituicaoDAO.deletarInstituicao(instituicao);
				instituicaoDAO.deletarInstituicao(instituicao2);
				alunoDAO.deletarAluno(aluno);
				alunoDAO.deletarAluno(aluno2);
				deletarCurso(curso1);
				deletarCurso(curso2);
				deletarArea(area);
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

	public Endereco inserirEndereco1(Instituicao instituicao) {

		String logradouro = "teste";
		int numero = 43;
		String cep = "1234";
		String bairro = "bairro teste";
		String cidade = "blumenau";
		String estado = "Santa Catarina";
		String referencia = "referencia teste";

		Endereco endereco = new Endereco();

		InserirEnderecoCasoDeUso inserirEnderecoCasoDeUso = new InserirEnderecoCasoDeUso(enderecoDAO);

		endereco = inserirEnderecoCasoDeUso.inserirEndereco(
				new Endereco(logradouro, bairro, numero, cep, cidade, estado, referencia, instituicao));

		return endereco;
	}

	public Endereco inserirEndereco2(Instituicao instituicao) {

		String logradouro = "rua teste";
		int numero = 34;
		String cep = "1234567";
		String bairro = "bairro teste2";
		String cidade = "Blumenau";
		String estado = "Santa Catarina";
		String referencia = "referencia teste";

		Endereco endereco = new Endereco();

		InserirEnderecoCasoDeUso inserirEnderecoCasoDeUso = new InserirEnderecoCasoDeUso(enderecoDAO);

		endereco = inserirEnderecoCasoDeUso.inserirEndereco(
				new Endereco(logradouro, bairro, numero, cep, cidade, estado, referencia, instituicao));

		return endereco;
	}

	public Endereco atualizarEndereco(Endereco endereco) {

		Endereco enderecoAtualizado = new Endereco();

		AtualizarEnderecoCasoDeUso atualizarEnderecoCasoDeUso = new AtualizarEnderecoCasoDeUso(enderecoDAO);

		enderecoAtualizado = atualizarEnderecoCasoDeUso.atualizarEndereco(endereco);

		return enderecoAtualizado;
	}

	public Endereco deletarEndereco(Endereco endereco) {

		Endereco enderecoDeletado = new Endereco();

		DeletarEnderecoCasoDeUso deletarEnderecoCasoDeUso = new DeletarEnderecoCasoDeUso(enderecoDAO);

		enderecoDeletado = deletarEnderecoCasoDeUso.deletarEndereco(endereco);

		return enderecoDeletado;
	}

	public Instituicao inserirInstituicao1() {

		byte[] sal = Hash.gerarSal();
		String nome = "Teste ";
		String senha = "13ee3";
		String cnpj = "1223";
		String desc = "Somos uma instituicao de teste";

		Instituicao instituicao = new Instituicao();

		InserirInstituicaoCasoDeUso inserirInstituicaoCasoDeUso = new InserirInstituicaoCasoDeUso(instituicaoDAO);

		try {
			instituicao = inserirInstituicaoCasoDeUso
					.inserirInstituicao(new Instituicao(nome, Hash.gerarHash(sal, senha), cnpj, desc, sal));
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return instituicao;
	}

	public Instituicao inserirInstituicao2() {

		byte[] sal = Hash.gerarSal();
		String nome = "Teste instituicao";
		String senha = "senha";
		String cnpj = "12236785";
		String desc = "Somo a segunda instituicao de teste";

		Instituicao instituicao = new Instituicao();

		InserirInstituicaoCasoDeUso inserirInstituicaoCasoDeUso = new InserirInstituicaoCasoDeUso(instituicaoDAO);

		try {
			instituicao = inserirInstituicaoCasoDeUso
					.inserirInstituicao(new Instituicao(nome, Hash.gerarHash(sal, senha), cnpj, desc, sal));
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return instituicao;
	}

	public Instituicao atualizarInstituicao(Instituicao instituicao) {

		Instituicao instituicaoAtualizado = new Instituicao();

		AtualizarInstituicaoCasoDeUso atualizarInstituicaoCasoDeUso = new AtualizarInstituicaoCasoDeUso(instituicaoDAO);

		instituicaoAtualizado = atualizarInstituicaoCasoDeUso.atualizarInstituicao(instituicao);

		return instituicaoAtualizado;
	}

//	public Instituicao deletarInstituicao(Instituicao instituicao) {
//
//		Instituicao instituicaoDeletado = new Instituicao();
//
//		DeletarInstituicaoCasoDeUso deletarInstituicaoCasoDeUso = new DeletarInstituicaoCasoDeUso(instituicaoDAO);
//
//		instituicaoDeletado = deletarInstituicaoCasoDeUso.deletarInstituicao(instituicao);
//
//		return instituicaoDeletado;
//	}

	public Area inserirArea() {

		String nomeArea = "teste";

		Area area = new Area();

		InserirAreaCasoDeUso inserirAreaCasoDeUso = new InserirAreaCasoDeUso(areaDAO);

		area = inserirAreaCasoDeUso.inserirArea(new Area(nomeArea));

		return area;
	}

	public Area atualizarArea(Area area) {

		Area areaAtualizado = new Area();

		AtualizarAreaCasoDeUso atualizarAreaCasoDeUso = new AtualizarAreaCasoDeUso(areaDAO);

		areaAtualizado = atualizarAreaCasoDeUso.atualizarArea(area);

		return areaAtualizado;
	}

	public Area deletarArea(Area area) {

		Area areaDeletado = new Area();

		DeletarAreaCasoDeUso deletarAreaCasoDeUso = new DeletarAreaCasoDeUso(areaDAO);

		areaDeletado = deletarAreaCasoDeUso.deletarArea(area);

		return areaDeletado;
	}

	public Contato inserirContato1(Instituicao instituicao) {

		String telefone = "3332-3232";
		String celular = "5432-3232";
		String email = "teste@email.com.br";

		Contato contato = new Contato();

		InserirContatoCasoDeUso inserirContatoCasoDeUso = new InserirContatoCasoDeUso(contatoDAO);

		contato = inserirContatoCasoDeUso.inserirContato(new Contato(telefone, celular, email, instituicao));

		return contato;
	}

	public Contato inserirContato2(Instituicao instituicao) {

		String telefone = "3982-3232";
		String celular = "5432-2176";
		String email = "teste2@email.com.br";

		Contato contato = new Contato();

		InserirContatoCasoDeUso inserirContatoCasoDeUso = new InserirContatoCasoDeUso(contatoDAO);

		contato = inserirContatoCasoDeUso.inserirContato(new Contato(telefone, celular, email, instituicao));

		return contato;
	}

	public Contato inserirContato3(Aluno aluno) {

		String telefonea = "3332-9898";
		String celulara = "2341-3232";
		String emaila = "testealuno@email.com.br";

		Contato contato = new Contato();

		InserirContatoCasoDeUso inserirContatoCasoDeUso = new InserirContatoCasoDeUso(contatoDAO);

		contato = inserirContatoCasoDeUso.inserirContato(new Contato(telefonea, celulara, emaila, aluno));

		return contato;
	}

	public Contato inserirContato4(Aluno aluno) {

		String telefonea = "3124-9898";
		String celulara = "2341-2543";
		String emaila = "testealuno2@email.com.br";

		Contato contato = new Contato();

		InserirContatoCasoDeUso inserirContatoCasoDeUso = new InserirContatoCasoDeUso(contatoDAO);

		contato = inserirContatoCasoDeUso.inserirContato(new Contato(telefonea, celulara, emaila, aluno));

		return contato;
	}

	public Contato atualizarContato(Contato contato) {

		Contato contatoAtualizado = new Contato();

		AtualizarContatoCasoDeUso atualizarContatoCasoDeUso = new AtualizarContatoCasoDeUso(contatoDAO);

		contatoAtualizado = atualizarContatoCasoDeUso.atualizarContato(contato);

		return contatoAtualizado;
	}

	public Contato deletarContato(Contato contato) {

		Contato contatoDeletado = new Contato();

		DeletarContatoCasoDeUso deletarContatoCasoDeUso = new DeletarContatoCasoDeUso(contatoDAO);

		contatoDeletado = deletarContatoCasoDeUso.deletarContato(contato);

		return contatoDeletado;
	}

	public Curso inserirCurso1(Area area, Instituicao instituicao) {

		String nomeCurso = "nome curso";
		String descurso = "descri curso";
		String link = "link";
		int duracao = 23;
		double preco = 120.3;
		double nota = 500.4;
		TipoMetodoEntrada enem = TipoMetodoEntrada.ENEM;
		TipoModalidade modal = TipoModalidade.PRESENCIAL;
		TipoTurno turno = TipoTurno.NOTURNO;

		Curso curso = new Curso();

		InserirCursoCasoDeUso inserirCursoCasoDeUso = new InserirCursoCasoDeUso(cursoDAO);

		curso = inserirCursoCasoDeUso.inserirCurso(
				new Curso(nomeCurso, descurso, duracao, preco, link, nota, enem, modal, turno, area, instituicao));

		return curso;
	}

	public Curso inserirCurso2(Area area, Instituicao instituicao) {

		String nomeCurso = " curso";
		String descurso = "descricao curso";
		int duracao = 230;
		TipoMetodoEntrada enem = TipoMetodoEntrada.FINANCIAMENTO;
		double preco = 320.50;
		double nota = 450.4;
		String link = "link teste";
		TipoModalidade modal = TipoModalidade.PRESENCIAL;
		TipoTurno turno = TipoTurno.NOTURNO;

		Curso curso = new Curso();

		InserirCursoCasoDeUso inserirCursoCasoDeUso = new InserirCursoCasoDeUso(cursoDAO);

		curso = inserirCursoCasoDeUso.inserirCurso(
				new Curso(nomeCurso, descurso, duracao, preco, link, nota, enem, modal, turno, area, instituicao));

		return curso;
	}

	public Curso atualizarCurso(Curso curso) {

		Curso cursoAtualizado = new Curso();

		AtualizarCursoCasoDeUso atualizarCursoCasoDeUso = new AtualizarCursoCasoDeUso(cursoDAO);

		cursoAtualizado = atualizarCursoCasoDeUso.atualizarCurso(curso);

		return cursoAtualizado;
	}

	public Curso deletarCurso(Curso curso) {

		Curso cursoDeletado = new Curso();

		DeletarCursoCasoDeUso deletarCursoCasoDeUso = new DeletarCursoCasoDeUso(cursoDAO);

		cursoDeletado = deletarCursoCasoDeUso.deletarCurso(curso);

		return cursoDeletado;
	}

	public Aluno inserirAluno1() {

		byte[] sal = Hash.gerarSal();
		String alunoNome = "Aluno";
		String alunoSenha = "12345";
		String cpf = "342";
		String sobrenome = "sobrenome";
		LocalDate dataNasc = LocalDate.parse("2022-05-25");
		double notaCorte = 500.5;
		TipoGenero genero = TipoGenero.MASCULINO;

		Aluno aluno = new Aluno();

		InserirAlunoCasoDeUso inserirAlunoCasoDeUso = new InserirAlunoCasoDeUso(alunoDAO);

		try {
			aluno = inserirAlunoCasoDeUso.inserirAluno(new Aluno(alunoNome, Hash.gerarHash(sal, alunoSenha), cpf,
					sobrenome, notaCorte, dataNasc, genero, sal));
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aluno;
	}

	public Aluno inserirAluno2() {

		byte[] sal = Hash.gerarSal();
		String alunoNome = "Aluno2";
		String alunoSenha = "senha123";
		String cpf = "342435";
		String sobrenome = "sobrenome2";
		LocalDate dataNasc = LocalDate.parse("2022-04-25");
		double notaCorte = 500.5;
		TipoGenero genero = TipoGenero.FEMININO;

		Aluno aluno = new Aluno();

		InserirAlunoCasoDeUso inserirAlunoCasoDeUso = new InserirAlunoCasoDeUso(alunoDAO);

		try {
			aluno = inserirAlunoCasoDeUso.inserirAluno(new Aluno(alunoNome, Hash.gerarHash(sal, alunoSenha), cpf,
					sobrenome, notaCorte, dataNasc, genero, sal));
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aluno;
	}

	public Aluno atualizarAluno(Aluno aluno) {

		Aluno alunoAtualizado = new Aluno();

		AtualizarAlunoCasoDeUso atualizarAlunoCasoDeUso = new AtualizarAlunoCasoDeUso(alunoDAO);

		alunoAtualizado = atualizarAlunoCasoDeUso.atualizarAluno(aluno);

		return alunoAtualizado;
	}

//	public Aluno deletarAluno(Aluno aluno) {
//
//		Aluno alunoDeletado = new Aluno();
//
//		DeletarAlunoCasoDeUso deletarAlunoCasoDeUso = new DeletarAlunoCasoDeUso(alunoDAO);
//
//		alunoDeletado = deletarAlunoCasoDeUso.deletarAluno(aluno);
//
//		return alunoDeletado;
//	}

	public Avaliacao inserirAvalicao1(Aluno aluno, Curso curso) {

		int notaAvaliacao = 5;
		String comentario = "Adorei testar esse curso muito bom";

		Avaliacao avaliacao = new Avaliacao();

		InserirAvaliacaoCasoDeUso inserirAvaliacaoCasoDeUso = new InserirAvaliacaoCasoDeUso(avaliacaoDAO);

		inserirAvaliacaoCasoDeUso.inserirAvaliacao(new Avaliacao(notaAvaliacao, comentario, aluno, curso));

		return avaliacao;
	}

	public Avaliacao inserirAvaliacao2(Aluno aluno, Curso curso) {

		int notaAvaliacao = 4;
		String comentario = "Amei esse curso";

		Avaliacao avaliacao = new Avaliacao();

		InserirAvaliacaoCasoDeUso inserirAvaliacaoCasoDeUso = new InserirAvaliacaoCasoDeUso(avaliacaoDAO);

		avaliacao = inserirAvaliacaoCasoDeUso.inserirAvaliacao(new Avaliacao(notaAvaliacao, comentario, aluno, curso));

		return avaliacao;
	}

	public Avaliacao atualizarAvaliacao(Avaliacao avaliacao) {

		Avaliacao avaliacaoAtualizado = new Avaliacao();

		AtualizarAvaliacaoCasoDeUso atualizarAvaliacaoCasoDeUso = new AtualizarAvaliacaoCasoDeUso(avaliacaoDAO);

		avaliacaoAtualizado = atualizarAvaliacaoCasoDeUso.atualizarAvaliacao(avaliacao);

		return avaliacaoAtualizado;
	}

	public Avaliacao deletarAvaliacao(Avaliacao avaliacao) {

		Avaliacao avaliacaoDeletado = new Avaliacao();

		DeletarAvaliacaoCasoDeUso deletarAvaliacaoCasoDeUso = new DeletarAvaliacaoCasoDeUso(avaliacaoDAO);

		avaliacaoDeletado = deletarAvaliacaoCasoDeUso.deletarAvaliacao(avaliacao);

		return avaliacaoDeletado;
	}

}
