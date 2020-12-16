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
	public void calculateSalary() {
		this.setSalary(this.getCoeffSalary() * 3000000 + overtime * 200000);
	}

	@Override
	public String toString() {
		System.out.println(String.format("%-7s%-10s%-10s%-15s%-15s%-15s%-10s", "ID", "Tên", "Tuổi", "Ngày làm", "ID bộ phận", "Ngày nghỉ", "Tăng ca"));
		return String.format("%-7s%-10s%-10d%-15s%-15s%-15d%-10b", id, name, age, workingDay, departmentId, dayOff, overtime);
	}
}
