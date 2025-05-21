package quizz_2;

import java.util.Scanner;

public class ComputerProgram {
    // Enum để xác định các toán tử hợp lệ
    enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, POWER, EQUAL
    }

    // Enum để xác định trạng thái BMI
    enum BMIStatus {
        UNDER_STANDARD, STANDARD, OVERWEIGHT, FAT, VERY_FAT
    }

    // Lớp BMI để lưu kết quả BMI và trạng thái
    class BMI {
        double value;
        BMIStatus status;

        public BMI(double value, BMIStatus status) {
            this.value = value;
            this.status = status;
        }
    }

    // Phương thức kiểm tra chuỗi có phải là số hợp lệ hay không
    public Double checkIsNumber(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }

    // Phương thức kiểm tra toán tử nhập vào
    public Operator checkOperator(String operator) {
        return switch (operator) {
            case "+" -> Operator.ADD;
            case "-" -> Operator.SUBTRACT;
            case "*" -> Operator.MULTIPLY;
            case "/" -> Operator.DIVIDE;
            case "^" -> Operator.POWER;
            case "=" -> Operator.EQUAL;
            default -> null;
        };
    }

    // Hàm tính toán hai số với toán tử cho trước
    public double calculate(double a, Operator operator, double b) {
        return switch (operator) {
            case ADD -> a + b;
            case SUBTRACT -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> (b == 0) ? Double.NaN : a / b;
            case POWER -> Math.pow(a, b);
            default -> a;
        };
    }

    // Tính chỉ số BMI từ cân nặng và chiều cao
    public BMI calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100;
        double bmiValue = weight / (heightM * heightM);
        BMIStatus status;
        if (bmiValue < 19) status = BMIStatus.UNDER_STANDARD;
        else if (bmiValue < 25) status = BMIStatus.STANDARD;
        else if (bmiValue < 30) status = BMIStatus.OVERWEIGHT;
        else if (bmiValue < 40) status = BMIStatus.FAT;
        else status = BMIStatus.VERY_FAT;
        return new BMI(bmiValue, status);
    }

    // Chương trình chính được gọi từ lớp khác
    public void run(Scanner scanner) {
        while (true) {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.print("Please choice one option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> runNormalCalculator(scanner);
                case "2" -> runBMICalculator(scanner);
                case "3" -> {
                    System.out.println("Exiting program. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    // Phương thức chạy máy tính cơ bản
    public void runNormalCalculator(Scanner scanner) {
        System.out.println("----- Normal Calculator -----");
        double memory = 0;
        boolean first = true;
        Operator currentOperator = null;

        while (true) {
            Double num = null;
            while (num == null) {
                System.out.print("Enter number: ");
                num = checkIsNumber(scanner.nextLine());
                if (num == null) System.out.println("Invalid number. Please try again.");
            }

            if (first) {
                memory = num;
                first = false;
            } else {
                memory = calculate(memory, currentOperator, num);
                System.out.println("Memory: " + memory);
            }

            currentOperator = null;
            while (currentOperator == null) {
                System.out.print("Enter Operator: ");
                currentOperator = checkOperator(scanner.nextLine());
                if (currentOperator == null)
                    System.out.println("Please input (+, -, *, /, ^, =)");
            }

            if (currentOperator == Operator.EQUAL) {
                System.out.println("Result: " + memory);
                break;
            }
        }
    }

    // Phương thức chạy tính chỉ số BMI
    public void runBMICalculator(Scanner scanner) {
        System.out.println("----- BMI Calculator -----");
        Double weight = null;
        while (weight == null) {
            System.out.print("Enter Weight(kg): ");
            weight = checkIsNumber(scanner.nextLine());
            if (weight == null) System.out.println("BMI is digit");
        }

        Double height = null;
        while (height == null) {
            System.out.print("Enter Height(cm): ");
            height = checkIsNumber(scanner.nextLine());
            if (height == null) System.out.println("BMI is digit");
        }

        BMI bmi = calculateBMI(weight, height);
        System.out.printf("BMI Number: %.2f\n", bmi.value);
        System.out.println("BMI Status: " + bmi.status);
    }
}
