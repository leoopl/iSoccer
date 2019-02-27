package dao;

public class CtDAO {
	private String ctName;
	private int dormNumber;
	private boolean disp;
	
	
	public CtDAO(String ctName, int dormNumber) {
		this.ctName = ctName;
		this.dormNumber = dormNumber;
		this.disp = true;
	}


	public String getCtName() {
		return ctName;
	}


	public void setCtName(String ctName) {
		this.ctName = ctName;
	}


	public int getDormNumber() {
		return dormNumber;
	}


	public void setDormNumber(int dormNumber) {
		this.dormNumber = dormNumber;
	}

	public boolean isDisp() {
		return disp;
	}

	public void setDisp() {
		if (this.disp == true) {
			this.disp = false;
		} else {
			this.disp = true;
		}
	}


	@Override
	public String toString() {
		return "Ct [ctName=" + ctName + ", dormNumber=" + dormNumber + ", disp=" + disp + "]";
	}
	

}
