 package Project_4;

public abstract class Staff {
	
	protected String id;
	protected String name;
	protected int age;
	protected int coeffSalary ;
	protected long salary;
	protected String workingDay;
	protected int departmentId;
	protected int dayOff;
	
 	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCoeffSalary () {
		return coeffSalary ;
	}

	public void setCoffSalary (int coeffSalary ) {
		this.coeffSalary  = coeffSalary ;
	}
	
	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getWorkingDay() {
		return workingDay;
	}

	public void setWorkingDay(String workingDay) {
		this.workingDay = workingDay;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getDayOff() {
		return dayOff;
	}
	
	public void setDayOff(int dayOff) {
		this.dayOff = dayOff;
	}


	public Staff(String id, String name, int age, int coeffSalary, String workingDay, int departmentId, int dayOff) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.coeffSalary  = coeffSalary;
		this.workingDay = workingDay;
		this.departmentId = departmentId;
		this.dayOff = dayOff;
	}

	public abstract String toString();

}
