package quizz_1;

import java.util.Random;
import java.util.Scanner;

public class BaseNumber {
    // Attributes
    private String value;
    private int inputBase;
    private int outputBase;

    // Constructor
    public BaseNumber() {
    }

    // Method chuyển từ hệ bất kỳ sang thập phân
    private int toDecimal(String val, int base) {
        val = val.toUpperCase();
        int result = 0;
        int power = 1; // Lũy thừa của cơ số, bắt đầu từ hàng đơn vị (base^0)

        for (int i = val.length() - 1; i >= 0; i--) {
            char ch = val.charAt(i);
            int digit;

            if (ch >= '0' && ch <= '9') {
                digit = ch - '0';
            } else if (ch >= 'A' && ch <= 'F') {
                digit = ch - 'A' + 10;
            } else {
                return -1;
            }

            if (digit >= base) return -1;

            result += digit * power;
            power *= base;
        }

        return result;
    }

    // Method chuyển từ thập phân sang hệ khác
    private String fromDecimal(int decimal, int base) {
        if (decimal == 0) return "0";

        String result = "";
        while (decimal > 0) {
            int remainder = decimal % base;
            char ch = (remainder < 10) ? (char) ('0' + remainder) : (char) ('A' + remainder - 10);
            result = ch + result;
            decimal /= base;
        }
        return result;
    }

    // Chuyển đổi từ hệ này sang hệ khác
    private String convert(String value, int fromBase, int toBase) {
        int decimalValue = toDecimal(value, fromBase);
        if (decimalValue == -1) return "Invalid input!";
        return fromDecimal(decimalValue, toBase);
    }

    // Hàm chạy chương trình
    public void run(Scanner scanner) {
        while (true) {
            try {
                System.out.println("\nChọn hệ cơ số đầu vào (1: Nhị phân, 2: Thập phân, 3: Thập lục phân, 0 để thoát): ");
                int inputChoice = Integer.parseInt(scanner.nextLine());
                if (inputChoice == 0) break;

                inputBase = getBaseFromChoice(inputChoice);
                if (inputBase == -1) {
                    System.out.println("Lựa chọn không hợp lệ.");
                    continue;
                }

                System.out.println("Chọn hệ cơ số đầu ra (1: Nhị phân, 2: Thập phân, 3: Thập lục phân): ");
                int outputChoice = Integer.parseInt(scanner.nextLine());
                outputBase = getBaseFromChoice(outputChoice);
                if (outputBase == -1) {
                    System.out.println("Lựa chọn không hợp lệ.");
                    continue;
                }

                System.out.print("Nhập giá trị cần chuyển đổi: ");
                value = scanner.nextLine();

                String result = convert(value, inputBase, outputBase);
                System.out.println("Kết quả chuyển đổi: " + result);
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi, vui lòng thử lại.");
            }
        }

        System.out.println("Kết thúc chương trình.");
    }

    // Chuyển lựa chọn thành cơ số thực
    private int getBaseFromChoice(int choice) {
        if (choice == 1) return 2;
        if (choice == 2) return 10;
        if (choice == 3) return 16;
        return -1;
    }
}
