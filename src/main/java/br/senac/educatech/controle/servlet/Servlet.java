package br.senac.educatech.controle.servlet;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

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
import br.senac.educatech.modelo.dao.foto.FotoDAO;
import br.senac.educatech.modelo.dao.foto.FotoDAOImpl;
import br.senac.educatech.modelo.dao.instituicao.InstituicaoDAO;
import br.senac.educatech.modelo.dao.instituicao.InstituicaoDAOImpl;
import br.senac.educatech.modelo.dao.usuario.UsuarioDAO;
import br.senac.educatech.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.educatech.modelo.entidade.aluno.Aluno;
import br.senac.educatech.modelo.entidade.area.Area;
import br.senac.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.senac.educatech.modelo.entidade.contato.Contato;
import br.senac.educatech.modelo.entidade.curso.Curso;
import br.senac.educatech.modelo.entidade.endereco.Endereco;
import br.senac.educatech.modelo.entidade.foto.Foto;
import br.senac.educatech.modelo.entidade.instituicao.Instituicao;
import br.senac.educatech.modelo.entidade.usuario.Usuario;
import br.senac.educatech.modelo.enumeracao.genero.Genero;
import br.senac.educatech.modelo.enumeracao.modalidade.Modalidade;
import br.senac.educatech.modelo.enumeracao.pronome.Pronome;
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
	private FotoDAO fotoDAO;

	public void init() {
		alunoDAO = new AlunoDAOImpl();
		areaDAO = new AreaDAOImpl();
		avaliacaoDAO = new AvaliacaoDAOImpl();
		contatoDAO = new ContatoDAOImpl();
		cursoDAO = new CursoDAOImpl();
		enderecoDAO = new EnderecoDAOImpl();
		instituicaoDAO = new InstituicaoDAOImpl();
		usuarioDAO = new UsuarioDAOImpl();
		fotoDAO = new FotoDAOImpl();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		HttpSession sessao = request.getSession();

		try {

			switch (action) {
			case "/novo-aluno":
				mostrarFormularioNovoAluno(request, response, sessao);
				break;

			case "/editar-aluno":
				preencherFormularioAluno(request, response, sessao);
				break;

			case "/inserir-aluno":
				inserirAluno(request, response, sessao);
				break;

			case "/atualizar-aluno":
				atualizarAluno(request, response, sessao);
				break;

			case "/deletar-aluno":
				deletarAluno(request, response, sessao);
				break;

			case "/nova-area":
				mostrarFormularioArea(request, response, sessao);
				break;

			case "/editar-area":
				preencherFormularioArea(request, response, sessao);
				break;

			case "/inserir-area":
				inserirArea(request, response, sessao);
				break;

			case "/atualizar-area":
				atualizarArea(request, response, sessao);
				break;

			case "/deletar-area":
				deletarArea(request, response, sessao);
				break;

			case "/nova-avaliacao":
				mostrarFormularioAvaliacao(request, response, sessao);
				break;

			case "/editar-avaliacao":
				preencherFormularioAvaliacao(request, response, sessao);
				break;

			case "/inserir-avaliacao":
				inserirAvaliacao(request, response, sessao);
				break;

			case "/atualizar-avaliacao":
				atualizarAvaliacao(request, response, sessao);
				break;

			case "/deletar-avaliacao":
				deletarAvaliacao(request, response, sessao);
				break;

			case "/novo-contato":
				mostrarFormularioNovoContato(request, response, sessao);
				break;

			case "/editar-contato":
				preencherFormularioContato(request, response, sessao);
				break;

			case "/inserir-contato":
				inserirContato(request, response, sessao);
				break;

			case "/atualizar-contato":
				atualizarContato(request, response, sessao);
				break;

			case "/deletar-contato":
				deletarContato(request, response, sessao);
				break;

			case "/novo-curso":
				mostrarFormularioCurso(request, response, sessao);
				break;

			case "/editar-curso":
				preencherFormularioCurso(request, response, sessao);
				break;

			case "/inserir-curso":
				inserirCurso(request, response, sessao);
				break;

			case "/atualizar-curso":
				atualizarCurso(request, response, sessao);
				break;

			case "/deletar-curso":
				deletarCurso(request, response, sessao);
				break;

			case "/novo-endereco":
				mostrarFormularioEndereco(request, response, sessao);
				break;

			case "/editar-endereco":
				preencherFormularioEndereco(request, response, sessao);
				break;

			case "/inserir-endereco":
				inserirEndereco(request, response, sessao);
				break;

			case "/atualizar-endereco":
				atualizarEndereco(request, response, sessao);
				break;

			case "/deletar-endereco":
				deletarEndereco(request, response, sessao);
				break;

			case "/nova-instituicao":
				mostrarFormularioNovaInstituicao(request, response, sessao);
				break;

			case "/editar-instituicao":
				preencherFormularioInstituicao(request, response, sessao);
				break;

			case "/inserir-instituicao":
				inserirInstituicao(request, response, sessao);
				break;

			case "/atualizar-instituicao":
				atualizarInstituicao(request, response, sessao);
				break;

			case "/deletar-instituicao":
				deletarInstituicao(request, response, sessao);
				break;

			case "/login":
				mostrarFormularioLogin(request, response, sessao);
				break;

			case "/efetuar-login":
				loginUsuario(request, response, sessao);
				break;

			case "/inserir-usuario":
				inseririUsuario(request, response, sessao);
				break;

			case "/atualizar-usuario":
				atualizarUsuario(request, response, sessao);
				break;

			case "/deletar-usuario":
				deletarUsuario(request, response, sessao);
				break;

			case "/consulta-principal":
				mostrarFormularioConsultaCurso(request, response, sessao);
				break;

			case "/consultar-curso":
				consultarCurso(request, response, sessao);
				break;

			case "/meus-cursos":
				cursosInstituicao(request, response, sessao);
				break;

			case "/pagina-curso":
				mostrarPaginaCurso(request, response, sessao);
				break;

			default:
				padrao(request, response, sessao);
				break;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void padrao(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarFormularioNovoAluno(HttpServletRequest request, HttpServletResponse response,
			HttpSession sessao) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-aluno.jsp");

		dispatcher.forward(request, response);
	}

	private void preencherFormularioAluno(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Aluno aluno = alunoDAO.recuperarAlunoPeloId(new Aluno(usuario.getId()));
		request.setAttribute("aluno", aluno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editar-perfil-aluno.jsp");
		dispatcher.forward(request, response);

	}

	private void inserirAluno(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException, InvalidKeySpecException, NoSuchAlgorithmException {

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("data-nascimento"));
		// double nota = Double.parseDouble(request.getParameter("nota"));
		String biografia = request.getParameter("biografia");
		Genero genero = Genero.values()[Integer.parseInt(request.getParameter("genero"))];
		Pronome pronome = Pronome.values()[Integer.parseInt(request.getParameter("pronome"))];
		byte[] sal = Hash.gerarSal();

		Aluno aluno = new Aluno(nome, Hash.gerarHash(sal, senha), sal, cpf, sobrenome, biografia, dataNascimento,
				genero, pronome, null);

		Contato contato = new Contato(telefone, celular, email, aluno);

		alunoDAO.inserirAluno(aluno);

		contatoDAO.inserirContato(contato);

		byte[] conteudoFoto = FileUtils.readFileToByteArray(new File(request.getParameter("foto-perfil")));
		String extensaoFoto = FilenameUtils.getExtension(request.getParameter("foto-perfil"));
		Foto foto = new Foto(conteudoFoto, extensaoFoto, aluno);

		aluno.setFoto(foto);

		alunoDAO.atualizarAluno(aluno);

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	private void atualizarAluno(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException, InvalidKeySpecException, NoSuchAlgorithmException {
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cpf = request.getParameter("cpf");
		String sobrenome = request.getParameter("sobrenome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("nascimento"));
		double nota = Double.parseDouble(request.getParameter("notaCorte"));
		Genero genero = Genero.values()[Integer.parseInt(request.getParameter("genero"))];
		byte[] sal = Hash.gerarSal();
		String biografia = request.getParameter("biografia");
		Pronome pronome = Pronome.values()[Integer.parseInt(request.getParameter("pronome"))];

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		Aluno aluno = new Aluno(usuario.getId(), nome, Hash.gerarHash(sal, senha), sal, cpf, sobrenome, biografia,
				dataNascimento, genero, pronome, null);

		alunoDAO.atualizarAluno(aluno);

		byte[] conteudoFoto = FileUtils.readFileToByteArray(new File(request.getParameter("foto-perfil")));
		String extensaoFoto = FilenameUtils.getExtension(request.getParameter("foto-perfil"));
		Foto foto = new Foto(conteudoFoto, extensaoFoto, aluno);

		aluno.setFoto(foto);

		fotoDAO.atualizarFoto(foto);

		alunoDAO.atualizarAluno(aluno);

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarAluno(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		Aluno aluno = alunoDAO.recuperarAlunoPeloId(new Aluno(id));
		// remover cursos favoritados, contato e endereco
		alunoDAO.deletarAluno(aluno);
		// redirect or response
	}

	private void mostrarFormularioArea(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-area.jsp");
		dispatcher.forward(request, response);
	}

	private void preencherFormularioArea(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Area area = areaDAO.recuperarAreaPeloId(new Area(id));
		request.setAttribute("area", area);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void inserirArea(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {

		String nome = request.getParameter("nome");
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPeloId(new Instituicao(usuario.getId()));
		Area area = new Area(nome, instituicao);
		areaDAO.inserirArea(area);

		List<Area> areas = areaDAO.recuperarAreasPelaInstituicao(instituicao);

		request.setAttribute("areas", areas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-curso.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarArea(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong("id");
		String nome = request.getParameter("nome");
		// areaDAO.atualizarArea(new Area(id, nome));

	}

	private void deletarArea(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong("id");
		// deletarCursos
		Area area = areaDAO.recuperarAreaPeloId(new Area(id));
		areaDAO.deletarArea(area);
		// redirect or response
	}

	private void mostrarFormularioAvaliacao(HttpServletRequest request, HttpServletResponse response,
			HttpSession sessao) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void preencherFormularioAvaliacao(HttpServletRequest request, HttpServletResponse response,
			HttpSession sessao) throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Avaliacao avaliacao = avaliacaoDAO.recuperarAvaliacaoPeloId(new Avaliacao(id));
		request.setAttribute("avaliacao", avaliacao);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void inserirAvaliacao(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {

		int nota = Integer.parseInt(request.getParameter("nota"));
		String comentario = request.getParameter("comentario");
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Aluno aluno = alunoDAO.recuperarAlunoPeloId(new Aluno(usuario.getId()));
		// long idCurso = Long.parseLong(request.getParameter("id"));
		// Aluno aluno = alunoDAO.recuperarAlunoPeloId(new Aluno(2L));
		Curso curso = cursoDAO.recuperarCursoPeloId(new Curso(1L));
		LocalDate dataComentario = LocalDate.now();
		Avaliacao avaliacao = new Avaliacao(nota, comentario, aluno, curso, dataComentario);
		avaliacaoDAO.inserirAvaliacao(avaliacao);
		curso.adicionarAvaliacao(avaliacao);
		aluno.adicionarAvaliacao(avaliacao);
		alunoDAO.atualizarAluno(aluno);
		cursoDAO.atualizarCurso(curso);

		RequestDispatcher dispatcher = request.getRequestDispatcher("pagina-curso.jsp");
		dispatcher.forward(request, response);
	}

	private void atualizarAvaliacao(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {
		// long id = Long.parseLong(request.getParameter("id"));
		int nota = Integer.parseInt(request.getParameter("nota"));
		String comentario = request.getParameter("comentario");
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Aluno aluno = alunoDAO.recuperarAlunoPeloId(new Aluno(usuario.getId()));
		Curso curso = cursoDAO.recuperarCursoPeloId(new Curso(1L));
		LocalDate dataComentario = LocalDate.now();
		avaliacaoDAO.atualizarAvaliacao(new Avaliacao(1L, nota, comentario, aluno, curso, dataComentario));
		RequestDispatcher dispatcher = request.getRequestDispatcher("pagina-curso.jsp");
		dispatcher.forward(request, response);
	}

	private void deletarAvaliacao(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {

		// long id = Long.parseLong(request.getParameter("id"));
		Avaliacao avaliacao = avaliacaoDAO.recuperarAvaliacaoPeloId(new Avaliacao(1L));
		avaliacaoDAO.deletarAvaliacao(avaliacao);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pagina-curso.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarFormularioNovoContato(HttpServletRequest request, HttpServletResponse response,
			HttpSession sessao) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void preencherFormularioContato(HttpServletRequest request, HttpServletResponse response,
			HttpSession sessao) throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		Contato contato = contatoDAO.recuperarContatoPeloId(new Contato(id));
		request.setAttribute("contato", contato);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void inserirContato(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {

		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");
		// contatoDAO.inserirContato(new Contato(telefone, celular, email));
		// redirect or response
	}

	private void atualizarContato(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");

		// contatoDAO.atualizarContato(new Contato(id, telefone, celular, email));
		// redirect or dispatch

	}

	private void deletarContato(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		// Contato contato = contatoDAO.recuperarContatoPorId(new Contato(id));
		// contatoDAO.deletarContato(contato);
		// redirect or dispatch
	}

	private void mostrarFormularioCurso(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPeloId(new Instituicao(usuario.getId()));
		List<Area> areas = areaDAO.recuperarAreasPelaInstituicao(instituicao);
		request.setAttribute("areas", areas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-curso.jsp");
		dispatcher.forward(request, response);

	}

	private void preencherFormularioCurso(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		// Curso curso = cursoDAO.recuperarCursoPorId(new Curso(id));
		// request.setAttribute("curso", curso);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void inserirCurso(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {

		String nome = request.getParameter("curso");
		String descricao = request.getParameter("descricao");
		double duracao = Double.parseDouble(request.getParameter("duracao"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		String link = request.getParameter("link");
		// double notaCorte = Double.parseDouble(request.getParameter("notaCorte"));
		Modalidade modalidade = Modalidade.values()[Integer.parseInt(request.getParameter("modalidade"))];
		Turno turno = Turno.values()[Integer.parseInt(request.getParameter("turno"))];
		long idArea = Long.parseLong(request.getParameter("area"));

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPeloId(new Instituicao(usuario.getId()));

		cursoDAO.inserirCurso(
				new Curso(nome, descricao, duracao, preco, link, modalidade, turno, new Area(idArea), instituicao));

	}

	private void atualizarCurso(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
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
		// cursoDAO.atualizarCurso(new Curso(id, nome, desc, duracao, preco, link,
		// notaCorte, MetodoEntrada.VESTIBULAR,
		// modalidade, turno, new Area(idArea), new Instituicao(idInstituicao)));
		// redirect or response
	}

	private void mostrarPaginaCurso(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws ServletException, IOException {

		// Long id = Long.parseLong(request.getParameter("id"));
		Curso curso = cursoDAO.recuperarCursoComAvaliacoesPeloId(new Curso(1L));
		request.setAttribute("curso", curso);

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Aluno aluno = alunoDAO.recuperarAlunoPeloId(new Aluno(usuario.getId()));
		request.setAttribute("aluno", aluno);

		RequestDispatcher dispatcher = request.getRequestDispatcher("pagina-curso.jsp");
		dispatcher.forward(request, response);
	}

	private void deletarCurso(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		// desfavoritar curso
		// Curso curso = cursoDAO.recuperarCursoPorId(new Curso(id));
		// cursoDAO.deletarCurso(curso);
		// redirect or response

	}

	private void mostrarFormularioConsultaCurso(HttpServletRequest request, HttpServletResponse response,
			HttpSession sessao) throws ServletException, IOException {

		double precoMinimo = cursoDAO.recuperaMenorPrecoCurso();
		double precoMaximo = cursoDAO.recuperarMaiorPrecoCurso();

		List<Area> areas = areaDAO.recuperarAreas();
		List<Instituicao> instituicoes = instituicaoDAO.recuperarInstituicoes();
		List<Curso> cursos = null;

		request.setAttribute("precoMinimo", precoMinimo);
		request.setAttribute("precoMaximo", precoMaximo);
		request.setAttribute("areas", areas);
		request.setAttribute("instituicoes", instituicoes);
		request.setAttribute("cursos", cursos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("consultar-curso.jsp");
		dispatcher.forward(request, response);

	}

	private void consultarCurso(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws ServletException, IOException {

		Optional<Modalidade> modalidade = Optional
				.of(Modalidade.values()[Integer.parseInt(request.getParameter("modalidade"))]);
		Optional<Double> notaCorte = Optional.of(Double.parseDouble(request.getParameter("notaCorte")));
		Optional<Turno> turno = Optional.of(Turno.values()[Integer.parseInt(request.getParameter("turno"))]);
		Optional<Double> duracao = Optional.of(Double.parseDouble(request.getParameter("duracao")));
		Optional<Long> area = Optional.of(Long.parseLong(request.getParameter("area")));
		Optional<Long> instituicao = Optional.of(Long.parseLong(request.getParameter("instituicao")));
		Optional<Double> preco = Optional.of(Double.parseDouble(request.getParameter("preco")));
		List<Curso> cursos = cursoDAO.recuperarCursoPorFiltro(instituicao, area, notaCorte, turno, modalidade, preco,
				duracao);

		double precoMinimo = cursoDAO.recuperaMenorPrecoCurso();
		double precoMaximo = cursoDAO.recuperarMaiorPrecoCurso();
		List<Instituicao> instituicoes = instituicaoDAO.recuperarInstituicoes();
		List<Area> areas = areaDAO.recuperarAreas();

		request.setAttribute("precoMinimo", precoMinimo);
		request.setAttribute("precoMaximo", precoMaximo);
		request.setAttribute("instituicoes", instituicoes);
		request.setAttribute("areas", areas);
		request.setAttribute("cursos", cursos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("consultar-curso.jsp");
		dispatcher.forward(request, response);

	}

	private void cursosInstituicao(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws ServletException, IOException {

		Instituicao instituicao = (Instituicao) sessao.getAttribute("usuario");

		cursoDAO.recuperarCursosPelaInstituicao(instituicao);

		request.setAttribute("cursos", instituicao);

		RequestDispatcher dispatcher = request.getRequestDispatcher("meus-cursos.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarFormularioEndereco(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void preencherFormularioEndereco(HttpServletRequest request, HttpServletResponse response,
			HttpSession sessao) throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		// Endereco endereco = enderecoDAO.recuperarEnderecoPorId(new Endereco(id));
		// request.setAttribute("endereco", endereco);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);

	}

	private void inserirEndereco(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {

		String logradouro = request.getParameter("logradouro");
		String bairro = request.getParameter("bairro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String referencia = request.getParameter("referencia");
		long idInstituicao = Long.parseLong(request.getParameter("id"));

		// enderecoDAO.inserirEndereco(new Endereco(logradouro, bairro, numero, cep,
		// cidade, estado, referencia,
		// new Instituicao(idInstituicao)));
		// redirect or response

	}

	private void atualizarEndereco(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {

		String logradouro = request.getParameter("logradouro");
		String bairro = request.getParameter("bairro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String referencia = request.getParameter("referencia");
		long id = Long.parseLong(request.getParameter("id"));
		// enderecoDAO.atualizarEndereco(
		// new Endereco(id, logradouro, bairro, numero, cep, cidade, estado, referencia,
		// new Instituicao(id)));
		// redirect or response

	}

	private void deletarEndereco(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		// Endereco endereco = enderecoDAO.recuperarEnderecoPorId(new Endereco(id));
		// enderecoDAO.deletarEndereco(endereco);
		// redirect or response
	}

	private void mostrarFormularioNovaInstituicao(HttpServletRequest request, HttpServletResponse response,
			HttpSession sessao) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-instituicao.jsp");
		dispatcher.forward(request, response);
	}

	private void preencherFormularioInstituicao(HttpServletRequest request, HttpServletResponse response,
			HttpSession sessao) throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPeloId(new Instituicao(id));
		request.setAttribute("instituicao", instituicao);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void inserirInstituicao(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException, InvalidKeySpecException, NoSuchAlgorithmException {

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cnpj = request.getParameter("cnpj");
		String descricao = request.getParameter("descricao");

		byte[] sal = Hash.gerarSal();

		Instituicao instituicao = new Instituicao(nome, Hash.gerarHash(sal, senha), sal, cnpj, descricao, null);

		instituicaoDAO.inserirInstituicao(instituicao);

		String logradouro = request.getParameter("logradouro");
		String bairro = request.getParameter("bairro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String referencia = request.getParameter("referencia");
		String complemento = request.getParameter("complemento");

		Endereco endereco = new Endereco(logradouro, bairro, numero, cep, cidade, estado, referencia, complemento,
				instituicao);

		enderecoDAO.inserirEndereco(endereco);

		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");

		Contato contato = new Contato(telefone, celular, email, instituicao);

		contatoDAO.inserirContato(contato);

		byte[] conteudoFoto = FileUtils.readFileToByteArray(new File(request.getParameter("logo-instituicao")));
		String extensaoFoto = FilenameUtils.getExtension(request.getParameter("logo-instituicao"));
		Foto foto = new Foto(conteudoFoto, extensaoFoto, instituicao);

		fotoDAO.inserirFoto(foto);

		instituicao.setFoto(foto);

		instituicaoDAO.atualizarInstituicao(instituicao);

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	private void atualizarInstituicao(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException, InvalidKeySpecException, NoSuchAlgorithmException {
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cnpj = request.getParameter("cnpj");
		String desc = request.getParameter("desc");
		byte[] sal = Hash.gerarSal();
		// instituicaoDAO.atualizarInstituicao(new Instituicao(id, nome,
		// Hash.gerarHash(sal, senha), sal, cnpj, desc));
		// redirect or response
	}

	private void deletarInstituicao(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPeloId(new Instituicao(id));
		// desfavoritar e remover cursos, endereco, area
		instituicaoDAO.deletarInstituicao(instituicao);
		// redirect or response
	}

	private void mostrarFormularioLogin(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);

	}

	private void loginUsuario(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, ServletException, IOException, InvalidKeySpecException, NoSuchAlgorithmException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = usuarioDAO.recuperarUsuarioPorEmail(new Contato(email));

		if (usuario.getSenha().equals(Hash.gerarHash(usuario.getSal(), senha)))
			request.getSession().setAttribute("usuario", usuario);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

	private void inseririUsuario(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, IOException, ServletException, InvalidKeySpecException, NoSuchAlgorithmException {
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		byte[] sal = Hash.gerarSal();
		// usuarioDAO.inserirUsuario(new Usuario(nome, Hash.gerarHash(sal, senha),
		// sal));
		// redirect or response
	}

	private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response, HttpSession sessao)
			throws SQLException, IOException, ServletException, InvalidKeySpecException, NoSuchAlgorithmException {
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		byte[] sal = Hash.gerarSal();
		// usuarioDAO.atualizarUsuario(new Usuario(id, nome, Hash.gerarHash(sal, senha),
		// sal));

	}

	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response, HttpSession sessao) {
		Long id = Long.parseLong(request.getParameter("id"));
		Usuario usuario = usuarioDAO.recuperarUsuarioPeloId(new Usuario(id));
		// nao sei pq tem esse metodo
		usuarioDAO.deletarUsuario(usuario);

	}

}
