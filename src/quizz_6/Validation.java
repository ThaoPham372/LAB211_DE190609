package quizz_6;

import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    // Nhập số nguyên từ min đến max, kiểm tra lỗi nhập liệu
    public static int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n < min || n > max) {
                    System.out.println("Please enter number between " + min + " and " + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Nhập số thực từ min đến max, kiểm tra lỗi nhập liệu
    public static double getDouble(String msg, double min, double max) {
        while (true) {
            try {
                System.out.print(msg);
                double n = Double.parseDouble(sc.nextLine().trim());
                if (n < min || n > max) {
                    System.out.println("Please enter number between " + min + " and " + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Nhập chuỗi không rỗng, không cho phép toàn là số (ví dụ dùng cho tên, quốc gia,...)
    public static String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("Input cannot be empty.");
            } else if (s.matches("\\d+")) {
                System.out.println("Input cannot be all numbers."); // Ví dụ: "123" là không hợp lệ
            } else {
                return s;
            }
        }
    }

    // Nhập ID hoặc chuỗi bất kỳ (chỉ kiểm tra không rỗng), cho phép cả số nếu cần
    public static String getStringID(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty.");
        }
    }

    // Nhập lựa chọn chỉ cho phép Y hoặc N (không phân biệt hoa thường)
    public static String getYesNo(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim().toUpperCase(); // chuyển về in hoa để so sánh
            if (s.equals("Y") || s.equals("N")) return s;
            System.out.println("Please input Y or N only.");
        }
    }
}
