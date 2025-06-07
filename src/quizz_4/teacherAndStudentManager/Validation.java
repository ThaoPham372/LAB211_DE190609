package quizz_4.teacherAndStudentManager;

import java.time.Year;

public class Validation {
  public static boolean isValidID(String id) {
    return id.matches("\\d{6}");
  }

  public static boolean isValidFullname(String name) {
    return name.matches("[A-Za-z ]+");
  }

  public static boolean isValidPhone(String phone) {
    return phone.matches("\\d{12}");
  }

  public static boolean isValidYearOfBirth(int year) {
    int currentYear = Year.now().getValue();
    return year < currentYear;
  }

  public static boolean isValidMajor(String major) {
    return major.length() <= 30;
  }

  public static boolean isValidYearInProfession(int yearInProfession, int age) {
    return yearInProfession >= 0 && yearInProfession < age;
  }

  public static boolean isValidContractType(String type) {
    return type.equals("Long") || type.equals("Short");
  }

  public static boolean isValidSalaryCoefficient(double coef) {
    return coef >= 0;
  }

  public static boolean isValidYearOfAdmission(int yearOfAdmission, int yearOfBirth) {
    int currentYear = Year.now().getValue();
    return yearOfAdmission > yearOfBirth && yearOfAdmission <= currentYear;
  }

  public static boolean isValidEntranceEnglishScore(int score) {
    return score >= 0 && score <= 100;
  }
}
