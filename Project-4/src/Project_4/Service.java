package Project_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Service {
	static Scanner scan = new Scanner(System.in);
	private static List<Staff> staffs;
	private static List<Department> depts;

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

		Department d4 = new Department();
		d4.setPartCode(4);
		d4.setPartName("Bộ phận kế toán.");

		Department d5 = new Department();
		d5.setPartCode(5);
		d5.setPartName("Các bộ phận khác");

		depts.add(d1);
		depts.add(d2);
		depts.add(d3);
		depts.add(d4);
		depts.add(d5);
	}

	public void displayStaff() {
//		viết code hiển thị thông tin nhân viên
		// System.out.println(staffs);
		for (Staff staff : staffs) {
			System.out.println(staff.toString());
		}
	}

	public void displayDepartment() {
		// viết code hiển thị thông tin các bộ phận
		// System.out.println(depts);
		for (Department dept : depts) {
			System.out.println(dept.getPartCode() + ". " + dept.getPartName());
		}
	}

	public void displayStaffByDepartment() {
//		viết code hiển thị thông tin nhân viên theo từng bộ phận
		for (Department dept : depts) {
			System.out.println(dept.getPartCode() + ". " + dept.getPartName());
			System.out.println("------------------------------------------------------------");
//			hiển thị thông tin bộ phận (bằng hàm toString của class Department);
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
		boolean isDuplicate = false;
		int selection;
		int overtime;
		int departmentId = 0;
		int position = 0;

		System.out.print("Id Nhân viên: ");
		String id;
		do {
			id = scan.next();
			// kiểm tra id trùng
			isDuplicate = isDuplicatedEmployee(id);
			if (isDuplicate) {
				System.out.println("Id bị trùng, bạn cần nhập lại");
			}
		} while (isDuplicate == true);
		System.out.print("Nhập tên nhân viên: ");
		String name = scan.next();
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
			departmentId = scan.nextInt();
		} else {
			scan.nextLine();
		}

		System.out.print("Ngày nghỉ: ");
		int dayOff = scan.nextInt();
//		Vị trí trong công ty
		System.out.println("1. Nhân viên");
		System.out.println("2. Quản lý");
		System.out.print("Lựa chọn của bạn: ");

		selection = scan.nextInt();
		if (selection == 1) {
			System.out.print("Tăng ca: ");
			overtime = scan.nextInt();
			Employee emp = new Employee(id, name, age, coffSalary, workingDay, departmentId, dayOff, overtime);
			emp.calculateSalary();
			staffs.add(emp);
		} else if (selection == 2) {
//			Chức vụ trong công ty
			System.out.println("Chức vụ: ");
			System.out.println("1. Business Leader(Trưởng phòng kinh doanh).");
			System.out.println("2. Project Leader(Lãnh đạo dự án).");
			System.out.println("3. Technical Leader");

			if (scan.hasNextInt()) {
				position = scan.nextInt();
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
//		Tìm kiếm id trong danh sách (list) các id, những cuốn tìm được sẽ đẩy vào myStaff
		List<Staff> myStaffs = new ArrayList<>();
		for (Staff staff : staffs) {
			if (staff.getId().contains(searchKey)) {
				myStaffs.add(staff);
			}
		}

//		Kiểm tra xem myStaff xem nó có cuốn sách nào không, nếu có không có thì in ra thông báo là không tìm thấy
		if (myStaffs.isEmpty()) {
			System.out.println("Không tìm thấy Id.");
		} else {
			for (Staff staff : myStaffs) {
				System.out.println(staff.toString());
			}
		}
	}

	public void showSalaryDesc() {
//		In ra toàn bộ lương nhân viên toàn công ty
		for (Staff staff : staffs) {
			if (staff instanceof Employee) {
				Employee emp = (Employee) staff;
				Collections.reverse(staffs);
				System.out.println(emp);
			}
			if (staff instanceof Manager) {
				Manager manager = (Manager) staff;

				Collections.reverse(staffs);
				System.out.println(manager);
			}
		}

//		Collections.sort(staffs, Comparator.comparingLong(Staff::getSalary));
	}

	public void showSalaryAsc() {

	}

}