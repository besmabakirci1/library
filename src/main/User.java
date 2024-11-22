package main;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int userId;
    private List<Book> borrowedBooks;
    private int maxBorrowLimit = 5; // Varsayılan ödünç alma sınırı

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters ve Setters
    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getMaxBorrowLimit() {
        return maxBorrowLimit;
    }

    public void setMaxBorrowLimit(int maxBorrowLimit) {
        this.maxBorrowLimit = maxBorrowLimit;
    }

    // Kitap Ödünç Alma
    public void borrowBooks(Book book) {
        if (borrowedBooks.size() >= maxBorrowLimit) {
            System.out.println("You have reached the maximum borrow limit.");
            return;
        }

        if (borrowedBooks.contains(book)) {
            System.out.println("You have already borrowed this book: " + book.getTitle());
            return;
        }

        if (book.isAvailable()) {
            book.borrowBook(this.name);
            borrowedBooks.add(book);
            System.out.println(name + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is currently unavailable for loan.");
        }
    }

    // Kitap İade Etme
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook(this.name);
            borrowedBooks.remove(book);
            System.out.println(this.name + " returned the book: " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " has not been borrowed by " + this.name + ".");
        }
    }

    // Ödünç Alınan Kitapları Listeleme
    public void listedBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }
}
