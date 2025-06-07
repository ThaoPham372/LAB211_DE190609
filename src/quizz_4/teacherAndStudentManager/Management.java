package quizz_4.teacherAndStudentManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Management {
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("*** Information Management ***");
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            System.out.println("3. Person");
            System.out.println("4. Exit");
            System.out.print("You choose: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    teacherMenu();
                    break;
                case "2":
                    studentMenu();
                    break;
                case "3":
                    personMenu();
                    break;
                case "4":
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void teacherMenu() {
        while (true) {
            System.out.println("*** Teacher Management ***");
            System.out.println("1. Input\n2. Print\n3. Exit");
            System.out.print("You choose: ");
            String tChoice = sc.nextLine();

            switch (tChoice) {
                case "1":
                    Teacher t = new Teacher();
                    t.inputAll(sc);
                    teachers.add(t);
                    break;
                case "2":
                    System.out.println(Teacher.getHeader());
                    teachers.stream()
                            .sorted((a, b) -> b.getYearInProfession() - a.getYearInProfession())
                            .forEachOrdered(System.out::println);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void studentMenu() {
        while (true) {
            System.out.println("*** Student Management ***");
            System.out.println("1. Input\n2. Print\n3. Exit");
            System.out.print("You choose: ");
            String sChoice = sc.nextLine();

            switch (sChoice) {
                case "1":
                    Student s = new Student();
                    s.inputAll(sc);
                    students.add(s);
                    break;
                case "2":
                    System.out.println(Student.getHeader());
                    students.stream()
                            .sorted(Comparator.comparingInt(Student::getYearOfAdmission))
                            .forEachOrdered(System.out::println);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void personMenu() {
        while (true) {
            System.out.println("*** Person Management ***");
            System.out.println("1. Search\n2. Print all\n3. Exit");
            System.out.print("You choose: ");
            String pChoice = sc.nextLine();

            switch (pChoice) {
                case "1":
                    System.out.print("Name: ");
                    String name = sc.nextLine().toLowerCase();
                    List<Person> found = new ArrayList<>();
                    for (Teacher t : teachers)
                        if (t.getFullname().toLowerCase().contains(name))
                            found.add(t);
                    for (Student s : students)
                        if (s.getFullname().toLowerCase().contains(name))
                            found.add(s);
                    if (found.isEmpty()) {
                        System.out.println("Result: not found");
                    } else {
                        System.out.println(Teacher.getHeader());
                        found.stream()
                                .sorted((a, b) -> b.getYearOfBirth() - a.getYearOfBirth())
                                .forEachOrdered(System.out::println);
                    }
                    break;
                case "2":
                    List<Person> all = new ArrayList<>();
                    all.addAll(teachers);
                    all.addAll(students);
                    System.out.println(Teacher.getHeader());
                    all.stream()
                            .sorted((a, b) -> b.getYearOfBirth() - a.getYearOfBirth())
                            .forEachOrdered(System.out::println);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
