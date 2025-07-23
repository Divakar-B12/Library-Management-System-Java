import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Books");
            System.out.println("6. List Members");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter author: ");
                        String author = sc.nextLine();
                        manager.addBook(title, author);
                        break;
                    case 2:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        manager.addMember(name, email);
                        break;
                    case 3:
                        System.out.print("Enter Book ID: ");
                        int bookId = sc.nextInt();
                        System.out.print("Enter Member ID: ");
                        int memberId = sc.nextInt();
                        manager.issueBook(bookId, memberId);
                        break;
                    case 4:
                        System.out.print("Enter Book ID: ");
                        int returnBookId = sc.nextInt();
                        manager.returnBook(returnBookId);
                        break;
                    case 5:
                        manager.listBooks();
                        break;
                    case 6:
                        manager.listMembers();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}