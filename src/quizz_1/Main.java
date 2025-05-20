package quizz_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Hiển thị menu
            System.out.println("\n===== MENU =====");
            System.out.println("1. Letter & Character Count");
            System.out.println("2. Linear Search");
            System.out.println("3. Change Base Number");
            System.out.println("4. Equation Program");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            // Đọc lựa chọn của người dùng
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine()); // Dùng nextLine để tránh lỗi trôi dòng
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 0 to 4.");
                continue;
            }

            // Xử lý lựa chọn
            switch (choice) {
                case 1:
                    LetterCharCount letterCharCount = new LetterCharCount();
                    letterCharCount.run(scanner);
                    break;
                case 2:
                    LinearSearch linearSearch = new LinearSearch();
                    linearSearch.run(scanner);
                    break;
                case 3:
                    BaseNumber baseNumber = new BaseNumber();
                    baseNumber.run(scanner);
                    break;
                case 4:
                    EquationProgram equationProgram = new EquationProgram();
                    equationProgram.run(scanner);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 0 to 4.");
            }
        }
    }
}


