package test;

import main.Book;
import main.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testBorrowBook() {
        User user = new User("Ahmet", 1);
        Book book = new Book("Savaş ve Barış", "Lev Tolstoy", "123456");

        // Kitap ödünç alınabilir durumda olmalı
        assertTrue(book.isAvailable());

        // Kullanıcı kitabı ödünç alır
        user.borrowBooks(book);

        // Kitap artık mevcut olmamalı
        assertFalse(book.isAvailable());

        // Ödünç alınan kitaplar listesinde olmalı
        List<Book> borrowedBooks = user.getBorrowedBooks();
        assertEquals(1, borrowedBooks.size());
        assertEquals(book, borrowedBooks.get(0));
    }

    @Test
    void testReturnBook() {
        User user = new User("Ayşe", 2);
        Book book = new Book("1984", "George Orwell", "654321");

        // Kitabı ödünç al
        user.borrowBooks(book);
        assertFalse(book.isAvailable());

        // Kitabı iade et
        user.returnBook(book);
        assertTrue(book.isAvailable());

        // Ödünç alınan kitaplar listesi boş olmalı
        List<Book> borrowedBooks = user.getBorrowedBooks();
        assertTrue(borrowedBooks.isEmpty());
    }

    @Test
    void testBorrowUnavailableBook() {
        User user1 = new User("Mehmet", 3);
        User user2 = new User("Fatma", 4);
        Book book = new Book("Dönüşüm", "Franz Kafka", "789101");

        // İlk kullanıcı kitabı ödünç alır
        user1.borrowBooks(book);
        assertFalse(book.isAvailable());

        // İkinci kullanıcı kitabı ödünç almaya çalışır
        user2.borrowBooks(book);

        // İkinci kullanıcı ödünç alamamalı
        assertTrue(user2.getBorrowedBooks().isEmpty());
    }

    @Test
    void testReturnBookNotBorrowed() {
        User user = new User("Ali", 5);
        Book book = new Book("Kayıp Zamanın İzinde", "Marcel Proust", "987654");

        // Kullanıcı kitabı iade etmeye çalışıyor, ancak hiç ödünç almamış
        user.returnBook(book);

        // Ödünç alınan kitaplar listesi boş olmalı
        assertTrue(user.getBorrowedBooks().isEmpty());
    }

    @Test
    void testBorrowSameBookTwice() {
        User user = new User("Akif", 6);
        Book book = new Book("On Küçük Zenci", "Agatha Christie", "111100");

        // Kullanıcı kitabı ilk kez ödünç alır
        user.borrowBooks(book);
        assertEquals(1, user.getBorrowedBooks().size());

        // Kullanıcı aynı kitabı tekrar ödünç almaya çalışır
        user.borrowBooks(book);
        assertEquals(1, user.getBorrowedBooks().size()); // Kitap listesi büyümemeli
    }

    @Test
    void testUserCannotBorrowMoreThanLimit() {
        User user = new User("Akif", 7);
        user.setMaxBorrowLimit(2); // Ödünç alma limiti

        Book book1 = new Book("On Küçük Zenci", "Agatha Christie", "111100");
        Book book2 = new Book("Cinayetler Oteli", "Agatha Christie", "111101");
        Book book3 = new Book("Doğu Ekspresinde Cinayet", "Agatha Christie", "111102");

        // Kullanıcı iki kitap ödünç alır
        user.borrowBooks(book1);
        user.borrowBooks(book2);
        assertEquals(2, user.getBorrowedBooks().size());

        // Kullanıcı üçüncü kitabı ödünç almaya çalışır
        user.borrowBooks(book3);
        assertEquals(2, user.getBorrowedBooks().size()); // Liste büyümemeli
    }

    @Test
    void testListBorrowedBooks() {
        User user = new User("Veli", 8);
        Book book1 = new Book("İnce Memed", "Yaşar Kemal", "112233");
        Book book2 = new Book("Suç ve Ceza", "Fyodor Dostoyevski", "445566");

        // Kullanıcı iki kitabı ödünç alır
        user.borrowBooks(book1);
        user.borrowBooks(book2);

        // Ödünç alınan kitaplar
        List<Book> borrowedBooks = user.getBorrowedBooks();
        assertEquals(2, borrowedBooks.size());
        assertTrue(borrowedBooks.contains(book1));
        assertTrue(borrowedBooks.contains(book2));
    }
}
