package dao;

public class MedicoDAO extends FuncionariosDAO{
	private String crm;

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public MedicoDAO(String name, String email, String cpf, double salario, String telefone, String crm) {
		super(name, email, cpf, salario, telefone);
		this.crm = crm;
	}
	
	
}
