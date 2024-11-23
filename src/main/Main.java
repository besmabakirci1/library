package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryBookMemberLists library = new LibraryBookMemberLists();
        Scanner scanner = new Scanner(System.in);
        // Örnek veriler
        library.addBook(new Book("Suç ve Ceza", "Fyodor Dostoyevski", "123456"));
        library.addBook(new Book("Karamazov Kardeşler", "Fyodor Dostoyevski", "789101"));
        library.addUser(new User("Ahmet", 1));
        library.addUser(new User("Ayşe", 2));

        while (true) {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a User");
            System.out.println("3. Search for a Book by Title");
            System.out.println("4. Search for a Book by ISBN");
            System.out.println("5. Search for a User");
            System.out.println("6. List All Books");
            System.out.println("7. List Books by Author");
            System.out.println("8. Remove a Book");
            System.out.println("9. Remove a User");
            System.out.println("10. View User Details");
            System.out.println("11. List All Users");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer'ı temizle

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    String isbn = ISBNGenerator.generateISBN(author);
                    library.addBook(new Book(title, author, isbn));
                    System.out.println("Book added with ISBN: " + isbn);
                    break;

                case 2:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine(); // Buffer'ı temizle
                    library.addUser(new User(userName, userId));
                    break;

                case 3:
                    System.out.print("Enter the title of the book to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBookByTitle(searchTitle);
                    break;

                case 4:
                    System.out.print("Enter the ISBN of the book to search: ");
                    String searchISBN = scanner.nextLine();
                    library.searchBookByISBN(searchISBN);
                    break;

                case 5:
                    System.out.print("Enter the name of the user to search: ");
                    String searchName = scanner.nextLine();
                    library.searchUser(searchName);
                    break;

                case 6:
                    library.listBooks();
                    break;

                case 7:
                    System.out.print("Enter the author name to list all books they wrote: ");
                    String searchAuthor = scanner.nextLine();
                    library.listBooksByAuthor(searchAuthor);
                    break;

                case 8:
                    System.out.print("Enter the title of the book to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle);
                    break;

                case 9:
                    System.out.print("Enter the name of the user to remove: ");
                    String removeUserName = scanner.nextLine();
                    library.removeUser(removeUserName);
                    break;

                case 10:
                    System.out.print("Enter the name of the user to view details: ");
                    String viewUserName = scanner.nextLine();
                    User user = library.searchUser(viewUserName);
                    if (user != null) {
                        System.out.println("User Name: " + user.getName());
                        System.out.println("User ID: " + user.getUserId());
                        user.listedBorrowedBooks();
                    }
                    break;

                case 11:
                    library.listUsers();
                    break;

                case 12:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
