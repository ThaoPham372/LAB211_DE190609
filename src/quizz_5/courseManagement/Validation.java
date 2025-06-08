package quizz_5.courseManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Validation {
  // Attributes
  private static Scanner sc = new Scanner(System.in);
  private static Set<String> usedIDs = new HashSet<>();
  // Get unique ID
  public static String getUniqueID(String msg) {
    while (true) {
      System.out.print(msg);
      String id = sc.nextLine().trim();
      if (id.isEmpty() || usedIDs.contains(id)) {
        System.out.println("Data input is invalid, ID must be unique");
      } else {
        usedIDs.add(id);
        return id;
      }
    }
  }
  // Get non empty string
  public static String getNonEmptyString(String msg) {
    while (true) {
      System.out.print(msg);
      String s = sc.nextLine().trim();
      if (!s.isEmpty())
        return s;
      System.out.println("Data input is invalid");
    }
  }
  // Get positive int
  public static int getPositiveInt(String msg) {
    while (true) {
      System.out.print(msg);
      try {
        int n = Integer.parseInt(sc.nextLine().trim());
        if (n > 0)
          return n;
      } catch (Exception e) {
      }
      System.out.println("Data input is invalid");
    }
  }
  // Get date
  public static String getDate(String msg) {
    SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
    sdf.setLenient(false);
    while (true) {
      System.out.print(msg);
      String date = sc.nextLine().trim();
      try {
        sdf.parse(date);
        return date;
      } catch (ParseException e) {
        System.out.println("Data input is invalid");
      }
    }
  }
  // Get date after
  public static String getDateAfter(String msg, String begin) {
    SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
    sdf.setLenient(false);
    Date beginDate = null;
    try {
      beginDate = sdf.parse(begin);
    } catch (Exception e) {
    }
    while (true) {
      System.out.print(msg);
      String date = sc.nextLine().trim();
      try {
        Date endDate = sdf.parse(date);
        if (beginDate != null && endDate.after(beginDate))
          return date;
        else
          System.out.println("Data input is invalid, end must be after begin");
      } catch (ParseException e) {
        System.out.println("Data input is invalid");
      }
    }
  }
}
