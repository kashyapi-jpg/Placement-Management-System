package com.placement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student student) {
        String query = "INSERT INTO students (name, email, cgpa, branch, is_placed) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setDouble(3, student.getCgpa());
            ps.setString(4, student.getBranch());
            ps.setBoolean(5, student.isPlaced());

            ps.executeUpdate();
            System.out.println("✅ Student Added Successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Error adding student!");
            e.printStackTrace();
        }
    }
    // VIEW ALL STUDENTS
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("cgpa"),
                        rs.getString("branch"),
                        rs.getBoolean("is_placed")
                );
                students.add(s);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching students!");
            e.printStackTrace();
        }

        return students;
    }
    // UPDATE STUDENT
    public void updateStudent(Student student) {
        String query = "UPDATE students SET name=?, email=?, cgpa=?, branch=?, is_placed=? WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setDouble(3, student.getCgpa());
            ps.setString(4, student.getBranch());
            ps.setBoolean(5, student.isPlaced());
            ps.setInt(6, student.getId());

            ps.executeUpdate();
            System.out.println("✅ Student Updated Successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Error updating student!");
            e.printStackTrace();
        }
    }
    // DELETE STUDENT
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Student Deleted Successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Error deleting student!");
            e.printStackTrace();
        }
    }
}