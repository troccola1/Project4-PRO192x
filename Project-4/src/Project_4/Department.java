package Project_4;

public class Department {
	private int partCode;
	private String partName;
	private int numberEmployees;

	public int getPartCode() {
		return partCode;
	}

	public void setPartCode(int partCode) {
		this.partCode = partCode;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public int getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(int numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	@Override
	public String toString() {
		return String.format("%-10s%-10s%-10%d", partCode, partName, numberEmployees);
	}
}
