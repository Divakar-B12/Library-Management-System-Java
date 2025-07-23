import java.sql.*;
import java.util.*;

public class LibraryManager {

    public void addBook(String title, String author) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, title);
                ps.setString(2, author);
                ps.executeUpdate();
                System.out.println("Book added successfully.");
            }
        }
    }

    public void addMember(String name, String email) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO members (name, email) VALUES (?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, email);
                ps.executeUpdate();
                System.out.println("Member added successfully.");
            }
        }
    }

    public void issueBook(int bookId, int memberId) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String checkAvailability = "SELECT available FROM books WHERE id = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkAvailability)) {
                checkStmt.setInt(1, bookId);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && !rs.getBoolean("available")) {
                    System.out.println("Book is already issued.");
                    return;
                }
            }

            String issueSql = "INSERT INTO issued_books (book_id, member_id, issue_date) VALUES (?, ?, CURDATE())";
            try (PreparedStatement ps = conn.prepareStatement(issueSql)) {
                ps.setInt(1, bookId);
                ps.setInt(2, memberId);
                ps.executeUpdate();
            }

            String updateSql = "UPDATE books SET available = FALSE WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                ps.setInt(1, bookId);
                ps.executeUpdate();
            }

            System.out.println("Book issued successfully.");
        }
    }

    public void returnBook(int bookId) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String updateIssue = "UPDATE issued_books SET return_date = CURDATE() WHERE book_id = ? AND return_date IS NULL";
            try (PreparedStatement ps = conn.prepareStatement(updateIssue)) {
                ps.setInt(1, bookId);
                ps.executeUpdate();
            }

            String updateBook = "UPDATE books SET available = TRUE WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(updateBook)) {
                ps.setInt(1, bookId);
                ps.executeUpdate();
            }

            System.out.println("Book returned successfully.");
        }
    }

    public void listBooks() throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Book book = new Book(rs.getInt("id"), rs.getString("title"),
                            rs.getString("author"), rs.getBoolean("available"));
                    System.out.println(book);
                }
            }
        }
    }

    public void listMembers() throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM members";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Member member = new Member(rs.getInt("id"),
                            rs.getString("name"), rs.getString("email"));
                    System.out.println(member);
                }
            }
        }
    }
}