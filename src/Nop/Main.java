package Nop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        ClassDAO classDAO = new ClassDAO();

        while (true) {
            System.out.println("\n1. Thêm sinh viên");
            System.out.println("2. Hiển thị tất cả sinh viên");
            System.out.println("3. Thêm sinh viên vào lớp");
            System.out.println("4. Hiển thị sinh viên trong lớp");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập email: ");
                    String email = scanner.nextLine();
                    System.out.print("Nhập GPA: ");
                    float gpa = scanner.nextFloat();

                    Student student = new Student(0, name, age, email, gpa);
                    studentDAO.addStudent(student);
                    System.out.println("Thêm sinh viên thành công!");
                    break;

                case 2:
                    for (Student s : studentDAO.getAllStudents()) {
                        System.out.println(s.getStudentID() + " - " + s.getName() + " - " + s.getEmail() + " - GPA: " + s.getGpa());
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID sinh viên: ");
                    int studentID = scanner.nextInt();
                    System.out.print("Nhập ID lớp học: ");
                    int classID = scanner.nextInt();
                    classDAO.addStudentToClass(studentID, classID);
                    System.out.println("Thêm vào lớp thành công!");
                    break;

                case 4:
                    System.out.print("Nhập ID lớp học: ");
                    int classID2 = scanner.nextInt();
                    for (Student s : classDAO.getStudentsInClass(classID2)) {
                        System.out.println(s.getStudentID() + " - " + s.getName() + " - " + s.getEmail() + " - GPA: " + s.getGpa());
                    }
                    break;

                case 5:
                    System.out.println("Thoát!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
