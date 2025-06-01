package quizz_4.studentManagement;

public class Student {
    // Attribute
    private String id;
    private String name;
    private String semester;
    private String courseName;

    // Constructor
    public Student() {
    }
    public Student(String id, String name, String semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    // Getter Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // Method
    @Override
    public String toString() {
        // Dùng khi cần đầy đủ thông tin (cập nhật/xóa)
        return String.format("ID: %s | Name: %s | Semester: %s | Course: %s",
                id, name, semester, courseName);
    }

    public String toSimpleString() {
        // Dùng khi KHÔNG cần ID (ví dụ: report, tìm kiếm)
        return String.format("Name: %s | Semester: %s | Course: %s",
                name, semester, courseName);
    }
}
