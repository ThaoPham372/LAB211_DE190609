package quizz_4.teacherAndStudentManager;

import java.util.Scanner;

public class Student extends Person {
  private int yearOfAdmission;
  private int entranceEnglishScore;

  public Student() {
    super();
    this.yearOfAdmission = 0;
    this.entranceEnglishScore = 0;
  }

  @Override
  public void inputAll(Scanner sc) {
    super.inputAll(sc);
    while (true) {
      System.out.print("Year of admission (from 0 to lower than age): ");
      try {
        yearOfAdmission = Integer.parseInt(sc.nextLine());
        if (Validation.isValidYearOfAdmission(yearOfAdmission, yearOfBirth))
          break;
      } catch (Exception e) {
      }
      System.out.println("Data input is invalid");
    }
    while (true) {
      System.out.print("Entrance English score: ");
      try {
        entranceEnglishScore = Integer.parseInt(sc.nextLine());
        if (Validation.isValidEntranceEnglishScore(entranceEnglishScore))
          break;
      } catch (Exception e) {
      }
      System.out.println("Data input is invalid");
    }
  }

  @Override
  public String toString() {
    return super.toString() + String.format(" | %-4d | %-3d",
        yearOfAdmission, entranceEnglishScore);
  }

  public static String getHeader() {
    return Person.getHeader() + String.format(" | %-4s | %-3s",
        "Adm", "Eng");
  }

  public int getYearOfAdmission() {
    return yearOfAdmission;
  }
}
