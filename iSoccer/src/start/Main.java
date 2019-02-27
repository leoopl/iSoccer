package start;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.AdminDAO;
import dao.BussDAO;
import dao.CtDAO;
import dao.EstadioDAO;
import dao.FuncionariosDAO;
import dao.JogadorDAO;
import dao.MedicoDAO;
import dao.MotoristaDAO;
import dao.SociosDAO;
import iSoccer.Clube;

public class Main {
	
	private static AdminDAO admin = new AdminDAO();
	private static Clube clube = new Clube();
	private static List<SociosDAO> partnerList = new ArrayList<SociosDAO>();

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
		try {
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
					clube.addEmployee();
					break;
				case 2:
					clube.addPartner(partnerList);
					break;
				case 3:
					menuResources();
					break;
				case 4:
					clube.editPartner(partnerList);
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
		} catch (Exception e) {
			System.out.println("Por favor tente novamente!");
		}
		
		
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
		
		for (SociosDAO partner : partnerList) {
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
				BussDAO buss = new BussDAO(plate);
				clube.addBuss(buss);
				break;
			case 2:
				clube.editBuss();
				break;
			case 3:
				clube.addEstadio();
				break;
			case 4:
				clube.editStadium();
				break;
			case 5:
				System.out.println("Nome do Centro de Treinamento: ");
				String name = scanS.nextLine();
				System.out.println("Numero de Dormitorios: ");
				int number = scan.nextInt();
				CtDAO newCt = new CtDAO(name, number);
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
}
