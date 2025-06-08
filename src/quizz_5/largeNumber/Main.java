package quizz_5.largeNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first large number: ");
        String num1 = sc.nextLine();

        System.out.print("Enter second large number: ");
        String num2 = sc.nextLine();

        LargeNumber ln1 = new LargeNumber(num1);
        LargeNumber ln2 = new LargeNumber(num2);

        System.out.println("Sum: " + ln1.add(ln2));
        System.out.println("Product: " + ln1.multiply(ln2));
    }
}
