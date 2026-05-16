package com.placement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlacementDAO {

    // CHECK ELIGIBILITY
    public boolean checkEligibility(int studentId, int companyId) {
        String query = "SELECT s.cgpa, c.min_cgpa FROM students s, companies c WHERE s.id=? AND c.id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, studentId);
            ps.setInt(2, companyId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                double studentCgpa = rs.getDouble("cgpa");
                double minCgpa = rs.getDouble("min_cgpa");

                if (studentCgpa >= minCgpa) {
                    System.out.println("✅ Student is ELIGIBLE! CGPA " + studentCgpa + " >= " + minCgpa);
                    return true;
                } else {
                    System.out.println("❌ Student is NOT eligible! CGPA " + studentCgpa + " < " + minCgpa);
                    return false;
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error checking eligibility!");
            e.printStackTrace();
        }

        return false;
    }

    // APPLY FOR JOB
    public void applyForJob(int studentId, int companyId) {
        if (!checkEligibility(studentId, companyId)) {
            System.out.println("⚠️ Application rejected due to low CGPA!");
            return;
        }

        String query = "INSERT INTO applications (student_id, company_id, status) VALUES (?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, studentId);
            ps.setInt(2, companyId);
            ps.setString(3, "Applied");

            ps.executeUpdate();
            System.out.println("✅ Application Submitted Successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Error applying for job!");
            e.printStackTrace();
        }
    }

    // VIEW ALL APPLICATIONS
    public void viewApplications() {
        String query = "SELECT a.id, s.name, c.name as company, a.status " +
                "FROM applications a " +
                "JOIN students s ON a.student_id = s.id " +
                "JOIN companies c ON a.company_id = c.id";

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("\n===== ALL APPLICATIONS =====");
            while (rs.next()) {
                System.out.println(
                        "App ID: " + rs.getInt("id") +
                                " | Student: " + rs.getString("name") +
                                " | Company: " + rs.getString("company") +
                                " | Status: " + rs.getString("status")
                );
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching applications!");
            e.printStackTrace();
        }
    }
}