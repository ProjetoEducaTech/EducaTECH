package sistema;
import sistema.modelo.dao.contato.ContatoDAO;
import sistema.modelo.dao.contato.ContatoDAOImpl;
import sistema.modelo.dao.usuario.UsuarioDAO;
import sistema.modelo.dao.usuario.UsuarioDAOImpl;
import sistema.modelo.entidade.contato.Contato;
import sistema.modelo.entidade.usuario.Usuario;

public class Principal {

	public static void main(String[] args) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		ContatoDAO contatoDAO = new ContatoDAOImpl();
		
		String nome = "Teste";
		String senha = "12323";
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setSenha(senha);
		
		usuarioDAO.inserirUsuario(usuario);
		
		String telefone = "3332-3232";
		String celular = "5432-3232";
		String email = "teste@email.com.br";
		
		Contato contato = new Contato();
		
		contato.setTelefone(telefone);
		contato.setCelular(celular);
		contato.setEmail(email);

		contato.setUsuario(usuario);
		
		contatoDAO.inserirContato(contato);
		
		
		

	



		/*Scanner leitor = new Scanner(System.in);

		System.out.println("\n Seja bem vindo ao EducaTECH! \n");

		System.out.println("\n Para começar: você possui cadastro?");
		System.out.println("\n \n 1 - Sim");
		System.out.println("\n \n 2 - Não");
		int verificar_login = leitor.nextInt();
		

		switch (verificar_login) {
		case 1:
			
			tem_login();
			
			break;

		case 2:
			
			sem_login();
			
			break;

		default:
			
			System.out.println("Erro");
			
			break;
			
		}
		
		leitor.close();

	}


	public static void sistema(String msg, String usuario, String cpf, String senha) {

		Scanner leitor = new Scanner(System.in);

		System.out.println("\n \n Você efetuou o login com sucesso!");
		System.out.println("\n \n Seja bem vindo, " + usuario + ", ao EducaTECH, o sistema que irá o auxiliar no processo de integração ao ensino superior. \n");
		
		System.out.print("\n Escolha como deseja dar continuação ao sistema: \n \n");
		String[] opc = new String[] {""," Acessar opções da conta ", " Prosseguir para escolher meu curso"};
		
		for(int i = 1; i < 3; i++) {
			System.out.println(i + " - " + opc[i]);
		}
		
		int opc_principal = leitor.nextInt();
		
		switch(opc_principal) {
			case 1:
				info_conta(usuario, cpf);
			break;
		}

		System.out.print("Para prosseguir, insira sua nota de corte: ");
		float notaCorte = leitor.nextFloat();
		
		System.out.print("Escolha sua área de estudo desejada: \n");
		System.out.println("\n Áreas de Estudo: \n");

		String[] areas = new String[] {"", " Humanas", " Biologicas"," Exatas", " Listar todos os cursos"};
	
		
		for(int i = 1; i <= 4; i++) {
			System.out.println(i + " - " + areas[i]);
		}
		
		int area_select = leitor.nextInt();

		switch(area_select) {
		
		case 1:
			 lista_humanas();
		break;
		
		case 2:
			lista_biologicas();
			break;
			
		case 3:
			lista_exatas();
			break;
			
		case 4:
			lista_tudo();
			break;
			
		default:
			System.out.println("Erro");
		break;
	}
		leitor.close();
	}
	
	public static void sem_login() {

		System.out.print("Para acessar todos os benefícios de nosso sistema, efetue o cadastro. \n\n");

		fazerCadastro();
			
		}
	
	public static void fazerCadastro() {
		UsuarioDAO dao = (UsuarioDAO) new UsuarioDAOImpl();

		System.out.println("\nBem vindo ao cadastro!\n");

		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Crie um nome de usuario: ");
		String nome = leitor.next();

		System.out.print("Insira seu CPF: ");
		String cpf = leitor.next();

		System.out.print("Crie uma senha: ");
		String senha = leitor.next();
		
		dao.cadastrarUsuario(new Usuario(nome, cpf, senha ));
		System.out.println("Cliente salvo com sucesso.\n");
		System.out.print("Seus dados estão seguros conosco, pode confiar!");

		tem_login();
		leitor.close();

	}
	
	public static void tem_login() {

		Scanner leitor = new Scanner(System.in);

		System.out.println("\n LOGIN \n");
		
		System.out.print("\n Insira seu CPF: ");
		String cpf = leitor.next();

		System.out.print("\n Insira sua senha: ");
		String senha = leitor.next();
		
		System.out.print("\n Insira seu nome de usuário: ");
		String nome = leitor.next();

		sistema("Logado", nome, cpf, senha);
		
		leitor.close();
		
	} 
	
	public static void info_conta(String nome, String cpf) {
		
		UsuarioDAO dao = (UsuarioDAO) new UsuarioDAOImpl();
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("\n");
		
		System.out.print("\n O que você gostaria de acessar? \n\n");
		String[] opc = new String[] {""," Acessar meus dados ", " Atualizar nome de usuário" ,  " Atualizar CPF ", " Atualizar senha", " Deletar conta", " Favoritar Curso"," Acessar meus cursos favoritados "};
		
		for(int i = 1; i < 8; i++) {
			
			System.out.println(i + " - " + opc[i]);
			
		}
		
		int escolha_conta = leitor.nextInt();

		switch(escolha_conta) {
			case 1:
				
				infos_favorito(cpf);
				
			break;
			
			case 2:
				
				System.out.print("\n");
				
				System.out.print("Informe seu CPF: \n");
				cpf = leitor.next();
				
				System.out.print("Informe o novo nome de usuário: ");
				String novoNome = leitor.next();
				
				dao.atualizarNomeUsuario(cpf,  novoNome);	
				
			break;
			
			case 3:
				
				System.out.print("\n");
				
				System.out.print("Informe seu CPF atual: \n");
				cpf = leitor.next();
				
				System.out.print("Informe o novo CPF: ");
				String novoCpf = leitor.next();
				
				dao.atualizarCpfUsuario(cpf, novoCpf);

			break;
			
			case 4:
				
				System.out.print("\n");
				
				System.out.print("Informe seu CPF: \n");
				 cpf = leitor.next();
				 
				System.out.print("Informe a nova senha: ");
				String novaSenha = leitor.next();
				
				dao.atualizarSenhaUsuario(cpf, novaSenha );
				
				break;
			
			case 5:
				
				System.out.print("\n");
				
			    System.out.print("Insira seu cpf: ");
			    String senha = leitor.next();
			
			    dao.deletarConta(senha);
			    
			    break;
			
			case 6:
				
				System.out.print("Informe seu CPF atual: ");
				String cpfUsuario = leitor.next();
				
				System.out.print("Informe o ID do curso: ");
				int idCurso = leitor.nextInt();
				
				dao.favoritarCurso( cpfUsuario, idCurso);
				
				break;
			    
			case 7:
				
				System.out.print("Informe seu CPF atual: ");
				cpf = leitor.next();
				
				List<Curso> CursosFavoritos = null;
				CursosFavoritos =  dao.listaCursosFavoritos(cpf);
		
				listarCursos(CursosFavoritos);
			
				break;
				
			default: 
		
				System.out.print("Opção inválida.");
				
				break;
		
		}
		leitor.close();
	}
	
	private static void listarCursos(List<Curso> cursosFavoritos) {
		
		System.out.println(cursosFavoritos);
		
	}


	public static void infos_favorito(String id) {
		
		System.out.println("\n Seus cursos favoritados são: \n");
		String[] favoritos = new String[] {"Ánalise e Desenvolvimento de Sistema - IFSC", "Informática - IFC"};
		
		for(int i = 0; i < favoritos.length;i++) {
			
			System.out.println(favoritos[i]);
			
		}
		
		System.out.println("\n");

	}

	public static void lista_humanas() {

		System.out.println("\n Você selecionou a área de humanas!");

	}

	public static void lista_biologicas() {
		
		System.out.println("\n Você selecionou a área de biológicas! ");
	}

	public static void lista_exatas() {
		
		System.out.println("\n Você selecionou a área de exatas! ");
	}

	public static void lista_tudo() {
		
		System.out.println("\n Você escolheu listar todos os cursos! ");
		
	*/}


}