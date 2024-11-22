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
    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) { // Kitap adı eşleşiyor mu?
                System.out.println("The book has found: " + book.getTitle());

                if (book.isAvailable()) { // Kitap mevcut mu?
                    System.out.println("Durum: Mevcut");
                } else {
                    System.out.println("Durum: Ödünçte");
                    for (User user : users) {
                        if (user.getBorrowedBooks().contains(book)) { // Kitap kimde?
                            System.out.println("Bu kitap şu anda " + user.getName() + " tarafından ödünç alınmış.");
                            return;
                        }
                    }
                }
                return; // Kitap bulundu, işlemi sonlandır
            }
        System.out.println("Kitap bulunamadı."); // Hiçbir kitap eşleşmedi
         }
    }
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        System.out.println(title + " has been removed from the library.");
    }

    public void removeUser(String name) {
        users.removeIf(user -> user.getName().equalsIgnoreCase(name));
        System.out.println(name + " has been removed from the library.");
    }
}
