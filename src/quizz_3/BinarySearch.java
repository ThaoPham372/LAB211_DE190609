package quizz_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    // Attribute
    private int[] numbers;
    private int searchValue;

    // Constructor
    public BinarySearch() {
    }

    public BinarySearch(int size) {
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

    public int getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(int searchValue) {
        this.searchValue = searchValue;
    }

    // Hàm tạo mảng ngẫu nhiên
    private void generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }
    }

    // Hàm bubble sort
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

    // Hàm binary search
    private int binarySearch(int value) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (numbers[mid] == value) {
                return mid;
            } else if (numbers[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Hàm thực hiện và in kết quả search
    private void performSearchAndResult() {
        int index = binarySearch(searchValue);
        if (index != -1) {
            System.out.println("Found " + searchValue + " at index: " + index);
        } else {
            System.out.println(searchValue + " not found in the array.");
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
                    scanner.next(); // bỏ dữ liệu không hợp lệ
                }
                System.out.print("Please enter a valid positive number: ");
            }

            // Khởi tạo mảng với kích thước hợp lệ
            numbers = new int[size];
            generateRandomArray();

            // Nhập số cần tìm
            System.out.print("Enter search value: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid integer: ");
                scanner.next();
            }
            searchValue = scanner.nextInt();

            // Sắp xếp và hiển thị mảng
            bubbleSort();
            System.out.println("Sorted array: " + Arrays.toString(numbers));

            // Tìm kiếm và hiển thị kết quả
            performSearchAndResult();

        } catch (Exception e) {
            System.out.println("An error occurred. Please restart and enter valid input.");
            scanner.nextLine();
        }
    }
}
