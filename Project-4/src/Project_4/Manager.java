package Project_4;

public class Manager extends Staff implements ICalculator {
	private String position;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Manager(String id, String name, int age, int coeffSalary, String workingDay, int departmentId, int dayOff,
			String position) {
		super(id, name, age, coeffSalary, workingDay, departmentId, dayOff);
		this.position = position;
	}

	@Override
	public long calculateSalary() {
		int positionSalary = 0;
		if (getPosition().equals("Business Leader")) {
			positionSalary = 8000000;
		} else if (getPosition().equals("Project Leader")) {
			positionSalary = 5000000;
		} else if (getPosition().equals("Technical Leader")) {
			positionSalary = 6000000;
		}
		return (long) (getCoeffSalary() * 5000000 + positionSalary);
	}

	@Override
	public String toString() {
		return String.format("%-10s%-20s%-10d%-15s%-15s%-15d%-10s", id, name, age, workingDay, departmentId, dayOff, position);
	}

}