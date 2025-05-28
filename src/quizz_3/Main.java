package quizz_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Binary Search");
            System.out.println("3. Quick Sort");
            System.out.println("4. Stack Demo");
            System.out.println("0. Exit");
            System.out.print("Please choose an option: ");

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
                    BubbleSort bubbleSort = new BubbleSort();
                    bubbleSort.run(scanner);
                    break;
                case 2:
                    BinarySearch binarySearch = new BinarySearch();
                    binarySearch.run(scanner);
                    break;
                case 3:
                    QuickSort quickSort = new QuickSort();
                    quickSort.run(scanner);
                    break;
                case 4:
                    MyStack myStack = new MyStack();
                    myStack.run(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
