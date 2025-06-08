package quizz_5.reservationManagement;

public class Validation {
  public static boolean isValidID(String id) {
    return id.matches("\\d{6}");
  }

  public static boolean isValidName(String name) {
    return name.matches("[A-Za-z ]+");
  }

  public static boolean isValidPhone(String phone) {
    return phone.matches("\\d{12}");
  }

  public static boolean isValidRoom(String room) {
    return room.matches("\\d{4}");
  }
}
