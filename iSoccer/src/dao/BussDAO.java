package dao;

public class BussDAO {
	private String plate;
	private boolean disp;
	
	
	public BussDAO(String plate) {
		this.plate = plate;
		this.disp = true;
	}
	
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
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
		return "Buss [plate=" + plate + ", disp=" + disp + "]";
	}
	
	
}
