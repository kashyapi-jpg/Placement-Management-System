package com.placement;

public class Student {

    private int id;
    private String name;
    private String email;
    private double cgpa;
    private String branch;
    private boolean isPlaced;

    // Constructor
    public Student(int id, String name, String email, double cgpa, String branch, boolean isPlaced) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cgpa = cgpa;
        this.branch = branch;
        this.isPlaced = isPlaced;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getCgpa() { return cgpa; }
    public String getBranch() { return branch; }
    public boolean isPlaced() { return isPlaced; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }
    public void setBranch(String branch) { this.branch = branch; }
    public void setPlaced(boolean isPlaced) { this.isPlaced = isPlaced; }

    // toString
    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Email: " + email +
                " | CGPA: " + cgpa +
                " | Branch: " + branch +
                " | Placed: " + isPlaced;
    }
}