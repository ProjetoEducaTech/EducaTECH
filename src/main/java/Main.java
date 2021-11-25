import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);

		System.out.println("\n Seja bem vindo ao EducaTECH! \n");

		System.out.println("\n Para começar, você possui cadastro?");
		System.out.println("\n \n S - Sim");
		System.out.println("\n \n N - Não");
		String verificar_login = leitor.next().toUpperCase();

		switch (verificar_login) {
		case "S":
			tem_login();
			break;

		case "N":
			sem_login();
			break;

		default:
			System.out.println("Erro");
			break;
		}

	}

	public static void sistema(String msg, String usuario, String cpf) {

		Scanner leitor = new Scanner(System.in);

		System.out.println("\n \n Você efetuou o login com sucesso!");
		System.out.println("\n \n Seja bem vindo, " + usuario + ", ao EducaTECH, o sistema que irá o auxiliar no processo de integração ao ensino superior. \n");
		
		// Opçoes para o usuario BASICAS //
		
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
		
		// Resto vida que segue //

		System.out.print("Para prosseguir, insira sua nota de corte: ");
		float nota_enem = leitor.nextFloat();
		
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
		
	}
	
	public static void sem_login() {

		System.out.print("Para acessar todos os nossos benefícios, efetue o login.");

		fazerCadastro();
			
		}
	
	public static void fazerCadastro() {

		System.out.println("\nBem-vindo ao Cadastro\n");

		Scanner leitor = new Scanner(System.in);

		System.out.print("Seu CPF: ");
		String cpf_usuario = leitor.next();

		System.out.print("Crie um Usuario: ");
		String criar_usuario = leitor.next();

		System.out.print("Crie uma Senha: ");
		String criar_senha = leitor.next();

		// Enviar para o Vitor parametro usuario e senha e cpf //

		tem_login();

	}
	
	public static void tem_login() {

		Scanner leitor = new Scanner(System.in);

		System.out.println("\n Seja bem vindo novamente!");
		
		System.out.print("\n Insira seu CPF: ");
		String cpf = leitor.next();

		System.out.print("\n Insira sua senha: ");
		String senha = leitor.next();

		String nome = "Júlia";

		// Enviar parametros para o victor login & senha //

		sistema("Logado", nome, cpf);

	} 
	
	public static void info_conta(String nome, String cpf) {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("\n");
		
		System.out.print("\n O que você gostaria de acessar? \n");
		String[] opc = new String[] {""," Acessar meus dados ", " Acessar meus cursos favoritados "};
		
		for(int i = 1; i < 3; i++) {
			System.out.println(i + " - " + opc[i]);
		}
		
		int escolha_conta = leitor.nextInt();

		switch(escolha_conta) {
			case 1:
				infos_user(nome,cpf);
			break;
			case 2:
				infos_favorito(cpf);
			break;
		}
		
	}
	
	public static void infos_favorito(String id) {
		System.out.println("\n Seus cursos favoritados são: \n");
		String[] favoritos = new String[] {"Ánalise e Desenvolvimento de Sistema - IFSC", "Informática - IFC"};
		
		for(int i = 0; i < favoritos.length;i++) {
			System.out.println(favoritos[i]);
		}
		
		System.out.println("\n");

	}
	
	public static void infos_user(String nome,String cpf) {
		
		System.out.println("\n Olá, "+ nome +", esses sãos seus dados: \n");
		
		System.out.println("Seu nome: " + nome);
		System.out.println("Seu CPF: " + cpf);
		
	}

	//listações de cursos por área
	
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
		
	}


}
