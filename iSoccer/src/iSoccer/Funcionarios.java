package iSoccer;

public class Funcionarios {
	private String name;
	private String email;
	private String cpf;
	private double salario;
	private String telefone;
	
	public Funcionarios(String name, String email, String cpf, double salario, String telefone) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.salario = salario;
		this.telefone = telefone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", email=" + email + ", cpf=" + cpf + ", salario=" + salario
				+ ", telefone=" + telefone + "]";
	}
	
	
	
}
