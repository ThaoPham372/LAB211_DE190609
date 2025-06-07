package quizz_4.teacherAndStudentManager;

import java.util.Scanner;

public class Person {
  protected String id;
  protected String fullname;
  protected String phone;
  protected int yearOfBirth;
  protected String major;

  public Person() {
    this.id = "";
    this.fullname = "";
    this.phone = "";
    this.yearOfBirth = 0;
    this.major = "";
  }

  public void inputAll(Scanner sc) {
    while (true) {
      System.out.print("ID (6 digits): ");
      id = sc.nextLine();
      if (Validation.isValidID(id))
        break;
      System.out.println("Data input is invalid");
    }
    while (true) {
      System.out.print("Fullname (alphabet and blanks): ");
      fullname = sc.nextLine();
      if (Validation.isValidFullname(fullname))
        break;
      System.out.println("Data input is invalid");
    }
    while (true) {
      System.out.print("Phone number (12 digits): ");
      phone = sc.nextLine();
      if (Validation.isValidPhone(phone))
        break;
      System.out.println("Data input is invalid");
    }
    while (true) {
      System.out.print("Year of birth (<2025): ");
      try {
        yearOfBirth = Integer.parseInt(sc.nextLine());
        if (Validation.isValidYearOfBirth(yearOfBirth))
          break;
      } catch (Exception e) {
      }
      System.out.println("Data input is invalid");
    }
    while (true) {
      System.out.print("Major (no more than 30 characters): ");
      major = sc.nextLine();
      if (Validation.isValidMajor(major))
        break;
      System.out.println("Data input is invalid");
    }
  }

  @Override
  public String toString() {
    return String.format("%-6s | %-20s | %-12s | %-4d | %-30s",
        id, fullname, phone, yearOfBirth, major);
  }

  public static String getHeader() {
    return String.format("%-6s | %-20s | %-12s | %-4s | %-30s",
        "ID", "Full Name", "Phone", "Year", "Major");
  }

  public String getFullname() {
    return fullname;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }
}
