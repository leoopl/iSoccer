package iSoccer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.BussDAO;
import dao.CtDAO;
import dao.EstadioDAO;
import dao.FuncionariosDAO;
import dao.JogadorDAO;
import dao.MedicoDAO;
import dao.MotoristaDAO;
import dao.SociosDAO;

public class Clube {
	
	private FuncionariosDAO presidente;
	private FuncionariosDAO medico;
	private FuncionariosDAO tecnico;
	private List<FuncionariosDAO> edFisicos;
	private List<FuncionariosDAO> motoristas;
	private List<FuncionariosDAO> cozinheiros;
	private List<FuncionariosDAO> advogados;
	private List<FuncionariosDAO> jogadores;
	private List<BussDAO> buss;
	private List<EstadioDAO> estadio;
	private List<CtDAO> ct;
	
	public Clube() {

		edFisicos = new ArrayList<FuncionariosDAO>();
		motoristas = new ArrayList<FuncionariosDAO>();
		cozinheiros = new ArrayList<FuncionariosDAO>();
		advogados = new ArrayList<FuncionariosDAO>();
		jogadores = new ArrayList<FuncionariosDAO>();
		buss = new ArrayList<BussDAO>();
		estadio = new ArrayList<EstadioDAO>();
		ct = new ArrayList<CtDAO>();
	}
	
	
	
	public FuncionariosDAO getPresidente() {
		return presidente;
	}
	public void setPresidente(FuncionariosDAO presidente) {
		this.presidente = presidente;
	}
	public FuncionariosDAO getMedico() {
		return medico;
	}
	public void setMedico(FuncionariosDAO medico) {
		this.medico = medico;
	}
	public FuncionariosDAO getTecnico() {
		return tecnico;
	}
	public void setTecnico(FuncionariosDAO tecnico) {
		this.tecnico = tecnico;
	}


	public void addMotorista(FuncionariosDAO m) {
		motoristas.add(m);
	}
	
	public void addEdFisico(FuncionariosDAO e) {
		edFisicos.add(e);
	}
	
	public void addCooker(FuncionariosDAO c) {
		cozinheiros.add(c);
	}
	
	public void addLawyer(FuncionariosDAO a) {
		advogados.add(a);
	}
	
	public void addPlayer(FuncionariosDAO j) {
		jogadores.add(j);
	}
	
	public void addBuss(BussDAO b) {
		buss.add(b);
	}
	
	public void addEstadio(EstadioDAO r) {
		estadio.add(r);
	}
	
	public void addCt(CtDAO tc) {
		ct.add(tc);
	}
	
	public void editBuss() {
		Scanner scan = new Scanner(System.in);
		if(buss.size() != 0) {
			for (int i = 0; i < buss.size(); i++) {
				System.out.println("Index: " + i + " - " + buss.get(i).getPlate());			
			}
			System.out.println("Escolha o index do Onibus no qual deseja alterar sua disponibilidade: ");
			int input = scan.nextInt();
			buss.get(input).setDisp();
			System.out.println("Statos alterado com sucesso.");
		}else {
			System.out.println("Não Disponivel!");
		}
	}
	
	public void editCt() {
		Scanner scan = new Scanner(System.in);
		if(ct.size() != 0) {
			for (int i = 0; i < ct.size(); i++) {
				System.out.println("Index: " + i + " - " + ct.get(i).getCtName());			
			}
			System.out.println("Escolha o index do CT no qual deseja alterar sua disponibilidade: ");
			int input = scan.nextInt();
			ct.get(input).setDisp();
			System.out.println("Statos alterado com sucesso.");
		}else {
			System.out.println("Não Disponivel!");
		}
	}
	
	public void editStadium() {
		Scanner scan = new Scanner(System.in);
		Scanner scanS = new Scanner(System.in);
		if(estadio.size() != 0) {
			for (int i = 0; i < estadio.size(); i++) {
				System.out.println("Index: " + i + " - " + estadio.get(i).getName());			
			}
			System.out.println("Escolha o index do Estadio no qual deseja Editar: ");
			int input = scan.nextInt();
			int aux;
			do {
				System.out.println("O que deseja Editar: ");
				System.out.println("1 - Nome");
				System.out.println("2 - Numero de Banheiros");
				System.out.println("3 - Numeros de Lanchonete");
				System.out.println("4 - Numero de Torcedores");
				System.out.println("5 - Disponibilidade do Estadio");
				System.out.println("0 - Sair.");
				aux = scan.nextInt();
				switch (aux) {
				case 1:
					System.out.println("Novo Nome:");
					String name = scanS.nextLine();
					estadio.get(input).setName(name);
					break;
				case 2:
					System.out.println("Nova quantidade de Banheiros:");
					int newWc = scan.nextInt();
					estadio.get(input).setWcNumber(newWc);
					break;
				case 3:
					System.out.println("Novo numero de lanchonetes:");
					int newBar = scan.nextInt();
					estadio.get(input).setBarNumber(newBar);
					break;
				case 4:
					System.out.println("Numero de Torcedores: ");
					int fans = scan.nextInt();
					estadio.get(input).setFansNumber(fans);
					break;
				case 5:
					estadio.get(input).setDisp();
					System.out.println("Disponibilidade Altarada Com Sucesso!");
					break;
				case 0:
					break;
				default:
					System.out.println("tente de novo");
				}
			} while (aux != 0);
		}else {
			System.out.println("Não disponivel!");
		}
	}
	
	public void printAptos() {
		for (int i = 0; i < jogadores.size(); i++) {
			JogadorDAO j = (JogadorDAO) jogadores.get(i);
			if (j.getAptos() == 1) {
				System.out.println(j.toString());
			}			
		}
	}
	
	public void editPartner(List<SociosDAO> partnerList) {
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
	
	public void addEstadio() {
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
		EstadioDAO newEst = new EstadioDAO(name, fans, wc, bar);
		addEstadio(newEst);		
	}

	public void addPartner(List<SociosDAO> partnerList) {
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
		
		SociosDAO partner = new SociosDAO(name, email, cpf, address, tel, value);
		partnerList.add(partner);
	}

	public void addEmployee() {
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
				FuncionariosDAO boss = new FuncionariosDAO(name, email, cpf, salary, tel);
				setPresidente(boss);
				break;
			case 2:
				System.out.println("Número da CRM: ");
				String crm = scan.nextLine();
				FuncionariosDAO medic = new MedicoDAO(name, email, cpf, salary, tel, crm);
				setMedico(medic);				
				break;
			case 3:
				FuncionariosDAO coach = new FuncionariosDAO(name, email, cpf, salary, tel);
				setTecnico(coach);
				break;
			case 4:
				FuncionariosDAO edFisic = new FuncionariosDAO(name, email, cpf, salary, tel);
				addEdFisico(edFisic);
				break;
			case 5:
				System.out.println("Número da CNH: ");
				String cnh = scan.nextLine();
				FuncionariosDAO driver = new MotoristaDAO(name, email, cpf, salary, tel, cnh);
				addMotorista(driver);
				break;
			case 6:
				FuncionariosDAO cooker = new FuncionariosDAO(name, email, cpf, salary, tel);
				addCooker(cooker);
				break;
			case 7:
				FuncionariosDAO lawyer = new FuncionariosDAO(name, email, cpf, salary, tel);
				addLawyer(lawyer);
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
				FuncionariosDAO player = new JogadorDAO(name, email, cpf, salary, tel, type, apto);
				addPlayer(player);
			default:
				break;
			}
		} while (input < 0 && input > 8);		
	}
	
	
	
	public void printNotAptos() {
		for (int i = 0; i < jogadores.size(); i++) {
			JogadorDAO j = (JogadorDAO) jogadores.get(i);
			if (j.getAptos() == 0) {
				System.out.println(j.toString());
			}			
		}
	}

	public void printTeam() {
		System.out.println("Técnico: " + tecnico);
		System.out.println("Jogadores: " + jogadores);
	}
	
	public void printGeneral() {
		System.out.println(presidente);
		System.out.println(medico);
		System.out.println(edFisicos);
		System.out.println(motoristas);
		System.out.println(cozinheiros);
		System.out.println(advogados);
	}
	
	public void printBuss() {
		System.out.println(buss);
	}
	
	public void printCT() {
		System.out.println(ct);
	}
	
	public void printStadium() {
		System.out.println(estadio);
	}
}
 