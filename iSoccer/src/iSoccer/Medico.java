package iSoccer;

public class Medico extends Funcionarios{
	private String crm;

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Medico(String name, String email, String cpf, double salario, String telefone, String crm) {
		super(name, email, cpf, salario, telefone);
		this.crm = crm;
	}
	
	
}
