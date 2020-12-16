package Project_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Service {
	Scanner scan;
	private List<Staff> staffs;
	private List<Department> depts;

	public Service() {
		staffs = new ArrayList<>();
		depts = new ArrayList<>();

		Department d1 = new Department();
		d1.setPartCode(1);
		d1.setPartName("Bộ phận nghiên cứu, phát triển");

		Department d2 = new Department();
		d2.setPartCode(2);
		d2.setPartName("Bộ phận nhân sự.");

		Department d3 = new Department();
		d3.setPartCode(3);
		d3.setPartName("Bộ phận marketing.");

		depts.add(d1);
		depts.add(d2);
		depts.add(d3);

		staffs.add(new Employee("IT 1", "TrongBB", 19, 5, "16/08/2020", 1, 5, 3));
		staffs.add(new Employee("IT 2", "TrongBB", 20, 3, "01/09/2020", 1, 2, 1));
	}

	public void displayStaff() {
//		viết code hiển thị thông tin nhân viên
		System.out.println(String.format("%-10s%-20s%-10s%-15s%-15s%-15s%-10s", "ID", "Tên", "Tuổi", "Ngày làm",
				"ID bộ phận", "Ngày nghỉ", "Chức vụ/Tăng ca"));
		for (Staff staff : staffs) {
			if (staff instanceof Manager) {
				System.out.println(((Manager) staff).toString());
			} else if (staff instanceof Employee) {
				System.out.println(((Employee) staff).toString());
			}
		}
	}

	public void displayDepartment() {
		// viết code hiển thị thông tin các bộ phận
		System.out.println("Các bộ phận trong công ty bao gồm.");
		for (Department dept : depts) {
			System.out.println(dept.getPartCode() + ". " + dept.getPartName());
		}
	}

	public void displayStaffByDepartment() {
//		viết code hiển thị thông tin nhân viên theo từng bộ phận
		
		
		
		for (Department dept : depts) {
			
			System.out.println(dept.getPartCode() + ". " + dept.getPartName());
			System.out.println("----------------------------------------------------------------------------------------------------");
//			hiển thị thông tin bộ phận (bằng hàm toString của class Department);
			System.out.println(String.format("%-10s%-20s%-10s%-15s%-15s%-15s%-10s", "ID", "Tên", "Tuổi", "Ngày làm",
					"ID bộ phận", "Ngày nghỉ", "Chức vụ/Tăng ca"));
			System.out.println("----------------------------------------------------------------------------------------------------");
			
			for (Staff staff : staffs) {
				if (dept.getPartCode() == staff.getDepartmentId()) {
					System.out.println(staff.toString());
//					hiển thị tên nhân viên;

				}
			}
		}
	}

//	Thêm thông tin nhân viên vào công ty
	public void addStaff() {
		scan = new Scanner(System.in);
		boolean isDuplicate = false;
		int selection;
		int overtime;
		int departmentId = 0;
		String position = "";

		System.out.print("Id Nhân viên: ");
		String id;
		do {
			id = scan.nextLine();
			// kiểm tra id trùng
			isDuplicate = isDuplicatedEmployee(id);
			if (isDuplicate) {
				System.out.println("Id bị trùng, bạn cần nhập lại");
			}
		} while (isDuplicate == true);
		System.out.print("Nhập tên nhân viên: ");
		String name = scan.nextLine();
		System.out.print("Tuổi của nhân viên: ");
		int age = scan.nextInt();
		System.out.print("Hệ số lương: ");
		int coffSalary = scan.nextInt();
		System.out.print("Ngày làm việc: ");
		String workingDay = scan.next();
//		Chọn bộ phận trong công ty
		System.out.println("Bộ phận:");
		displayDepartment();

		System.out.print("Chọn bộ phận: ");
		if (scan.hasNextInt()) {
			departmentId = inputData("", 1, 3);
		} else {
			scan.nextLine();
		}

		System.out.print("Ngày nghỉ: ");
		int dayOff = scan.nextInt();
//		Vị trí trong công ty
		System.out.println("1. Nhân viên");
		System.out.println("2. Quản lý");
		System.out.print("Lựa chọn của bạn: ");

		selection = inputData("Lựa chọn của bạn: ", 1, 2);
		if (selection == 1) {
			System.out.print("Tăng ca: ");
			overtime = scan.nextInt();
			Employee emp = new Employee(id, name, age, coffSalary, workingDay, departmentId, dayOff, overtime);
			// emp.calculateSalary();
			staffs.add(emp);
		} else if (selection == 2) {
//			Chức vụ trong công ty
			System.out.println("Chức vụ của bạn là: ");
			System.out.println("1. Business Leader(Trưởng phòng kinh doanh).");
			System.out.println("2. Project Leader(Lãnh đạo dự án).");
			System.out.println("3. Technical Leader");
			System.out.print("Lựa chọn của bạn là: ");
			if (scan.hasNextInt()) {
				int position_input = inputData("", 1, 3);
				if (position_input == 1) {
					position = "Business Leader";
				} else if (position_input == 2) {
					position = "Project Leader";
				} else if (position_input == 3) {
					position = "Technical Leader";
				}

			} else {
				scan.nextLine();
			}

			Manager manager = new Manager(id, name, age, coffSalary, workingDay, departmentId, dayOff, position);
			manager.calculateSalary();
			staffs.add(manager);
		}
	}

//	Nhập sai sẽ nhập lại
	public int inputData(String message, int min, int max) {

		int value = 0;
		do {
			System.out.print(message);
			while (!scan.hasNextInt()) {
				scan.nextLine();
				System.out.print(message);
			}
			value = scan.nextInt();
		} while (value < min || value > max);
		return value;
	}

//	Kiểm tra Id có bị trùng ko
	private boolean isDuplicatedEmployee(String id) {
		for (Staff staff : staffs) {
			if (staff.getId().equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;
	}

//	Tìm ID nhân viên
	public void search(String searchKey) {
//		Tìm kiếm id trong danh sách (list) các id
		List<Staff> myStaffs = new ArrayList<>();
		for (Staff staff : staffs) {
			if (staff.getId().contains(searchKey)) {
				myStaffs.add(staff);
			}
		}

		// Kiểm tra xem myStaff xem nó có cuốn sách nào không, nếu có không có thì in ra
		// thông báo là không tìm thấy
		if (myStaffs.isEmpty()) {
			System.out.println("Không tìm thấy Id.");
		} else {
			for (Staff staff : myStaffs) {
				System.out.println(staff.toString());
			}
		}
	}

	public void showSalaryDesc() {

		Collections.sort(staffs, new Comparator<Staff>() {
			@Override
			public int compare(Staff o1, Staff o2) {
				// TODO Auto-generated method stub
				long salaryO1;
				long salaryO2;
				if (o1 instanceof Manager) {
					salaryO1 = ((Manager) o1).calculateSalary();
				} else {
					salaryO1 = ((Employee) o1).calculateSalary();
				}

				salaryO2 = (o2 instanceof Manager) ? ((Manager) o2).calculateSalary()
						: ((Employee) o2).calculateSalary();

				return (int) (salaryO2 - salaryO1);
			}
		});

//		In ra toàn bộ lương nhân viên toàn công ty

		System.out.println(String.format("%-10s%-20s%-10s", "ID", "Tên", "Lương"));

		for (Staff staff : staffs) {
			if (staff instanceof Employee) {
				Employee e = (Employee) staff;
				System.out.println(String.format("%-10s%-20s%-10d", e.getId(), e.getName(), e.calculateSalary()));

			}

			if (staff instanceof Manager) {
				Manager m = (Manager) staff;
				System.out.println(String.format("%-10s%-20s%-10d", m.getId(), m.getName(), m.calculateSalary()));

			}
		}

	}

	public void showSalaryAsc() {
		Collections.sort(staffs, new Comparator<Staff>() {
			@Override
			public int compare(Staff o1, Staff o2) {
				// TODO Auto-generated method stub
				long salaryO1;
				long salaryO2;
				if (o1 instanceof Manager) {
					salaryO1 = ((Manager) o1).calculateSalary();
				} else {
					salaryO1 = ((Employee) o1).calculateSalary();
				}

				salaryO2 = (o2 instanceof Manager) ? ((Manager) o2).calculateSalary()
						: ((Employee) o2).calculateSalary();

				return (int) (salaryO1 - salaryO2);
			}
		});

//		In ra toàn bộ lương nhân viên toàn công ty

		System.out.println(String.format("%-10s%-20s%-10s", "ID", "Tên", "Lương"));

		for (Staff staff : staffs) {
			if (staff instanceof Employee) {
				Employee e = (Employee) staff;
				System.out.println(String.format("%-10s%-20s%-10d", e.getId(), e.getName(), e.calculateSalary()));

			}

			if (staff instanceof Manager) {
				Manager m = (Manager) staff;
				System.out.println(String.format("%-10s%-20s%-10d", m.getId(), m.getName(), m.calculateSalary()));

			}
		}
	}

}