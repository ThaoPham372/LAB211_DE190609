package quizz_5.courseManagement;

public class OfflineCourse extends Course {
  private String begin;
  private String end;
  private String campus;

  public OfflineCourse() {
    // Default constructor
    super();
    this.begin = "";
    this.end = "";
    this.campus = "";
  }
  // Overloaded constructor
  public OfflineCourse(String courseID, String courseName, int credits, String begin, String end, String campus) {
    super(courseID, courseName, credits);
    this.begin = begin;
    this.end = end;
    this.campus = campus;
  }

  // Getters and setters
  public String getBegin() {
    return begin;
  }

  public void setBegin(String begin) {
    this.begin = begin;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public String getCampus() {
    return campus;
  }

  public void setCampus(String campus) {
    this.campus = campus;
  }
  // Input all
  @Override
  public void inputAll() {
    super.inputAll();
    this.begin = Validation.getDate("Begin (dd/MM/yyyy): ");
    this.end = Validation.getDateAfter("End (dd/MM/yyyy): ", begin);
    this.campus = Validation.getNonEmptyString("Campus: ");
  }
  // To string
  @Override
  public String toString() {
    return super.toString() + "-" + begin + "-" + end + "-" + campus;
  }
}
