package quizz_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorProgram {
    private int row;         // số hàng của ma trận
    private int column;      // số cột của ma trận
    private int[][] data;    // mảng 2 chiều lưu dữ liệu ma trận

    // Constructor: tạo ma trận với kích thước row x column
    public CalculatorProgram(int row, int column) {
        this.row = row;
        this.column = column;
        data = new int[row][column];
    }

    public CalculatorProgram() {
    }

    // Gán giá trị tại vị trí (i, j)
    public void setValue(int i, int j, int value) {
        data[i][j] = value;
    }

    // Lấy số hàng
    public int getRow() {
        return row;
    }

    // Lấy số cột
    public int getColumn() {
        return column;
    }

    // Hiển thị ma trận
    public void displayMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(data[i][j] + "\t"); // in phần tử, cách nhau bằng tab
            }
            System.out.println(); // xuống dòng sau mỗi hàng
        }
    }

    // Cộng hai ma trận
    public CalculatorProgram additionMatrix(CalculatorProgram m2) {
        CalculatorProgram result = new CalculatorProgram(row, column);
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                result.data[i][j] = this.data[i][j] + m2.data[i][j];
        return result;
    }

    // Trừ hai ma trận
    public CalculatorProgram subtractionMatrix(CalculatorProgram m2) {
        CalculatorProgram result = new CalculatorProgram(row, column);
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                result.data[i][j] = this.data[i][j] - m2.data[i][j];
        return result;
    }

    // Nhân hai ma trận
    public CalculatorProgram multiplicationMatrix(CalculatorProgram m2) {
        CalculatorProgram result = new CalculatorProgram(this.row, m2.column);
        for (int i = 0; i < this.row; i++)
            for (int j = 0; j < m2.column; j++)
                for (int k = 0; k < this.column; k++)
                    result.data[i][j] += this.data[i][k] * m2.data[k][j];
        return result;
    }

    // Nhập số nguyên an toàn (kiểm tra lỗi nhập liệu)
    private int getIntInput(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();  // cố gắng đọc số nguyên
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer! Please try again.");
                scanner.next(); // bỏ qua dữ liệu sai
            }
        }
    }

    // Nhập ma trận với số hàng và cột đã biết trước
    public CalculatorProgram inputMatrix(Scanner sc, String name, int row, int column) {
        System.out.println("Enter matrix " + name + " [" + row + " rows x " + column + " columns]:");
        CalculatorProgram matrix = new CalculatorProgram(row, column);
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                int value = getIntInput(sc, "Enter " + name + "[" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix.setValue(i, j, value);
            }
        return matrix;
    }

    // Nhập ma trận cho phép người dùng nhập kích thước
    public CalculatorProgram inputMatrix(Scanner sc, String name) {
        int row = getIntInput(sc, "Enter number of rows for " + name + ": ");
        int col = getIntInput(sc, "Enter number of columns for " + name + ": ");
        return inputMatrix(sc, name, row, col);
    }

    // Chạy menu chương trình chính
    public void run(Scanner scanner) {
        while (true) {
            System.out.println("\n====== Calculator Program ======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            int choice = getIntInput(scanner, "");

            if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("------ ADD MATRICES ------");
                    CalculatorProgram a1 = inputMatrix(scanner, "Matrix 1");
                    CalculatorProgram a2 = inputMatrix(scanner, "Matrix 2", a1.getRow(), a1.getColumn());
                    CalculatorProgram sum = a1.additionMatrix(a2);
                    System.out.println("----------Result----------");
                    sum.displayMatrix();
                    break;

                case 2:
                    System.out.println("------ SUBTRACT MATRICES ------");
                    CalculatorProgram s1 = inputMatrix(scanner, "Matrix 1");
                    CalculatorProgram s2 = inputMatrix(scanner, "Matrix 2", s1.getRow(), s1.getColumn());
                    CalculatorProgram diff = s1.subtractionMatrix(s2);
                    System.out.println("----------Result----------");
                    diff.displayMatrix();
                    break;

                case 3:
                    System.out.println("------ MULTIPLY MATRICES ------");
                    CalculatorProgram m1 = inputMatrix(scanner, "Matrix 1");
                    int col2 = getIntInput(scanner, "Enter number of columns for Matrix 2: ");
                    CalculatorProgram m2 = inputMatrix(scanner, "Matrix 2", m1.getColumn(), col2);
                    CalculatorProgram product = m1.multiplicationMatrix(m2);
                    System.out.println("----------Result----------");
                    product.displayMatrix();
                    break;

                default:
                    System.out.println("Invalid choice. Please select from 1 to 4.");
            }
        }
    }
}
