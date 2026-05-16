package com.placement;

import java.util.List;
import java.util.Scanner;

public class Main {

    static StudentDAO studentDAO = new StudentDAO();
    static CompanyDAO companyDAO = new CompanyDAO();
    static PlacementDAO placementDAO = new PlacementDAO();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice = 0;

        while (choice != 9) {
            printMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: addCompany(); break;
                case 6: viewCompanies(); break;
                case 7: applyForJob(); break;
                case 8: placementDAO.viewApplications(); break;
                case 9: System.out.println("👋 Goodbye!"); break;
                default: System.out.println("⚠️ Invalid choice!"); break;
            }
        }
    }

    // PRINT MENU
    static void printMenu() {
        System.out.println("\n=============================");
        System.out.println("  PLACEMENT MANAGEMENT SYSTEM");
        System.out.println("=============================");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Add Company");
        System.out.println("6. View All Companies");
        System.out.println("7. Apply For Job");
        System.out.println("8. View All Applications");
        System.out.println("9. Exit");
        System.out.println("=============================");
        System.out.print("Enter your choice: ");
    }

    // ADD STUDENT
    static void addStudent() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        Student s = new Student(0, name, email, cgpa, branch, false);
        studentDAO.addStudent(s);
    }

    // VIEW STUDENTS
    static void viewStudents() {
        List<Student> students = studentDAO.getAllStudents();
        System.out.println("\n===== ALL STUDENTS =====");
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // UPDATE STUDENT
    static void updateStudent() {
        viewStudents();
        System.out.print("\nEnter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New Email: ");
        String email = sc.nextLine();
        System.out.print("Enter New CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter New Branch: ");
        String branch = sc.nextLine();
        System.out.print("Is Placed? (true/false): ");
        boolean isPlaced = sc.nextBoolean();
        sc.nextLine();

        Student s = new Student(id, name, email, cgpa, branch, isPlaced);
        studentDAO.updateStudent(s);
    }

    // DELETE STUDENT
    static void deleteStudent() {
        viewStudents();
        System.out.print("\nEnter Student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        studentDAO.deleteStudent(id);
    }

    // ADD COMPANY
    static void addCompany() {
        System.out.print("Enter Company Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Package (LPA): ");
        double packageLpa = sc.nextDouble();
        System.out.print("Enter Minimum CGPA Required: ");
        double minCgpa = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Job Role: ");
        String jobRole = sc.nextLine();

        Company c = new Company(0, name, packageLpa, minCgpa, jobRole);
        companyDAO.addCompany(c);
    }

    // VIEW COMPANIES
    static void viewCompanies() {
        List<Company> companies = companyDAO.getAllCompanies();
        System.out.println("\n===== ALL COMPANIES =====");
        if (companies.isEmpty()) {
            System.out.println("No companies found!");
        } else {
            for (Company c : companies) {
                System.out.println(c);
            }
        }
    }

    // APPLY FOR JOB
    static void applyForJob() {
        viewStudents();
        System.out.print("\nEnter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine();
        viewCompanies();
        System.out.print("\nEnter Company ID: ");
        int companyId = sc.nextInt();
        sc.nextLine();
        placementDAO.applyForJob(studentId, companyId);
    }
}