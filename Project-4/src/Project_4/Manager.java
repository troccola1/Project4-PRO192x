package Project_4;

public class Manager extends Staff implements ICalculator {
	private int position;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Manager(String id, String name, int age, int coeffSalary, String workingDay, int departmentId, int dayOff,
			int position) {
		super(id, name, age, coeffSalary, workingDay, departmentId, dayOff);
		this.position = position;
	}

	@Override
	public void calculateSalary() {
		int positionSalary = 0;
		if ("Business Leader".equals(getPosition())) {
			positionSalary = 8000000;
		} else if ("Project Leader".equals(getPosition())) {
			positionSalary = 5000000;
		} else if ("Technical Leader".equals(getPosition())) {
			positionSalary = 6000000;
		}
		this.setSalary(this.getCoeffSalary() * 5000000 + positionSalary);
	}

	@Override
	public String toString() {
		System.out.println(String.format("%-7s%-10s%-10s%-15s%-15s%-15s%-10s", "ID", "Tên", "Tuổi", "Ngày làm", "ID bộ phận", "Ngày nghỉ", "Chức vụ"));
		return String.format("%-7s%-10s%-10d%-15s%-15s%-15d%-10d", id, name, age, workingDay, departmentId, dayOff, position);
	}

}