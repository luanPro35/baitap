package Nop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private int studentID;

    public void addStudent(Student student) {
        String sql = "INSERT INTO Student (Name, Age, Email, GPA) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getEmail());
            stmt.setFloat(4, student.getGpa());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                studentID = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm sinh viên: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("StudentID"),
                        rs.getString("Name"),
                        rs.getInt("Age"),
                        rs.getString("Email"),
                        rs.getFloat("GPA")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách sinh viên: " + e.getMessage());
        }
        return students;
    }
}
