package quizz_5.courseManagement;

public class OnlineCourse extends Course {
  private String platform;
  private String instructors;
  private String note;

  public OnlineCourse() {
    // Constructors
    super();
    this.platform = "";
    this.instructors = "";
    this.note = "";
  }
  // Overloaded constructor
  public OnlineCourse(String courseID, String courseName, int credits, String platform, String instructors,
      String note) {
    super(courseID, courseName, credits);
    this.platform = platform;
    this.instructors = instructors;
    this.note = note;
  }

  // Getters and setters
  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }

  public String getInstructors() {
    return instructors;
  }

  public void setInstructors(String instructors) {
    this.instructors = instructors;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
  // Input all
  @Override
  public void inputAll() {
    super.inputAll();
    this.platform = Validation.getNonEmptyString("Platform: ");
    this.instructors = Validation.getNonEmptyString("Instructors: ");
    this.note = Validation.getNonEmptyString("Note: ");
  }
  // To string
  @Override
  public String toString() {
    return super.toString() + "-" + platform + "-" + instructors + "-" + note;
  }
}
