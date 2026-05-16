# 🎓 Placement Management System

A console-based **Placement Management System** built using **Java, JDBC, and MySQL**.

---

## 🚀 Features

- ✅ Add Student
- ✅ View All Students
- ✅ Update Student
- ✅ Delete Student
- ✅ Add Company
- ✅ View All Companies
- ✅ Eligibility Checking
- ✅ Apply For Job
- ✅ View All Applications

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Core programming language |
| JDBC | Java Database Connectivity |
| MySQL | Database to store data |
| IntelliJ IDEA | IDE for development |

---

## 📁 Project Structure
PlacementManagementSystem/
│
├── src/
│   └── com/placement/
│       ├── DBConnection.java
│       ├── Student.java
│       ├── Company.java
│       ├── StudentDAO.java
│       ├── CompanyDAO.java
│       ├── PlacementDAO.java
│       └── Main.java
│
└── lib/
└── mysql-connector-j.jar

---

## ⚙️ How to Run

1. Clone this repository
2. Import into IntelliJ IDEA
3. Add MySQL Connector JAR to project libraries
4. Create database using this SQL:

```sql
CREATE DATABASE placement_db;
USE placement_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    cgpa DOUBLE,
    branch VARCHAR(50),
    is_placed BOOLEAN DEFAULT FALSE
);

CREATE TABLE companies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    package_lpa DOUBLE,
    min_cgpa DOUBLE,
    job_role VARCHAR(100)
);

CREATE TABLE applications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    company_id INT,
    status VARCHAR(50) DEFAULT 'Applied',
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (company_id) REFERENCES companies(id)
);
```

5. Update `DBConnection.java` with your MySQL password
6. Run `Main.java`

---

## 👨‍💻 Developer

- **Name:** Your Name Here
- **Branch:** CSE
- **College:** Your College Name

---

## 📌 Concepts Used

- Object Oriented Programming (OOP)
- JDBC Connection
- DAO Design Pattern
- CRUD Operations
- SQL Joins
- Prepared Statements
