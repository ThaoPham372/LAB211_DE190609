package quizz_4.teacherAndStudentManager;

import java.util.Scanner;

public class Teacher extends Person {
  private int yearInProfession;
  private String contractType;
  private double salaryCoefficient;

  public Teacher() {
    super();
    this.yearInProfession = 0;
    this.contractType = "";
    this.salaryCoefficient = 0.0;
  }

  @Override
  public void inputAll(Scanner sc) {
    super.inputAll(sc);
    int currentYear = java.time.Year.now().getValue();
    int age = currentYear - yearOfBirth;

    while (true) {
      System.out.print("Year in the profession (from 0 to lower than age): ");
      try {
        yearInProfession = Integer.parseInt(sc.nextLine());
        if (Validation.isValidYearInProfession(yearInProfession, age))
          break;
      } catch (Exception e) {
      }
      System.out.println("Data input is invalid");
    }
    while (true) {
      System.out.print("Contract type (Long or Short): ");
      contractType = sc.nextLine();
      if (Validation.isValidContractType(contractType))
        break;
      System.out.println("Data input is invalid");
    }
    while (true) {
      System.out.print("Salary coefficient (from 0): ");
      try {
        salaryCoefficient = Double.parseDouble(sc.nextLine());
        if (Validation.isValidSalaryCoefficient(salaryCoefficient))
          break;
      } catch (Exception e) {
      }
      System.out.println("Data input is invalid");
    }
  }

  @Override
  public String toString() {
    return super.toString() + String.format(" | %-4d | %-6s | %-8.2f",
        yearInProfession, contractType, salaryCoefficient);
  }

  public static String getHeader() {
    return Person.getHeader() + String.format(" | %-4s | %-6s | %-8s",
        "Exp", "Contract", "Salary Coef");
  }

  public int getYearInProfession() {
    return yearInProfession;
  }
}
