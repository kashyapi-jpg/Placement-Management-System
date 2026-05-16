package com.placement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {

    // ADD COMPANY
    public void addCompany(Company company) {
        String query = "INSERT INTO companies (name, package_lpa, min_cgpa, job_role) VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, company.getName());
            ps.setDouble(2, company.getPackageLpa());
            ps.setDouble(3, company.getMinCgpa());
            ps.setString(4, company.getJobRole());

            ps.executeUpdate();
            System.out.println("✅ Company Added Successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Error adding company!");
            e.printStackTrace();
        }
    }

    // VIEW ALL COMPANIES
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        String query = "SELECT * FROM companies";

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Company c = new Company(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("package_lpa"),
                        rs.getDouble("min_cgpa"),
                        rs.getString("job_role")
                );
                companies.add(c);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching companies!");
            e.printStackTrace();
        }

        return companies;
    }

    // UPDATE COMPANY
    public void updateCompany(Company company) {
        String query = "UPDATE companies SET name=?, package_lpa=?, min_cgpa=?, job_role=? WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, company.getName());
            ps.setDouble(2, company.getPackageLpa());
            ps.setDouble(3, company.getMinCgpa());
            ps.setString(4, company.getJobRole());
            ps.setInt(5, company.getId());

            ps.executeUpdate();
            System.out.println("✅ Company Updated Successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Error updating company!");
            e.printStackTrace();
        }
    }

    // DELETE COMPANY
    public void deleteCompany(int id) {
        String query = "DELETE FROM companies WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Company Deleted Successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Error deleting company!");
            e.printStackTrace();
        }
    }
}