package quizz_5.courseManagement;

public class Course {
  // Attributes
  protected String courseID;
  protected String courseName;
  protected int credits;
  // Constructors
  public Course() {
    this.courseID = "";
    this.courseName = "";
    this.credits = 0;
  }
  // Overloaded constructor
  public Course(String courseID, String courseName, int credits) {
    this.courseID = courseID;
    this.courseName = courseName;
    this.credits = credits;
  }

  // Getters and setters
  public String getCourseID() {
    return courseID;
  }

  public void setCourseID(String courseID) {
    this.courseID = courseID;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }
  // Input all
  public void inputAll() {
    this.courseID = Validation.getUniqueID("Course ID: ");
    this.courseName = Validation.getNonEmptyString("Course name: ");
    this.credits = Validation.getPositiveInt("Credits: ");
  }
  // To string
  public String toString() {
    return courseID + "-" + courseName + "-" + credits;
  }
}
