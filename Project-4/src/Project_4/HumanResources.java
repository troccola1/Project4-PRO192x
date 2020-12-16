package Project_4;

import java.util.Scanner;

public class HumanResources {
	static Scanner scan;

	public static void main(String[] args) {
		try {
			Service service = new Service();
			scan = new Scanner(System.in);
			int choice = 0;
			boolean isRunning = true;
			System.out.println("Chào mừng các bạn đến với ứng dụng quản lý nguồn nhân lực Human Resources.");

			while (isRunning) {
				try {
					System.out.println("----------------------------------------------------------------------------------------------------");
					System.out.println("1. Danh sách nhân viên có trong công ty.");
					System.out.println("2. Các bộ phận trong công ty.");
					System.out.println("3. Các nhân viên theo từng bộ phận.");
					System.out.println("4. Thêm nhân viên mới.");
					System.out.println("5. Tìm kiếm thông tin nhân viên bằng mã nhân viên.");
					System.out.println("6. Bảng lương nhân viên toàn công ty.");
					System.out.println("7. Hiển thị bảng lương nhân viên theo thứ tự tăng dần.");
					System.out.println("8. Lối ra.");
					System.out.print("Lựa chọn của bạn: ");

					if (scan.hasNextInt()) {
						choice = scan.nextInt();
						switch (choice) {
						case 1:
							service.displayStaff();
							break;
						case 2:
							service.displayDepartment();
							break;
						case 3:
							service.displayStaffByDepartment();
							break;
						case 4:
							service.addStaff();
							break;
						case 5:
							String searchId = scan.next();
							service.search(searchId);
							break;
						case 6:
							service.showSalaryDesc();
							break;
						case 7:
							service.showSalaryAsc();
							break;
						case 8:
							isRunning = false;
							break;
						}
					} else {
						scan.nextLine();
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
