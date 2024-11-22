package test;

import main.Book;
import main.User;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testBorrowBook() {
        // Kullanıcı ve Kitap oluşturma
        User user = new User("Ahmet", 1);
        Book book = new Book("Savaş ve Barış", "Lev Tolstoy", "123456");

        // Kullanıcı kitabı ödünç alıyor
        user.borrowBooks(book);

        // Ödünç alınan kitaplar listesi kontrol edilir
        List<Book> borrowedBooks = user.getBorrowedBooks();
        assertEquals(1, borrowedBooks.size());
        assertEquals(book, borrowedBooks.get(0));
    }

    @Test
    void testReturnBook() {
        // Kullanıcı ve Kitap oluşturma
        User user = new User("Ayşe", 2);
        Book book = new Book("1984", "George Orwell", "654321");

        // Kitap ödünç alınır ve sonra iade edilir
        user.borrowBooks(book);
        user.returnBook(book);

        // Kitap iade edildiği için listede olmamalı
        List<Book> borrowedBooks = user.getBorrowedBooks();
        assertTrue(borrowedBooks.isEmpty());
    }

    @Test
    void testBorrowUnavailableBook() {
        // Kullanıcı ve Kitap oluşturma
        User user1 = new User("Mehmet", 3);
        User user2 = new User("Fatma", 4);
        Book book = new Book("Dönüşüm", "Franz Kafka", "789101");

        // İlk kullanıcı kitabı ödünç alıyor
        user1.borrowBooks(book);

        // İkinci kullanıcı kitabı ödünç almaya çalışıyor, ama kitap mevcut değil
        user2.borrowBooks(book);

        // Kitabın hala sadece ilk kullanıcı tarafından ödünç alındığı kontrol ediliyor
        List<Book> borrowedBooksUser1 = user1.getBorrowedBooks();
        List<Book> borrowedBooksUser2 = user2.getBorrowedBooks();

        assertEquals(1, borrowedBooksUser1.size()); // Mehmet kitabı almış olmalı
        assertTrue(borrowedBooksUser2.isEmpty());   // Fatma kitabı alamamış olmalı
    }

    @Test
    void testReturnBookNotBorrowed() {
        // Kullanıcı ve Kitap oluşturma
        User user = new User("Ali", 5);
        Book book = new Book("Kayıp Zamanın İzinde", "Marcel Proust", "987654");

        // Kullanıcı kitabı iade etmeye çalışıyor, ancak hiç ödünç almamıştı
        user.returnBook(book); // Konsolda uyarı mesajı basılacak

        // Kitap listesinde herhangi bir kitap olmamalı
        List<Book> borrowedBooks = user.getBorrowedBooks();
        assertTrue(borrowedBooks.isEmpty());
    }

    @Test
    void testListBorrowedBooks() {
        // Kullanıcı ve Kitap oluşturma
        User user = new User("Veli", 6);
        Book book1 = new Book("İnce Memed", "Yaşar Kemal", "112233");
        Book book2 = new Book("Suç ve Ceza", "Fyodor Dostoyevski", "445566");

        // Kullanıcı iki kitabı ödünç alır
        user.borrowBooks(book1);
        user.borrowBooks(book2);

        // Ödünç alınan kitapları listeleme
        user.listedBorrowedBooks(); // Konsolda "Veli tarafından ödünç alınan kitaplar:" gösterilmeli

        // Kitapların ödünç alındığını doğrula
        List<Book> borrowedBooks = user.getBorrowedBooks();
        assertEquals(2, borrowedBooks.size());
        assertTrue(borrowedBooks.contains(book1));
        assertTrue(borrowedBooks.contains(book2));
    }
}
