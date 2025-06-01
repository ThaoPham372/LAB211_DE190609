package quizz_4.studentManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Hiển thị menu chính
            manager.showMenu();

            String choice;
            while (true) {
                System.out.print("Enter your choice (1-5): ");
                choice = sc.nextLine().trim();
                // Kiểm tra lựa chọn hợp lệ từ 1 đến 5
                if (choice.matches("[1-5]")) {
                    break;
                }
                System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }

            // Thực hiện chức năng dựa trên lựa chọn của người dùng
            switch (choice) {
                case "1":
                    manager.createStudent(); // Tạo mới sinh viên
                    break;
                case "2":
                    manager.findAndSort(); // Tìm kiếm và sắp xếp sinh viên
                    break;
                case "3":
                    manager.updateOrDelete(); // Cập nhật hoặc xóa sinh viên
                    break;
                case "4":
                    manager.report(); // Báo cáo
                    break;
                case "5":
                    System.out.println("Exiting program...");
                    sc.close(); // Đóng scanner trước khi thoát
                    return; // Kết thúc chương trình
            }
            System.out.println();
        }
    }
}
