package main;

import main.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryBookMemberLists {
    private List<Book> books;
    private List<User> users;
    public LibraryBookMemberLists(){
        books = new ArrayList<>();
        users = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
        System.out.println(book.getTitle() + " added to library.");
    }
    public void addUser(User user){
        users.add(user);
        System.out.println(user.getName() + " became a member of the library.");
    }
    public void listBooks(){
        System.out.println("The books that are in the library :");
        for (Book book : books){
            System.out.println("-" + book.getTitle() + " (" + (book.isAvailable() ? "Available" : "On loan") + ")");
        }
    }
}
