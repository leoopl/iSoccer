package iSoccer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static Admin admin = new Admin();
	private static List<Funcionarios> employeeList = new ArrayList<Funcionarios>();
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
				addResources();
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
			System.out.println("0 - Voltar ao Menu Principal");
			input = scan.nextInt();
			
			switch (input) {
			case 1:
								
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				System.out.println("Quantidade de Sócios: " + partnerList.size());
				System.out.println("Adimplentes: " + counterType(1) + "\nInadimplentes: " + counterType(2));
				System.out.println(partnerList.toString());
				break;
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
		
		for (int i = 0; i < partnerList.size(); i++) {
			System.out.println("Index: " + i + " - " + partnerList.get(i).getName());			
		}
		System.out.println("Escolha o index do Sócio no qual deseja alterar o estado de seu pagamento: ");
		int input = scan.nextInt();
		partnerList.get(input).setStatus();
		System.out.println("Statos alterado com sucesso.");
		
	}

	private static void addResources() {
		// TODO Auto-generated method stub
		
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
		
		
	}
	
	

}
