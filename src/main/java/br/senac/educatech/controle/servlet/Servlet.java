package br.senac.educatech.controle.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.educatech.modelo.dao.aluno.AlunoDAO;
import br.senac.educatech.modelo.dao.aluno.AlunoDAOImpl;
import br.senac.educatech.modelo.dao.area.AreaDAO;
import br.senac.educatech.modelo.dao.area.AreaDAOImpl;
import br.senac.educatech.modelo.dao.avaliacao.AvaliacaoDAO;
import br.senac.educatech.modelo.dao.avaliacao.AvaliacaoDAOImpl;
import br.senac.educatech.modelo.dao.contato.ContatoDAO;
import br.senac.educatech.modelo.dao.contato.ContatoDAOImpl;
import br.senac.educatech.modelo.dao.curso.CursoDAO;
import br.senac.educatech.modelo.dao.curso.CursoDAOImpl;
import br.senac.educatech.modelo.dao.endereco.EnderecoDAO;
import br.senac.educatech.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.educatech.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.educatech.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.educatech.modelo.dao.usuario.UsuarioDAO;
import br.senac.educatech.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.educatech.modelo.entidade.aluno.Aluno;
import br.senac.educatech.modelo.entidade.area.Area;
import br.senac.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.senac.educatech.modelo.entidade.contato.Contato;
import br.senac.educatech.modelo.entidade.instituicao.Instituicao;
import br.senac.educatech.modelo.entidade.usuario.Usuario;
import br.senac.educatech.modelo.enumeracao.genero.Genero;
import br.senac.educatech.modelo.enumeracao.modalidade.Modalidade;
import br.senac.educatech.modelo.enumeracao.turno.Turno;
import br.senac.educatech.util.hash.Hash;

@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AlunoDAO alunoDAO;
	private AreaDAO areaDAO;
	private AvaliacaoDAO avaliacaoDAO;
	private ContatoDAO contatoDAO;
	private CursoDAO cursoDAO;
	private EnderecoDAO enderecoDAO;
	private InstituicaoDAO instituicaoDAO;
	private UsuarioDAO usuarioDAO;

	public void init() {
		alunoDAO = new AlunoDAOImpl();
		areaDAO = new AreaDAOImpl();
		avaliacaoDAO = new AvaliacaoDAOImpl();
		contatoDAO = new ContatoDAOImpl();
		cursoDAO = new CursoDAOImpl();
		enderecoDAO = new EnderecoDAOImpl();
		instituicaoDAO = new InstituicaoDAOImpl();
		usuarioDAO = new UsuarioDAOImpl();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);

		try {

			switch (action) {
			case "/novo-aluno":
				mostrarFormularioNovoAluno(request, response);
				break;

			case "/editar-aluno":
				preencherFormularioAluno(request, response);
				break;

			case "/inserir-aluno":
				inserirAluno(request, response);
				break;

			case "/atualizarAluno":
				atualizarAluno(request, response);
				break;

			case "/deletarAluno":
				deletarAluno(request, response);
				break;

			case "/novaArea":
				mostrarFormularioArea(request, response);
				break;

			case "/editarArea":
				preencherFormularioArea(request, response);
				break;

			case "/inserirArea":
				inserirArea(request, response);
				break;

			case "/atualizarArea":
				atualizarArea(request, response);
				break;

			case "/deletarArea":
				deletarArea(request, response);
				break;

			case "/novaAvaliacao":
				mostrarFormularioAvaliacao(request, response);
				break;

			case "/editarAvaliacao":
				preencherFormularioAvaliacao(request, response);
				break;

			case "/inserirAvalaicao":
				inserirAvaliacao(request, response);
				break;

			case "/atualizarAvaliacao":
				atualizarAvaliacao(request, response);
				break;

			case "/deletarAvaliacao":
				deletarAvaliacao(request, response);
				break;

			case "/novoContato":
				mostrarFormularioNovoContato(request, response);
				break;

			case "/editarContato":
				preencherFormularioContato(request, response);
				break;

			case "/inserirContato":
				inserirContato(request, response);
				break;

			case "/atualizarContato":
				atualizarContato(request, response);
				break;

			case "/deletarContato":
				deletarContato(request, response);
				break;

			case "/novoCurso":
				mostrarFormularioCurso(request, response);
				break;

			case "/editarCurso":
				preencherFormularioCurso(request, response);
				break;

			case "/inserirCurso":
				inserirCurso(request, response);
				break;

			case "/atualizarCurso":
				atualizarCurso(request, response);
				break;

			case "/deletarCurso":
				deletarCurso(request, response);
				break;

			case "/novoEndereco":
				mostrarFormularioEndereco(request, response);
				break;

			case "/editarEndereco":
				preencherFormularioEndereco(request, response);
				break;

			case "/inserirEndereco":
				inserirEndereco(request, response);
				break;

			case "/atualizarEndereco":
				atualizarEndereco(request, response);
				break;

			case "/deletarEndereco":
				deletarEndereco(request, response);
				break;

			case "/novaInstituicao":
				mostrarFormularioNovaInstituicao(request, response);
				break;

			case "/editarInstituicao":
				preencherFormularioInstituicao(request, response);
				break;

			case "/inserirInstituicao":
				inserirInstituicao(request, response);
				break;

			case "/atualizarInstituicao":
				atualizarInstituicao(request, response);
				break;

			case "/deletarInstituicao":
				deletarInstituicao(request, response);
				break;

			case "/login":
				loginUsuario(request, response);
				break;

			case "/inserirUsuario":
				inseririUsuario(request, response);
				break;

			case "/atualizarUsuario":
				atualizarUsuario(request, response);
				break;

			case "/deletarUsuario":
				deletarUsuario(request, response);
				break;

			default:
				padrao(request, response);
				break;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void padrao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarFormularioNovoAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-aluno.jsp");
		dispatcher.forward(request, response);
	}

	private void preencherFormularioAluno(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		Aluno aluno = alunoDAO.recuperarAlunoPeloId(new Aluno(id));
		request.setAttribute("aluno", aluno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);

	}

	private void inserirAluno(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, InvalidKeySpecException, NoSuchAlgorithmException {

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cpf = request.getParameter("cpf");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNasc = LocalDate.parse(request.getParameter("nascimento"));
		double nota = Double.parseDouble(request.getParameter("notaCorte"));
		Genero genero = Genero.values()[Integer.parseInt(request.getParameter("genero"))];
		byte[] sal = Hash.gerarSal();
		//alunoDAO.inserirAluno(new Aluno(nome, Hash.gerarHash(sal, senha), cpf, sobrenome, nota, dataNasc, genero, sal));
		// redirect or response
	}

	private void atualizarAluno(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, InvalidKeySpecException, NoSuchAlgorithmException {
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cpf = request.getParameter("cpf");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNasc = LocalDate.parse(request.getParameter("nascimento"));
		double nota = Double.parseDouble(request.getParameter("notaCorte"));
		Genero genero = Genero.values()[Integer.parseInt(request.getParameter("genero"))];
		byte[] sal = Hash.gerarSal();
		//alunoDAO.atualizarAluno(
		//		new Aluno(id, nome, Hash.gerarHash(sal, senha), sal, cpf, sobrenome, nota, dataNasc, genero));
		// redirect or reponse
	}

	private void deletarAluno(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		Aluno aluno = alunoDAO.recuperarAlunoPeloId(new Aluno(id));
		// remover cursos favoritados, contato e endereco
		alunoDAO.deletarAluno(aluno);
		// redirect or response
	}

	private void mostrarFormularioArea(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void preencherFormularioArea(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Area area = areaDAO.recuperarAreaPeloId(new Area(id));
		request.setAttribute("area", area);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void inserirArea(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String nome = request.getParameter("nome");
		areaDAO.inserirArea(new Area(nome));
		// redirect or response
	}

	private void atualizarArea(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong("id");
		String nome = request.getParameter("nome");
		areaDAO.atualizarArea(new Area(id, nome));

	}

	private void deletarArea(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong("id");
		// deletarCursos
		Area area = areaDAO.recuperarAreaPeloId(new Area(id));
		areaDAO.deletarArea(area);
		// redirect or response
	}

	private void mostrarFormularioAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void preencherFormularioAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Avaliacao avaliacao = avaliacaoDAO.recuperarAvaliacaoPeloId(new Avaliacao(id));
		request.setAttribute("avaliacao", avaliacao);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void inserirAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int nota = Integer.parseInt(request.getParameter("nota"));
		String comentario = request.getParameter("comentario");
		long idAluno = Long.parseLong(request.getParameter("idAluno"));
		long idCurso = Long.parseLong(request.getParameter("idCurso"));
		//avaliacaoDAO.inserirAvaliacao(new Avaliacao(nota, comentario, new Aluno(idAluno), new Curso(idCurso)));
		// redirect or response
	}

	private void atualizarAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		int nota = Integer.parseInt(request.getParameter("nota"));
		String comentario = request.getParameter("comentario");
		long idAluno = Long.parseLong(request.getParameter("idAluno"));
		long idCurso = Long.parseLong(request.getParameter("idCurso"));
		//avaliacaoDAO.atualizarAvaliacao(new Avaliacao(id, nota, comentario, new Aluno(idAluno), new Curso(idCurso)));
		// redirect or response
	}

	private void deletarAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		Avaliacao avaliacao = avaliacaoDAO.recuperarAvaliacaoPeloId(new Avaliacao(id));
		avaliacaoDAO.deletarAvaliacao(avaliacao);
		// redirect or response
	}

	private void mostrarFormularioNovoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void preencherFormularioContato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		Contato contato = contatoDAO.recuperarContatoPeloId(new Contato(id));
		request.setAttribute("contato", contato);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void inserirContato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");
	//	contatoDAO.inserirContato(new Contato(telefone, celular, email));
		// redirect or response
	}

	private void atualizarContato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");

	//	contatoDAO.atualizarContato(new Contato(id, telefone, celular, email));
		// redirect or dispatch

	}

	private void deletarContato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
	//	Contato contato = contatoDAO.recuperarContatoPorId(new Contato(id));
	//	contatoDAO.deletarContato(contato);
		// redirect or dispatch
	}

	private void mostrarFormularioCurso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void preencherFormularioCurso(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		//Curso curso = cursoDAO.recuperarCursoPorId(new Curso(id));
		//request.setAttribute("curso", curso);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void inserirCurso(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");
		int duracao = Integer.parseInt(request.getParameter("duracao"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		String link = request.getParameter("link");
		double notaCorte = Double.parseDouble(request.getParameter("notaCorte"));
		Modalidade modalidade = Modalidade.values()[Integer.parseInt(request.getParameter("modalidade"))];
		Turno turno = Turno.values()[Integer.parseInt(request.getParameter("turno"))];
		long idArea = Long.parseLong(request.getParameter("idArea"));
		long idInstituicao = Long.parseLong(request.getParameter("idInstituicao"));
		//cursoDAO.inserirCurso(new Curso(nome, desc, duracao, preco, link, notaCorte, TipoMetodoEntrada.VESTIBULAR,
		//		modalidade, turno, new Area(idArea), new Instituicao(idInstituicao)));
		// redirect or response
	}

	private void atualizarCurso(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");
		int duracao = Integer.parseInt(request.getParameter("duracao"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		String link = request.getParameter("link");
		double notaCorte = Double.parseDouble(request.getParameter("notaCorte"));
		Modalidade modalidade = Modalidade.values()[Integer.parseInt(request.getParameter("modalidade"))];
		Turno turno = Turno.values()[Integer.parseInt(request.getParameter("turno"))];
		long idArea = Long.parseLong(request.getParameter("idArea"));
		long idInstituicao = Long.parseLong(request.getParameter("idInstituicao"));
	//	cursoDAO.atualizarCurso(new Curso(id, nome, desc, duracao, preco, link, notaCorte, MetodoEntrada.VESTIBULAR,
		//		modalidade, turno, new Area(idArea), new Instituicao(idInstituicao)));
		// redirect or response
	}

	private void deletarCurso(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		// desfavoritar curso
		//Curso curso = cursoDAO.recuperarCursoPorId(new Curso(id));
	//	cursoDAO.deletarCurso(curso);
		// redirect or response

	}

	private void mostrarFormularioEndereco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void preencherFormularioEndereco(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
	//	Endereco endereco = enderecoDAO.recuperarEnderecoPorId(new Endereco(id));
	//	request.setAttribute("endereco", endereco);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);

	}

	private void inserirEndereco(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String logradouro = request.getParameter("logradouro");
		String bairro = request.getParameter("bairro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String referencia = request.getParameter("referencia");
		long idInstituicao = Long.parseLong(request.getParameter("id"));

		//enderecoDAO.inserirEndereco(new Endereco(logradouro, bairro, numero, cep, cidade, estado, referencia,
		//		new Instituicao(idInstituicao)));
		// redirect or response

	}

	private void atualizarEndereco(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String logradouro = request.getParameter("logradouro");
		String bairro = request.getParameter("bairro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String referencia = request.getParameter("referencia");
		long id = Long.parseLong(request.getParameter("id"));
	//	enderecoDAO.atualizarEndereco(
	//			new Endereco(id, logradouro, bairro, numero, cep, cidade, estado, referencia, new Instituicao(id)));
		// redirect or response

	}

	private void deletarEndereco(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		//Endereco endereco = enderecoDAO.recuperarEnderecoPorId(new Endereco(id));
	//	enderecoDAO.deletarEndereco(endereco);
		// redirect or response
	}

	private void mostrarFormularioNovaInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void preencherFormularioInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPeloId(new Instituicao(id));
		request.setAttribute("instituicao", instituicao);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void inserirInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, InvalidKeySpecException, NoSuchAlgorithmException {

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cnpj = request.getParameter("cnpj");
		String desc = request.getParameter("desc");
		byte[] sal = Hash.gerarSal();
		//instituicaoDAO.inserirInstituicao(new Instituicao(nome, Hash.gerarHash(sal, senha), cnpj, desc, sal));
		// redirect or response
	}

	private void atualizarInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, InvalidKeySpecException, NoSuchAlgorithmException {
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cnpj = request.getParameter("cnpj");
		String desc = request.getParameter("desc");
		byte[] sal = Hash.gerarSal();
		//instituicaoDAO.atualizarInstituicao(new Instituicao(id, nome, Hash.gerarHash(sal, senha), sal, cnpj, desc));
		// redirect or response
	}

	private void deletarInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPeloId(new Instituicao(id));
		// desfavoritar e remover cursos, endereco, area
		instituicaoDAO.deletarInstituicao(instituicao);
		// redirect or response
	}

	private void loginUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException{

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		try {

			Usuario usuario = null;
			
		//	Usuario usuario = usuarioDAO.recuperarUsuarioId(new Contato());

			if (usuario == null) {
				//throw new UsuarioInvalidoException("O email informado não existe!");
			}
			//Aluno aluno = alunoDAO.recuperarAlunoPeloId(usuario);
			Aluno aluno = null;
			Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPeloId(usuario);

			if (aluno != null) {
				boolean equals = usuario.equals(Hash.gerarHash(aluno.getSal(), senha) == (aluno.getSenha()));

				if (equals == true) {
					// conexao(aluno);
				} else {
				//	throw new SenhaInvalidaException("A senha informada está incorreta!");

				}
			} else if (instituicao != null) {
				boolean equals = usuario.equals(Hash.gerarHash(instituicao.getSal(), senha) == instituicao.getSenha());

				if (equals == true) {
					// conexao(instituicao);
				} else {
				//	throw new SenhaInvalidaException("A senha informada está incorreta!");

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void inseririUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, InvalidKeySpecException, NoSuchAlgorithmException {
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		byte[] sal = Hash.gerarSal();
	//	usuarioDAO.inserirUsuario(new Usuario(nome, Hash.gerarHash(sal, senha), sal));
		// redirect or response
	}

	private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, InvalidKeySpecException, NoSuchAlgorithmException {
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		byte[] sal = Hash.gerarSal();
	//	usuarioDAO.atualizarUsuario(new Usuario(id, nome, Hash.gerarHash(sal, senha), sal));

	}

	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		Usuario usuario = usuarioDAO.recuperarUsuarioPeloId(new Usuario(id));
		// nao sei pq tem esse metodo
		usuarioDAO.deletarUsuario(usuario);

	}

}
