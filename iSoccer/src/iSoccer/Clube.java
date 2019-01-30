package iSoccer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clube {
	
	private Funcionarios presidente;
	private Funcionarios medico;
	private Funcionarios tecnico;
	private List<Funcionarios> edFisicos;
	private List<Funcionarios> motoristas;
	private List<Funcionarios> cozinheiros;
	private List<Funcionarios> advogados;
	private List<Funcionarios> jogadores;
	private List<Buss> buss;
	private List<Estadio> estadio;
	private List<Ct> ct;
	
	public Clube() {

		edFisicos = new ArrayList<Funcionarios>();
		motoristas = new ArrayList<Funcionarios>();
		cozinheiros = new ArrayList<Funcionarios>();
		advogados = new ArrayList<Funcionarios>();
		jogadores = new ArrayList<Funcionarios>();
		buss = new ArrayList<Buss>();
		estadio = new ArrayList<Estadio>();
		ct = new ArrayList<Ct>();
	}
	
	
	
	public Funcionarios getPresidente() {
		return presidente;
	}
	public void setPresidente(Funcionarios presidente) {
		this.presidente = presidente;
	}
	public Funcionarios getMedico() {
		return medico;
	}
	public void setMedico(Funcionarios medico) {
		this.medico = medico;
	}
	public Funcionarios getTecnico() {
		return tecnico;
	}
	public void setTecnico(Funcionarios tecnico) {
		this.tecnico = tecnico;
	}


	public void addMotorista(Funcionarios m) {
		motoristas.add(m);
	}
	
	public void addEdFisico(Funcionarios e) {
		edFisicos.add(e);
	}
	
	public void addCooker(Funcionarios c) {
		cozinheiros.add(c);
	}
	
	public void addLawyer(Funcionarios a) {
		advogados.add(a);
	}
	
	public void addPlayer(Funcionarios j) {
		jogadores.add(j);
	}
	
	public void addBuss(Buss b) {
		buss.add(b);
	}
	
	public void addEstadio(Estadio r) {
		estadio.add(r);
	}
	
	public void addCt(Ct tc) {
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
			Jogador j = (Jogador) jogadores.get(i);
			if (j.getAptos() == 1) {
				System.out.println(j.toString());
			}			
		}
	}
	
	public void printNotAptos() {
		for (int i = 0; i < jogadores.size(); i++) {
			Jogador j = (Jogador) jogadores.get(i);
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
 