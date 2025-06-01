package quizz_4.studentManagement;

import java.util.*;

public class StudentManager {
    private ArrayList<Student> studentList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Hiển thị menu chức năng chính của chương trình
    public void showMenu(){
        System.out.println("---------- STUDENT MANAGEMENT ----------");
        System.out.println("1. Create Student");
        System.out.println("2. Find and Sort Student");
        System.out.println("3. Update or Delete Student");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }

    // Tạo mới sinh viên, yêu cầu nhập ID, tên, học kỳ, khóa học
    // Nếu đã nhập từ 3 sinh viên trở lên thì hỏi người dùng có muốn tiếp tục không
    public void createStudent() {
        while (true) {
            System.out.println("------ Create Student ------");

            String id = Validation.getUniqueID(studentList);
            String name = Validation.getNonEmptyString("Enter name: ");
            String semester = Validation.getNonEmptyString("Enter semester: ");
            String course = Validation.getValidCourse();

            studentList.add(new Student(id, name, semester, course));
            System.out.println("Student created successfully!");

            if (studentList.size() >= 3) {
                if (!Validation.askYesNo("Do you want to continue adding student? (Y/N): ")) {
                    break;
                }
            }
        }
    }

    // Tìm kiếm sinh viên theo tên, không phân biệt hoa thường
    // Sau đó sắp xếp theo tên (tăng dần) và in ra danh sách kết quả tìm được
    public void findAndSort() {
        System.out.println("------ Find and Sort Student ------");

        String keyword = Validation.getNonEmptyString("Enter student name to search: ").toLowerCase();

        List<Student> found = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getName().toLowerCase().contains(keyword)) {
                found.add(s);
            }
        }

        if (found.isEmpty()) {
            System.out.println("No student found with that name.");
        } else {
            found.sort(Comparator.comparing(s -> s.getName().toLowerCase()));

            System.out.println("Search results:");
            System.out.printf("%-20s %-10s %-10s\n", "Name", "Semester", "Course");
            for (Student s : found) {
                System.out.println(s.toSimpleString());
            }
        }
    }

    // Cập nhật hoặc xóa sinh viên theo ID
    // Nếu tìm thấy sinh viên, cho người dùng chọn cập nhật (U) hoặc xóa (D)
    public void updateOrDelete() {
        System.out.println("------ Update or Delete Student ------");

        if (studentList.isEmpty()) {
            System.out.println("No students available to update or delete.");
            return;
        }

        System.out.println("---------- Current student list ----------");
        for (Student s : studentList) {
            System.out.println(s.toString());
        }

        String id = Validation.getNonEmptyString("Enter student ID to search: ");
        boolean found = false;

        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);

            if (s.getId().equalsIgnoreCase(id)) {
                found = true;
                System.out.println("Student found:");
                System.out.println(s.toSimpleString());

                String choice = Validation.getNonEmptyString("Do you want to update (U) or delete (D)? ");

                if (choice.equalsIgnoreCase("U")) {
                    // Cập nhật thông tin mới cho sinh viên
                    String newName = Validation.getNonEmptyString("Enter new name: ");
                    String newSemester = Validation.getNonEmptyString("Enter new semester: ");
                    String newCourse = Validation.getValidCourse();

                    s.setName(newName);
                    s.setSemester(newSemester);
                    s.setCourseName(newCourse);

                    System.out.println("Student updated successfully.");
                } else if (choice.equalsIgnoreCase("D")) {
                    // Xóa sinh viên khỏi danh sách
                    studentList.remove(i);
                    System.out.println("Student deleted successfully.");
                } else {
                    System.out.println("Invalid choice. Operation cancelled.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("No student found with that ID.");
        }
    }

    // Báo cáo tổng số lần mỗi sinh viên học mỗi khóa học
    // Hiển thị theo định dạng: tên, khóa học, tổng số lần
    public void report() {
        if (studentList.isEmpty()) {
            System.out.println("No student data to report.");
            return;
        }

        System.out.println("------ REPORT ------");
        Map<String, Integer> reportMap = new LinkedHashMap<>();

        for (Student s : studentList) {
            String key = s.getName() + "|" + s.getCourseName();
            reportMap.put(key, reportMap.getOrDefault(key, 0) + 1);
        }

        System.out.printf("%-20s | %-10s | %-5s\n", "Student Name", "Course", "Total");
        System.out.println("---------------------+------------+-------");

        for (String key : reportMap.keySet()) {
            String[] parts = key.split("\\|");
            String name = parts[0];
            String course = parts[1];
            int total = reportMap.get(key);

            System.out.printf("%-20s | %-10s | %-5d\n", name, course, total);
        }
    }
}
