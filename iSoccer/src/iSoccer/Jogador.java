package iSoccer;

public class Jogador extends Funcionarios{
	private int type;
	private int aptos;

	public Jogador(String name, String email, String cpf, double salario, String telefone, int type, int aptos) {
		super(name, email, cpf, salario, telefone);
		this.type = type;
		this.aptos = aptos;
	}
	
	public String getType() {
		if (type == 1) {
			return "Volante";
		}else if (type == 2) {
			return "Zagueiro";
		}else if (type == 3) {
			return "Meia";
		}else if (type == 4) {
			return "Goleiro";
		}else if (type == 5) {
			return "Atacante";
		}else if (type == 6) {
			return "Lateral Esquerda";
		}else {
			return "Lateral Direita";
		}
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAptos() {
		return aptos;
	}

	public String toAptos() {
		if (aptos == 1) {
			return "Habilitado a jogar";
		} else {
			return "Encontra-se no Departamento Médico";
		}
	}

	public void setAptos(int aptos) {
		this.aptos = aptos;
	}

	@Override
	public String toString() {
		return "Jogador [type=" + getType() + ", aptos=" + toAptos() + super.toString() + "]";
	}
	
	

}
