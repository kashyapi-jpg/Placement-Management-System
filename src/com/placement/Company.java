package com.placement;

public class Company {

    private int id;
    private String name;
    private double packageLpa;
    private double minCgpa;
    private String jobRole;

    // Constructor
    public Company(int id, String name, double packageLpa, double minCgpa, String jobRole) {
        this.id = id;
        this.name = name;
        this.packageLpa = packageLpa;
        this.minCgpa = minCgpa;
        this.jobRole = jobRole;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPackageLpa() { return packageLpa; }
    public double getMinCgpa() { return minCgpa; }
    public String getJobRole() { return jobRole; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPackageLpa(double packageLpa) { this.packageLpa = packageLpa; }
    public void setMinCgpa(double minCgpa) { this.minCgpa = minCgpa; }
    public void setJobRole(String jobRole) { this.jobRole = jobRole; }

    // toString
    @Override
    public String toString() {
        return "ID: " + id +
                " | Company: " + name +
                " | Package: " + packageLpa + " LPA" +
                " | Min CGPA: " + minCgpa +
                " | Role: " + jobRole;
    }
}