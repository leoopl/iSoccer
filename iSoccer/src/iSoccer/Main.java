package iSoccer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static Admin admin = new Admin();
	private static Clube clube = new Clube();
	private static List<Socios> partnerList = new ArrayList<Socios>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String input1, input2;
		System.out.println("##Login##");
		System.out.println("Login: ");
		input1 = scan.nextLine();
		System.out.println("Senha: ");
		input2 = scan.nextLine();
		if (admin.getLogin().equals(input1) && admin.getPsw().equals(input2)) {
			printMenu();			
		}else {
			System.out.println("Login ou senha invalida!");
		}
		
	}

	private static void printMenu() {
		Scanner scan = new Scanner(System.in);
		
		int input;
		do {
			System.out.println();
			System.out.println("########~MENU~########");
			System.out.println("1 - Adicionar Funcionario");
			System.out.println("2 - Adicionar Sócios");
			System.out.println("3 - Adicionar Recursos Físicos");
			System.out.println("4 - Editar Status de Pagamento do Sócio");
			System.out.println("5 - Relatorios");
			System.out.println("0 - Logoff");
			input = scan.nextInt();
			
			switch (input) {
			case 1:
				addEmployee();
				break;
			case 2:
				addPartner();
				break;
			case 3:
				menuResources();
				break;
			case 4:
				editPartner();
				break;
			case 5:
				searchMenu();
				break;				
			case 0:
				break;
			default:
				System.out.println("Operação Invalida.");
			}
		}while(input != 0);
		
	}

	private static void searchMenu() {
		Scanner scan = new Scanner(System.in);
		
		int input;
		do {
			System.out.println("Relatorio Atual:");
			System.out.println("1 - Time");
			System.out.println("2 - Serviços Gerais");
			System.out.println("3 - Transporte");
			System.out.println("4 - Centro de Treinamento");
			System.out.println("5 - Estádio");
			System.out.println("6 - Sócio Torcedor");
			System.out.println("7 - Jogadores Aptos e não aptos");
			System.out.println("0 - Voltar ao Menu Principal");
			input = scan.nextInt();
			
			switch (input) {
			case 1:
				clube.printTeam();						
				break;
			case 2:
				clube.printGeneral();
				break;
			case 3:
				clube.printBuss();
				break;
			case 4:
				clube.printCT();
				break;
			case 5:
				clube.printStadium();
				break;
			case 6:
				System.out.println("Quantidade de Sócios: " + partnerList.size());
				System.out.println("Adimplentes: " + counterType(1) + "\nInadimplentes: " + counterType(2));
				System.out.println(partnerList.toString());
				break;
			case 7:
				System.out.println("Jogadores Aptos: ");
				clube.printAptos();
				System.out.println();
				System.out.println("Jogadores que não estão Aptos para jogo: ");
				clube.printNotAptos();
			case 0:
				break;
			default:
				System.out.println("Operação Invalida.");
			}
		}while(input != 0);
		
	}

	private static int counterType(int t) {
		int count1 = 0;
		int count2 = 0;
		
		for (Socios partner : partnerList) {
			if(partner.getStatus() == true) {
				count1 += 1;
			}if (partner.getStatus() == false) {
				count2 += 1;				
			}
		}
		if (t == 1) {
			return count1;
		}else {
			return count2;
		}
	}

	private static void editPartner() {
		Scanner scan = new Scanner(System.in);
		if (partnerList.size() != 0) {
			for (int i = 0; i < partnerList.size(); i++) {
				System.out.println("Index: " + i + " - " + partnerList.get(i).getName());			
			}
			System.out.println("Escolha o index do Sócio no qual deseja alterar o estado de seu pagamento: ");
			int input = scan.nextInt();
			partnerList.get(input).setStatus();
			System.out.println("Statos alterado com sucesso.");
		} else {
			System.out.println("Não existe sócio cadastrado.");
		}		
	}

	private static void menuResources() {
		Scanner scan = new Scanner(System.in);
		Scanner scanS = new Scanner(System.in);

		int input;
		do {
			System.out.println("1 - Adicionar Onibus");
			System.out.println("2 - Modificar disponibilidade do onibus");
			System.out.println("3 - Adicionar Estadio");
			System.out.println("4 - Editar Estadio");
			System.out.println("5 - Adicionar Centro de Treinamento");
			System.out.println("6 - Modificar disponibilidade do CT");
			System.out.println("0 - Voltar ao Menu Principal");
			input = scan.nextInt();
			switch (input) {
			case 1:
				System.out.println("Placa do Onibus: ");
				String plate = scanS.nextLine();
				Buss buss = new Buss(plate);
				clube.addBuss(buss);
				break;
			case 2:
				clube.editBuss();
				break;
			case 3:
				addEstadio();
				break;
			case 4:
				clube.editStadium();
				break;
			case 5:
				System.out.println("Nome do Centro de Treinamento: ");
				String name = scanS.nextLine();
				System.out.println("Numero de Dormitorios: ");
				int number = scan.nextInt();
				Ct newCt = new Ct(name, number);
				clube.addCt(newCt);
				break;
			case 6:
				clube.editCt();
				break;
			case 0:
				break;
			default:
				System.out.println("Operação invalida");
			}
		} while (input != 0);
		
		
	}

	private static void addEstadio() {
		Scanner scan = new Scanner(System.in);
		Scanner intScan = new Scanner(System.in);
		System.out.println("Nome do Estadio: ");
		String name = scan.nextLine();
		System.out.println("Numeros de Torcedores que o estadio comporta: ");
		int fans = intScan.nextInt();
		System.out.println("Numeros de Banheiros do Estadio: ");
		int wc = intScan.nextInt();
		System.out.println("Numeros de Lanchonetes do Estadio: ");
		int bar = intScan.nextInt();
		Estadio newEst = new Estadio(name, fans, wc, bar);
		clube.addEstadio(newEst);		
	}

	private static void addPartner() {
		Scanner scan = new Scanner(System.in);
		Scanner intScan = new Scanner(System.in);
		
		System.out.println("Nome Completo: ");
		String name = scan.nextLine();
		System.out.println("E-Mail: ");
		String email = scan.nextLine();
		System.out.println("CPF: ");
		String cpf = scan.nextLine();
		System.out.println("Telefone: ");
		String tel = scan.nextLine();
		System.out.println("Endereço: ");
		String address = scan.nextLine();
		System.out.println("Valor da Contribuição: ");
		double value = intScan.nextDouble();
		
		Socios partner = new Socios(name, email, cpf, address, tel, value);
		partnerList.add(partner);
	}

	private static void addEmployee() {
		Scanner scan = new Scanner(System.in);
		Scanner intScan = new Scanner(System.in);
		
		System.out.println("Nome Completo: ");
		String name = scan.nextLine();
		System.out.println("E-Mail: ");
		String email = scan.nextLine();
		System.out.println("CPF: ");
		String cpf = scan.nextLine();
		System.out.println("Salario do Empregado: ");
		double salary = intScan.nextDouble();
		System.out.println("Telefone: ");
		String tel = scan.nextLine();
		System.out.println("Tipo de empregado: ");
		int input;
		do {
			System.out.println("1 - Presidente");
			System.out.println("2 - Médico");
			System.out.println("3 - Técnico");
			System.out.println("4 - Preparador Fisico");
			System.out.println("5 - Motorista");
			System.out.println("6 - Cozinheiro");
			System.out.println("7 - Advogado");
			System.out.println("8 - Jogador");
			input = intScan.nextInt();
			switch (input) {
			case 1:
				Funcionarios boss = new Funcionarios(name, email, cpf, salary, tel);
				clube.setPresidente(boss);
				break;
			case 2:
				System.out.println("Número da CRM: ");
				String crm = scan.nextLine();
				Funcionarios medic = new Medico(name, email, cpf, salary, tel, crm);
				clube.setMedico(medic);				
				break;
			case 3:
				Funcionarios coach = new Funcionarios(name, email, cpf, salary, tel);
				clube.setTecnico(coach);
				break;
			case 4:
				Funcionarios edFisic = new Funcionarios(name, email, cpf, salary, tel);
				clube.addEdFisico(edFisic);
				break;
			case 5:
				System.out.println("Número da CNH: ");
				String cnh = scan.nextLine();
				Funcionarios driver = new Motorista(name, email, cpf, salary, tel, cnh);
				clube.addMotorista(driver);
				break;
			case 6:
				Funcionarios cooker = new Funcionarios(name, email, cpf, salary, tel);
				clube.addCooker(cooker);
				break;
			case 7:
				Funcionarios lawyer = new Funcionarios(name, email, cpf, salary, tel);
				clube.addLawyer(lawyer);
				break;
			case 8:
				int type;
				do {
					System.out.println("Tipo do jogardo: \n1 - Volante\n2 - Zagueiro\n3 - Meia\n4 - Goleiro\n5 - Atacante\n6 - Lateral esquerdo\n7 - Lateral direito");
					type = intScan.nextInt();
				} while (type < 0 && type > 7);
				int apto;
				do {
					System.out.println("O jogador esta habilitado para jogar? \n1 - Sim\n0 - Não");
					apto = intScan.nextInt();
				} while (apto < -1 && apto > 2);
				Funcionarios player = new Jogador(name, email, cpf, salary, tel, type, apto);
				clube.addPlayer(player);
			default:
				break;
			}
		} while (input < 0 && input > 8);		
	}
}
