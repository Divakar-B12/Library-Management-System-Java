# 📚 Library Management System – Java + JDBC + MySQL

A simple and modular **console-based Library Management System** built with **Core Java**, **JDBC**, and **MySQL**. It allows you to manage books, members, and issue/return transactions through a menu-driven interface. Perfect for beginners to learn Java + database integration.

---

## 📝 Description

This project simulates a basic library system with functionalities such as:
- Adding and viewing books
- Adding and viewing members
- Issuing and returning books
- JDBC integration with a MySQL database
- Clean modular code using object-oriented principles

---

## 🚀 Features

- 📚 Add new books with title and author
- 👤 Register new members with name and email
- 📤 Issue books to members (only if available)
- 📥 Return books and update availability
- 📄 List all books and members
- 🛡️ Input validation and exception handling
- 🧱 Structured using OOP (modular and maintainable)

---

## 🛠️ Tech Stack

| Component     | Technology            |
|---------------|------------------------|
| Language      | Core Java              |
| Database      | MySQL                  |
| DB Access     | JDBC (Java Database Connectivity) |
| Interface     | Console (Menu-driven)  |

---

## 📁 Project Structure

LibraryManagementSystem/
├── Book.java # Book entity class
├── Member.java # Member entity class
├── DBConnection.java # MySQL connection logic
├── LibraryManager.java # Business logic for all operations
├── Main.java # Entry point with menu interface
└── schema.sql # SQL script to create necessary tables

---

## 🧑‍💻 Getting Started

### 1. Clone the Repository

git clone https://github.com/Divakar-B12/Library-Management-System-Java.git
cd Library-Management-System-Java

### 2. Set Up MySQL Database
Open your MySQL terminal or GUI (like MySQL Workbench)

Execute the schema.sql file:

sql
Copy
Edit
SOURCE path_to_project/schema.sql;
This will create a library_db with required tables: books, members, and issued_books.

### 3. Configure Database Connection
Open DBConnection.java and update the credentials:

java
Copy
Edit
private static final String URL = "jdbc:mysql://localhost:3306/library_db";
private static final String USER = "your_mysql_username";
private static final String PASSWORD = "your_mysql_password";
### 4. Compile and Run
Use any IDE (like IntelliJ or Eclipse) or run via terminal:

bash
Copy
Edit
javac *.java
java Main

