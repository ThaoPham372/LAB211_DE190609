package quizz_1;

import java.util.*;

public class EquationProgram {
    // Attributes
    private float a;
    private float b;
    private float c;

    // Constructor
    public EquationProgram() {
    }

    public EquationProgram(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //  Getter & Setter
    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    // Hàm chạy chương trình
    public void run(Scanner scanner) {
        while (true) {
            System.out.println("======= Equation Program ========");
            System.out.println("1. Calculate Superlative Equation");
            System.out.println("2. Calculate Quadratic Equation");
            System.out.println("3. Return Main Menu");
            System.out.print("Please choice one option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    inputAB(scanner);
                    calculateEquation();
                    displayNumberProperties(a, b);
                    break;
                case "2":
                    inputABC(scanner);
                    calculateQuadraticEquation();
                    displayNumberProperties(a, b, c);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Hàm nhập
    public void inputAB(Scanner scanner) {
        a = inputFloat(scanner, "Enter A: ");
        b = inputFloat(scanner, "Enter B: ");
    }

    public void inputABC(Scanner scanner) {
        a = inputFloat(scanner, "Enter A: ");
        b = inputFloat(scanner, "Enter B: ");
        c = inputFloat(scanner, "Enter C: ");
    }

    public float inputFloat(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input number.");
            }
        }
    }

    // Giải phương trình
    public void calculateEquation() {
        System.out.println("----- Calculate Equation -----");
        if (a == 0 && b == 0) {
            System.out.println("Infinitely many solutions.");
        } else if (a == 0) {
            System.out.println("No solution.");
        } else {
            float x = -b / a;
            System.out.println("Solution: x = " + x);
        }
    }

    // Hàm tính toán phương trình
    public void calculateQuadraticEquation() {
        System.out.println("----- Calculate Quadratic Equation -----");
        if (a == 0) {
            calculateEquation(); // bậc nhất
            return;
        }

        float delta = b * b - 4 * a * c;
        if (delta < 0) {
            System.out.println("No solution.");
        } else if (delta == 0) {
            float x = -b / (2 * a);
            System.out.println("Solution: x1 = x2 = " + x);
        } else {
            float sqrtDelta = (float) Math.sqrt(delta);
            float x1 = (-b + sqrtDelta) / (2 * a);
            float x2 = (-b - sqrtDelta) / (2 * a);
            System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
        }
    }

    // Hàm display
    public void displayNumberProperties(float... numbers) {
        // Tạo danh sách lưu các số lẻ, số chẵn, số chính phương
        List<Float> oddNumbers = new ArrayList<>();
        List<Float> evenNumbers = new ArrayList<>();
        List<Float> perfectSquares = new ArrayList<>();

        // Duyệt từng số trong dãy đầu vào
        for (float num : numbers) {
            if (isOdd(num)) {
                oddNumbers.add(num);
            }
            if (isEven(num)) {
                evenNumbers.add(num);
            }
            if (isPerfectSquare(num)) {
                perfectSquares.add(num);
            }
        }

        // In ra kết quả
        System.out.println("Odd Numbers: " + oddNumbers);
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Perfect Squares: " + perfectSquares);
    }

    // Kiểm tra số lẻ
    public boolean isOdd(float number) {
        if (number % 1 != 0) return false; // Không phải số nguyên
        return ((int) number) % 2 != 0;
    }

    // Kiểm tra số chẵn
    public boolean isEven(float number) {
        if (number % 1 != 0) return false; // Không phải số nguyên
        return ((int) number) % 2 == 0;
    }

    // Kiểm tra số chính phương
    public boolean isPerfectSquare(float number) {
        if (number < 0 || number % 1 != 0) return false; // Không phải số nguyên dương
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == (int) number;
    }

}
