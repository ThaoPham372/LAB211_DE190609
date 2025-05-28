package quizz_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    // Attribute
    private int[] numbers;

    // Constructor
    public BubbleSort() {
    }

    public BubbleSort(int size) {
        numbers = new int[size];
        generateRandomArray();
    }

    // Getter, setter
    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    // Hàm tạo mảng random
    private void generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10); // từ 0 -> 9
        }
    }

    // Hàm Bubble Sort
    private void bubbleSort() {
        int n = numbers.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // swap
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    // Hàm chạy chương trình
    public void run(Scanner scanner) {
        try {
            System.out.print("Enter number of array: ");
            int size = scanner.nextInt();
            if (size <= 0) {
                System.out.println("Array size must be greater than 0.");
                return;
            }
            numbers = new int[size];
            generateRandomArray();
            scanner.nextLine();

            System.out.print("Unsorted array: " + Arrays.toString(numbers));

            bubbleSort();

            System.out.println("\nSorted array: " + Arrays.toString(numbers));
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine();
        }
    }
}


