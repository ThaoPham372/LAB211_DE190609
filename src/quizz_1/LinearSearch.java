package quizz_1;

import java.util.Random;
import java.util.Scanner;

public class LinearSearch {
    // Attribute
    private int[] array;
    private int searchValue;
    // Constructor
    public LinearSearch(){
    }
    // Getter and Setter
    public int[] getArray() {
        return array;
    }
    public void setArray(int[] array) {
        this.array = array;
    }
    public int getSearchValue() {
        return searchValue;
    }
    public void setSearchValue(int searchValue) {
        this.searchValue = searchValue;
    }

    // Method
    private void createRandomArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(10);
        }
    }

    private void displayArray() {
        System.out.print("The array : [");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private int linearSearch(){
        for (int i = 0; i < array.length; i++){
            if (array[i] == searchValue) {
                return i;
            }
        }
        return -1;
    }

    private void performSearchAndDisplayResult() {
        int index = linearSearch();
        if (index != -1) {
            System.out.println("Found " + searchValue + " at index: " + index );
        }else {
            System.out.println(searchValue + " not found in the array.");
        }
    }

    public void run(Scanner scanner) {
        try {
            System.out.print("Enter number of array: ");
            int size = scanner.nextInt();
            if (size <= 0) {
                System.out.println("Array size must be greater than 0.");
                return;
            }
            array = new int[size];
            createRandomArray();

            scanner.nextLine();

            System.out.print("Enter search value: ");
            searchValue = scanner.nextInt();

            displayArray();
            performSearchAndDisplayResult();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine();
        }
        }
    }

