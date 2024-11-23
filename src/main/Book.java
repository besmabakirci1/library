package main;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int borrowCount;
    private int maxBorrowCount;
    private List<String> borrowers; // Kullanıcı adlarını tutacak liste

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.borrowCount = 0;
        this.maxBorrowCount = 1;  // Varsayılan olarak 1 kişi ödünç alabilir
        this.borrowers = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return borrowCount < maxBorrowCount;
    }

    public void borrowBook(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            System.out.println("Error: User name cannot be empty or null.");
            return;
        }

        if (isAvailable()) {
            borrowCount++;
            borrowers.add(userName); // Kullanıcı adı listeye ekleniyor
            System.out.println(title + " borrowed by " + userName + ".");
        } else {
            System.out.println(title + " is currently unavailable for loan.");
        }
    }

    public void returnBook(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            System.out.println("Error: User name cannot be empty or null.");
            return;
        }

        if (borrowers.contains(userName)) {
            borrowCount--;
            borrowers.remove(userName);  // Kullanıcıyı listeden çıkarıyoruz
            System.out.println(title + " was returned by " + userName + ".");
        } else {
            System.out.println("Error: " + userName + " has not borrowed this book.");
        }
    }

    public List<String> getBorrowers() {
        return borrowers;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public String getAuthor() {
        return author;
    }
    public String getIsbn(){
        return isbn;
    }
}
