package Nop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    public void addStudentToClass(int studentID, int classID) {
        String sql = "INSERT INTO Learn (StudentID, ClassID) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentID);
            stmt.setInt(2, classID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm sinh viên vào lớp: " + e.getMessage());
        }
    }

    public List<Student> getStudentsInClass(int classID) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT s.StudentID, s.Name, s.Age, s.Email, s.GPA " +
                "FROM Student s " +
                "JOIN Learn l ON s.StudentID = l.StudentID " +
                "WHERE l.ClassID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, classID);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    students.add(new Student(
                            rs.getInt("StudentID"),
                            rs.getString("Name"),
                            rs.getInt("Age"),
                            rs.getString("Email"),
                            rs.getFloat("GPA")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách sinh viên trong lớp: " + e.getMessage());
        }
        return students;
    }
}
