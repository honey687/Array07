import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String rollNumber;
    private String name;
    private int marks;
    private String course;

    public Student(String rollNumber, String name, int marks, String course) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
        this.course = course;
    }

 
    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public String getCourse() {
        return course;
    }

   
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", marks: " + marks + ", Course: " + course;
    }
}

public class Array {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Update Student Information");
            System.out.println("5. Delete Student by Roll Number");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter marks: ");
        int marks = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        Student newStudent = new Student(rollNumber, name, marks, course);
        studentList.add(newStudent);
        System.out.println("Student added successfully!");
    }

    private static void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        System.out.println("\n--- All Students ---");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        String rollNumber = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getRollNumber().equals(rollNumber)) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    private static void updateStudent() {
        System.out.print("Enter Roll Number of student to update: ");
        String rollNumber = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getRollNumber().equals(rollNumber)) {
                System.out.print("Enter new Name (leave blank to keep current): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    student.setName(newName);
                }

                System.out.print("Enter new marks (0 to keep current): ");
                int newMarks = scanner.nextInt();
                scanner.nextLine(); 
                if (newMarks != 0) {
                    student.setMarks(newMarks);
                }

                System.out.print("Enter new Course (leave blank to keep current): ");
                String newCourse = scanner.nextLine();
                if (!newCourse.isEmpty()) {
                    student.setCourse(newCourse);
                }
                System.out.println("Student information updated successfully!");
                return;
            }
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter Roll Number of student to delete: ");
        String rollNumber = scanner.nextLine();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getRollNumber().equals(rollNumber)) {
                studentList.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }
}