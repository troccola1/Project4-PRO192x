package Project_4;

public class Employee extends Staff implements ICalculator {

	private int overtime;

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}

	public Employee(String id, String name, int age, int coeffSalary, String workingDay, int departmentId, int dayOff,
			int overtime) {
		super(id, name, age, coeffSalary, workingDay, departmentId, dayOff);
		this.overtime = overtime;
	}

	@Override
	public long calculateSalary() {
		return (long) (getCoeffSalary() * 3000000 + overtime * 200000);
	}

	@Override
	public String toString() {
		return String.format("%-10s%-20s%-10d%-15s%-15s%-15d%-10d", id, name, age, workingDay, departmentId, dayOff,
				overtime);
	}
}
