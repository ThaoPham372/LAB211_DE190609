package quizz_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    // Attribute
    private int[] numbers;

    // Contructor
    public QuickSort() {
    }

    public QuickSort(int size) {
        numbers = new int[size];
        generateRandomArray();

    }

    // Getter Setter
    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    // Hàm tạo mảng ngẫu nhiên
    private void generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }
    }

    // Hàm chia mảng ra thành 2 phần
    private int partition(int low, int high) {
        int pivot = numbers[(low + high) / 2];
        int i = low;
        int j = high;

        while (i <= j) {
            while (numbers[i] < pivot) i++;
            while (numbers[j] > pivot) j--;
            if (i <= j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

    // Hàm quicksort
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex, high);
        }
    }

    // Hàm chạy chương trình
    public void run(Scanner scanner) {
        int size;
        try {
            // Nhập số phần tử
            System.out.print("Enter number of array: ");
            while (true) {
                if (scanner.hasNextInt()) {
                    size = scanner.nextInt();
                    if (size > 0) break;
                } else {
                    scanner.next();
                }
                System.out.print("Please enter a valid positive number: ");
            }

            // Khởi tạo mảng với kích thước hợp lệ
            numbers = new int[size];
            generateRandomArray();

            System.out.println("Unsorted array: " + Arrays.toString(numbers));

            quickSort(0, numbers.length - 1);
            System.out.println("Sorted array: " + Arrays.toString(numbers));
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine();
        }
    }
}
