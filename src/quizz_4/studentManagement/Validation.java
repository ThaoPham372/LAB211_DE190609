package quizz_4.studentManagement;

import java.util.List;
import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    // Kiểm tra xem ID đã tồn tại trong danh sách sinh viên chưa
    private static boolean isDuplicateID(List<Student> students, String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) return true;
        }
        return false;
    }

    // Yêu cầu nhập ID và kiểm tra không được trống, không được trùng với ID đã có
    public static String getUniqueID(List<Student> students) {
        while (true) {
            System.out.print("Enter ID: ");
            String id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("ID cannot be empty."); // ID không được để trống
            } else if (isDuplicateID(students, id)) {
                System.out.println("This ID already exists."); // ID đã tồn tại
            } else {
                return id; // ID hợp lệ và chưa có trong danh sách
            }
        }
    }

    // Yêu cầu nhập chuỗi không được để trống, hiển thị thông báo msg
    public static String getNonEmptyString(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input; // Trả về chuỗi hợp lệ
            }
            System.out.println("Input cannot be empty."); // Không được để trống
        }
    }

    // Yêu cầu nhập tên khóa học hợp lệ (Java, .Net hoặc C/C++)
    public static String getValidCourse() {
        while (true) {
            System.out.print("Enter course (Java/.Net/C/C++): ");
            String course = sc.nextLine().trim();
            if (course.equalsIgnoreCase("Java") ||
                    course.equalsIgnoreCase(".Net") ||
                    course.equalsIgnoreCase("C/C++")) {
                return course; // Khóa học hợp lệ
            }
            System.out.println("Course must be Java, .Net, or C/C++."); // Thông báo lỗi nếu nhập sai
        }
    }

    // Hỏi người dùng có tiếp tục hay không (Y/N), trả về true nếu chọn Y
    public static boolean askYesNo(String msg) {
        System.out.print(msg);
        String ans = sc.nextLine().trim();
        return ans.equalsIgnoreCase("Y");
    }
}
