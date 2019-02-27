package dao;

public class SociosDAO {
	private String name;
	private String email;
	private String cpf;
	private String address;
	private String number;
	private double value;
	private boolean status; //true = adimplente - false = inadimplente
	private int type;//????junior, sênior e elite
	
	
	public SociosDAO(String name, String email, String cpf, String address, String number, double value) {
		super();
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.address = address;
		this.number = number;
		setValue(value);
		this.status = true;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
		if (value < 100) {
			this.type = 1;
		}else if (value < 500) {
			this.type = 2;
		}else {
			this.type = 3;
		}
	}
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus() {
		if (this.status == true) {
			this.status = false;
		} else {
			this.status = true;
		}
	}

	@Override
	public String toString() {
		return "Socios [name=" + name + ", email=" + email + ", cpf=" + cpf + ", address=" + address + ", number="
				+ number + ", value=" + value + ", status=" + status + ", type=" + type + "]";
	}

	
	
}
