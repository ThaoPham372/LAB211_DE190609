package quizz_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PerimeterAndAreaCalculation {
    // Lớp trừu tượng Shape định nghĩa các phương thức bắt buộc phải có ở các hình cụ thể
    abstract class Shape {
        public abstract double getPerimeter(); // Tính chu vi

        public abstract double getArea();      // Tính diện tích

        public abstract void printResult();    // In kết quả
    }

    // Lớp Rectangle kế thừa Shape, đại diện cho hình chữ nhật
    class Rectangle extends Shape {
        private double width;  // Chiều rộng
        private double length; // Chiều dài

        public Rectangle(double width, double length) {
            this.width = width;
            this.length = length;
        }

        @Override
        public double getPerimeter() {
            return 2 * (width + length); // Công thức chu vi hình chữ nhật
        }

        @Override
        public double getArea() {
            return width * length;        // Công thức diện tích hình chữ nhật
        }

        @Override
        public void printResult() {
            System.out.println("-----Rectangle-----");
            System.out.println("Width: " + width);
            System.out.println("Length: " + length);
            System.out.println("Area: " + getArea());
            System.out.println("Perimeter: " + getPerimeter());
        }
    }

    // Lớp Circle kế thừa Shape, đại diện cho hình tròn
    class Circle extends Shape {
        private double radius; // Bán kính

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius; // Chu vi hình tròn
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius; // Diện tích hình tròn
        }

        @Override
        public void printResult() {
            System.out.println("-----Circle-----");
            System.out.println("Radius: " + radius);
            System.out.println("Area: " + getArea());
            System.out.println("Perimeter: " + getPerimeter());
        }
    }

    // Lớp Triangle kế thừa Shape, đại diện cho tam giác
    class Triangle extends Shape {
        private double sideA; // Cạnh A
        private double sideB; // Cạnh B
        private double sideC; // Cạnh C

        public Triangle(double sideA, double sideB, double sideC) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }

        @Override
        public double getPerimeter() {
            return sideA + sideB + sideC; // Chu vi tam giác là tổng 3 cạnh
        }

        @Override
        public double getArea() {
            // Công thức Heron tính diện tích tam giác theo 3 cạnh
            double s = getPerimeter() / 2; // Nửa chu vi
            return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        }

        @Override
        public void printResult() {
            System.out.println("-----Triangle-----");
            System.out.println("Side A: " + sideA);
            System.out.println("Side B: " + sideB);
            System.out.println("Side C: " + sideC);
            System.out.printf("Area: %.2f\n", getArea()); // In diện tích với 2 chữ số thập phân
            System.out.println("Perimeter: " + getPerimeter());
        }
    }

    // Phương thức run nhận đối tượng Scanner để nhập dữ liệu
    public void run(Scanner scanner) {
        System.out.println("=====Calculator Shape Program=====");

        // Nhập từng thông số, đảm bảo là số thực dương hợp lệ
        double width = inputPositiveDouble(scanner, "Please input side width of Rectangle: ");
        double length = inputPositiveDouble(scanner, "Please input length of Rectangle: ");
        double radius = inputPositiveDouble(scanner, "Please input radius of Circle: ");
        double sideA = inputPositiveDouble(scanner, "Please input side A of Triangle: ");
        double sideB = inputPositiveDouble(scanner, "Please input side B of Triangle: ");
        double sideC = inputPositiveDouble(scanner, "Please input side C of Triangle: ");

        // Tạo đối tượng các hình
        Rectangle rectangle = new Rectangle(width, length);
        Circle circle = new Circle(radius);
        Triangle triangle = new Triangle(sideA, sideB, sideC);

        // In kết quả cho từng hình
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }

    // Hàm nhập số thực dương, kiểm tra lỗi nhập sai và nhập lại nếu cần
    private double inputPositiveDouble(Scanner scanner, String message) {
        double value;
        while (true) {
            System.out.print(message);
            try {
                value = scanner.nextDouble();
                if (value <= 0) {
                    System.out.println("Giá trị phải lớn hơn 0, vui lòng nhập lại.");
                    continue; // Yêu cầu nhập lại nếu không đúng điều kiện
                }
                break; // Thoát vòng lặp khi nhập đúng
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: vui lòng nhập số hợp lệ.");
                scanner.next(); // Bỏ dữ liệu sai để nhập lại
            }
        }
        return value;
    }
}
