package main;
import java.util.ArrayList;
import java.util.List;
// user_name , ID , and books that has borrowed by him / her.
public class User {
    private String name ;
    private int userId;
    private List<Book> borrowedBooks;
    public User(String name, int userId){
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public int getUserId(){
        return userId;
    }
    public void borrowBooks(Book book){
        if(book.isAvailable()){
            book.borrowBook();
            borrowedBooks.add(book);
        }else {
            System.out.println(book.getTitle() + "currently unavailable for loan.");
        }
    }
    public void returnBook(Book book){
        if(borrowedBooks.contains(book)){
            book.returnBook();
            borrowedBooks.remove(book);
        }else {
            System.out.println(book.getTitle() + "has not been borrowed by this user." );
        }
    }
    public void listedBorrowedBooks(){
        System.out.println(" books borrowed by "+ name );
        for (Book book: borrowedBooks){
            System.out.println("- " + book.getTitle());
        }
    }
    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

}
