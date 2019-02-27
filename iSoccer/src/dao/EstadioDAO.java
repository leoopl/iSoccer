package dao;

public class EstadioDAO {
	private String name;
	private int fansNumber;
	private int wcNumber;
	private int barNumber;
	private boolean disp;
	
	public EstadioDAO(String name, int fansNumber, int wcNumber, int barNumber) {
		this.name = name;
		this.fansNumber = fansNumber;
		this.wcNumber = wcNumber;
		this.barNumber = barNumber;
		this.disp = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFansNumber() {
		return fansNumber;
	}

	public void setFansNumber(int fansNumber) {
		this.fansNumber = fansNumber;
	}

	public int getWcNumber() {
		return wcNumber;
	}

	public void setWcNumber(int wcNumber) {
		this.wcNumber = wcNumber;
	}

	public int getBarNumber() {
		return barNumber;
	}

	public void setBarNumber(int barNumber) {
		this.barNumber = barNumber;
	}

	public boolean getDisp() {
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
		return "Estadio [name=" + name + ", fansNumber=" + fansNumber + ", wcNumber=" + wcNumber + ", barNumber="
				+ barNumber + ", disp=" + disp + "]";
	}
	
	
	
}
