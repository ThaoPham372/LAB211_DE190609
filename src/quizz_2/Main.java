package quizz_2;

import quizz_1.BaseNumber;
import quizz_1.EquationProgram;
import quizz_1.LetterCharCount;
import quizz_1.LinearSearch;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Hiển thị menu
            System.out.println("\n===== MENU =====");
            System.out.println("1. Calculator Program");
            System.out.println("2. Computer Program");
            System.out.println("3. Calculate Perimeter and Area");
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
                    CalculatorProgram calculatorProgram = new CalculatorProgram();
                    calculatorProgram.run(scanner);
                    break;
                case 2:
                    ComputerProgram computerProgram = new ComputerProgram();
                    computerProgram.run(scanner);
                    break;
                case 3:
                    PerimeterAndAreaCalculation perimeterAndAreaCalculation = new PerimeterAndAreaCalculation();
                    perimeterAndAreaCalculation.run(scanner);
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

