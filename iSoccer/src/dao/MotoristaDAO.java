package dao;

public class MotoristaDAO extends FuncionariosDAO{
	private String cnh;
	
	public MotoristaDAO(String name, String email, String cpf, double salario, String telefone, String cnh) {
		super(name, email, cpf, salario, telefone);
		this.cnh = cnh;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	

}
