package quizz_3;

import java.util.ArrayList;
import java.util.Scanner;

public class MyStack {
    // Attribute
    private ArrayList<Integer> stackValue;

    // Constructor
    public MyStack() {
        stackValue = new ArrayList<>();
    }

    public MyStack(ArrayList<Integer> stackValue) {
        this.stackValue = stackValue;
    }

    // Getter, setter
    public ArrayList<Integer> getStackValue() {
        return stackValue;
    }

    public void setStackValue(ArrayList<Integer> stackValue) {
        this.stackValue = stackValue;
    }

    // Method
    // Hàm push
    private void push(int value) {
        stackValue.add(value);
        System.out.println("Pushed " + value + " to the stack");
    }

    //Hàm pop
    private Integer pop() {
        if (stackValue.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop");
            return null;
        }
        int topValue = stackValue.remove(stackValue.size() - 1);
        System.out.println("Popped " + topValue + " from the stack.");
        return topValue;
    }

    // Hàm get
    private Integer get() {
        if (stackValue.isEmpty()) {
            System.out.println("Stack is empty. Nothing to get.");
            return null;
        }
        int topValue = stackValue.get(stackValue.size() - 1);
        System.out.println("Top of the stack is " + topValue + ".");
        return topValue;
    }

    // Hàm chạy chương trình
    public void run(Scanner scanner) {
        while (true) {
            System.out.println("\n=== STACK MENU ===");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Get top");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Enter value to push: ");
                        int value = Integer.parseInt(scanner.nextLine());
                        push(value);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number. Try again.");
                    }
                    break;
                case "2":
                    pop();
                    break;
                case "3":
                    get();
                    break;
                case "0":
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
