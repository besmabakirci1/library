package main;

import java.util.ArrayList;
import java.util.List;

public class LibraryBookMemberLists {
    private List<Book> books;
    private List<User> users;

    public LibraryBookMemberLists() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Kitap ekleme
    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " added to library.");
    }

    // Kullanıcı ekleme
    public void addUser(User user) {
        users.add(user);
        System.out.println(user.getName() + " became a member of the library.");
    }

    // Kitap listeleme
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println("The books that are in the library:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
        }
    }

    public void listUsers(){
        if(users.isEmpty()){
            System.out.println("No users available in the library.");
            return;
        }
        System.out.println("The users registered in the library: ");
        for(User user : users){
            System.out.println("- " + user.getName() + "(ID: " + user.getUserId() + ")" );
        }
    }



    // Yazara göre kitapları listeleme
    public void listBooksByAuthor(String author) {
        boolean found = false;
        System.out.println("Books written by " + author + ":");
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("- " + book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by the author: " + author);
        }
    }

    // Başlığa göre kitap arama
    public void searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("The book has been found: " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }

    // ISBN'e göre kitap arama
    public void searchBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println("The book has been found: " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
                return;
            }
        }
        System.out.println("Book not found with ISBN: " + isbn);
    }

    // Kullanıcı arama
    public User searchUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                System.out.println("User found: " + user.getName() + " (ID: " + user.getUserId() + ")");
                return user;
            }
        }
        System.out.println("User not found: " + name);
        return null;
    }

    // Kitap silme
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        System.out.println(title + " has been removed from the library.");
    }

    // Kullanıcı silme
    public void removeUser(String name) {
        users.removeIf(user -> user.getName().equalsIgnoreCase(name));
        System.out.println(name + " has been removed from the library.");
    }
}
