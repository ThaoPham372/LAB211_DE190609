package quizz_5.courseManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManager {
  // Attributes
  private ArrayList<Course> courses = new ArrayList<>();
  private Scanner sc = new Scanner(System.in);
  // Run
  public void run() {
    while (true) {
      System.out.println("*** Course Management ***");
      System.out.println("1. Add online course/ offline course");
      System.out.println("2. Update course");
      System.out.println("3. Delete course");
      System.out.println("4. Print all / online course / offline course");
      System.out.println("5. Search information base on course name");
      System.out.println("6. Exit");
      System.out.print("You choose: ");
      String choice = sc.nextLine().trim();
      switch (choice) {
        case "1":
          addCourse();
          break;
        case "2":
          updateCourse();
          break;
        case "3":
          deleteCourse();
          break;
        case "4":
          printCourses();
          break;
        case "5":
          searchCourse();
          break;
        case "6":
          System.out.println("BYE AND SEE YOU NEXT TIME");
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }
  // Add course
  private void addCourse() {
    System.out.println("*** Add new course ***");
    String type;
    while (true) {
      System.out.print("Online (O) or Offline (F): ");
      type = sc.nextLine().trim();
      if (type.equalsIgnoreCase("O")) {
        OnlineCourse oc = new OnlineCourse();
        oc.inputAll();
        courses.add(oc);
        break;
      } else if (type.equalsIgnoreCase("F")) {
        OfflineCourse ofc = new OfflineCourse();
        ofc.inputAll();
        courses.add(ofc);
        break;
      } else {
        System.out.println("Data input is invalid");
      }
    }
  }
  // Update course
  private void updateCourse() {
    System.out.println("*** Update course ***");
    while (true) {
      System.out.print("Course ID: ");
      String id = sc.nextLine().trim();
      Course found = null;
      for (Course c : courses) {
        if (c.getCourseID().equalsIgnoreCase(id)) {
          found = c;
          break;
        }
      }
      if (found == null) {
        System.out.print("No data found, do you want to find again? (Y/N): ");
        String again = sc.nextLine().trim();
        if (again.equalsIgnoreCase("Y")) {
          continue;
        } else {
          return;
        }
      } else {
        // Show old info
        System.out.println("*** Search results ***");
        System.out.println("Course ID: " + found.getCourseID());
        System.out.println("Course name: " + found.getCourseName());
        System.out.println("Credits: " + found.getCredits());
        if (found instanceof OnlineCourse) {
          OnlineCourse oc = (OnlineCourse) found;
          System.out.println("Platform: " + oc.getPlatform());
          System.out.println("Instructors: " + oc.getInstructors());
          System.out.println("Note: " + oc.getNote());
        } else if (found instanceof OfflineCourse) {
          OfflineCourse ofc = (OfflineCourse) found;
          System.out.println("Begin: " + ofc.getBegin());
          System.out.println("End: " + ofc.getEnd());
          System.out.println("Campus: " + ofc.getCampus());
        }
        System.out.println("*** Updating ***");
        System.out.println("Note: Enter empty if you don't want to change it.");

        // Update fields, keep old if empty
        System.out.print("Course ID: ");
        String newID = sc.nextLine().trim();
        if (!newID.isEmpty())
          found.setCourseID(newID);

        System.out.print("Course name: ");
        String newName = sc.nextLine().trim();
        if (!newName.isEmpty())
          found.setCourseName(newName);

        System.out.print("Credits: ");
        String newCredits = sc.nextLine().trim();
        if (!newCredits.isEmpty()) {
          try {
            int credits = Integer.parseInt(newCredits);
            if (credits > 0)
              found.setCredits(credits);
          } catch (Exception e) {
            // ignore, keep old value
          }
        }

        if (found instanceof OnlineCourse) {
          OnlineCourse oc = (OnlineCourse) found;
          System.out.print("Platform: ");
          String platform = sc.nextLine().trim();
          if (!platform.isEmpty())
            oc.setPlatform(platform);

          System.out.print("Instructors: ");
          String instructors = sc.nextLine().trim();
          if (!instructors.isEmpty())
            oc.setInstructors(instructors);

          System.out.print("Note: ");
          String note = sc.nextLine().trim();
          if (!note.isEmpty())
            oc.setNote(note);
        } else if (found instanceof OfflineCourse) {
          OfflineCourse ofc = (OfflineCourse) found;
          System.out.print("Begin: ");
          String begin = sc.nextLine().trim();
          if (!begin.isEmpty())
            ofc.setBegin(begin);

          System.out.print("End: ");
          String end = sc.nextLine().trim();
          if (!end.isEmpty())
            ofc.setEnd(end);

          System.out.print("Campus: ");
          String campus = sc.nextLine().trim();
          if (!campus.isEmpty())
            ofc.setCampus(campus);
        }
        System.out.println("Updated successfully");
        return;
      }
    }
  }
  // Delete course
  private void deleteCourse() {
    System.out.println("*** Delete course ***");
    while (true) {
      System.out.print("Course ID: ");
      String id = sc.nextLine().trim();
      Course found = null;
      for (Course c : courses) {
        if (c.getCourseID().equalsIgnoreCase(id)) {
          found = c;
          break;
        }
      }
      if (found == null) {
        System.out.print("No data found, do you want to find again? (Y/N): ");
        String again = sc.nextLine().trim();
        if (again.equalsIgnoreCase("Y")) {
          continue;
        } else {
          return;
        }
      } else {
        courses.remove(found);
        System.out.println("Deleted successfully");
        return;
      }
    }
  }
  // Print courses
  private void printCourses() {
    System.out.print("Do you want to print all (A), online course (O) or offline course (F): ");
    String type = sc.nextLine().trim();
    for (Course c : courses) {
      if (type.equalsIgnoreCase("A") ||
          (type.equalsIgnoreCase("O") && c instanceof OnlineCourse) ||
          (type.equalsIgnoreCase("F") && c instanceof OfflineCourse)) {
        System.out.println(c);
      }
    }
  }
  // Search course    
  private void searchCourse() {
    System.out.println("*** Searching ***");
    while (true) {
      System.out.print("Course ID: ");
      String id = sc.nextLine().trim();
      Course found = null;
      for (Course c : courses) {
        if (c.getCourseID().equalsIgnoreCase(id)) {
          found = c;
          break;
        }
      }
      if (found == null) {
        System.out.print("No data found, do you want to find again? (Y/N): ");
        String again = sc.nextLine().trim();
        if (again.equalsIgnoreCase("Y")) {
          continue;
        } else {
          return;
        }
      } else {
        System.out.println("*** Search results ***");
        System.out.println("Course ID: " + found.getCourseID());
        System.out.println("Course name: " + found.getCourseName());
        System.out.println("Credits: " + found.getCredits());
        if (found instanceof OnlineCourse) {
          OnlineCourse oc = (OnlineCourse) found;
          System.out.println("Platform: " + oc.getPlatform());
          System.out.println("Instructors: " + oc.getInstructors());
          System.out.println("Note: " + oc.getNote());
        } else if (found instanceof OfflineCourse) {
          OfflineCourse ofc = (OfflineCourse) found;
          System.out.println("Begin: " + ofc.getBegin());
          System.out.println("End: " + ofc.getEnd());
          System.out.println("Campus: " + ofc.getCampus());
        }
        return;
      }
    }
  }
}
