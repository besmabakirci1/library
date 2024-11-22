package test;
import main.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BookTest {
    @Test
    void testBorrowBook(){
        Book book = new Book ("1984","George Orwell","12345");
        assertTrue(book.isAvailable()); // assertTrue metodu, JUnit testlerinde kullanılan bir assertion (doğrulama) yöntemidir. Bu metot, bir ifadenin doğru (true) olup olmadığını kontrol eder. Eğer ifade doğruysa test geçer; yanlışsa test başarısız olur ve bir hata mesajı görüntülenir.
        book.borrowBook("Ahmet");
        assertFalse(book.isAvailable());
        assertTrue(book.getBorrowers().contains("Ahmet"));
    }

    @Test
    void testReturnBook(){
        Book book = new Book("Savaş ve Barış", "Lev Tolstoy", "654321");
        // if (!book.isAvailable()) {
        //        System.out.println("Test Passed: Book is not available after borrowing.");
        //    } else {
        //        System.out.println("Test Failed: Book should not be available after borrowing.");
        //    }
        book.borrowBook("Lina");
        assertFalse(book.isAvailable());
        // if (book.isAvailable()) {
        //        System.out.println("Test Passed: Book is available after returning.");
        //    } else {
        //        System.out.println("Test Failed: Book should be available after returning.");
        //    }
        book.returnBook("Lina");
        assertTrue(book.isAvailable());
        assertFalse(book.getBorrowers().contains("Lina"));

    }

    @Test
    void testBorrowWhenNotAvailable() {
        // Kitap oluşturma
        Book book = new Book("And Then There Were None", "Agatha Christie", "789101");

        // 1. Adım: Mehmet kitabı ödünç alıyor
        book.borrowBook("Mehmet");

        // 2. Adım: Kitap mevcut olmamalı
        if (!book.isAvailable()) {
            System.out.println("Test Passed: Book is not available after borrowing.");
        } else {
            System.out.println("Test Failed: Book should not be available after borrowing.");
        }

        // 3. Adım: Mehmet kitabı ödünç almış mı?
        if (book.getBorrowers().contains("Mehmet")) {
            System.out.println("Test Passed: Mehmet is in the borrowers list.");
        } else {
            System.out.println("Test Failed: Mehmet should be in the borrowers list.");
        }

        // 4. Adım: Fatma kitabı ödünç almaya çalışıyor
        book.borrowBook("Fatma");

        // 5. Adım: Kitap hala ödünç alınamaz durumda mı?
        if (!book.isAvailable()) {
            System.out.println("Test Passed: Book is still unavailable.");
        } else {
            System.out.println("Test Failed: Book should not be available.");
        }

        // 6. Adım: Fatma ödünç alanlar listesinde olmamalı
        if (!book.getBorrowers().contains("Fatma")) {
            System.out.println("Test Passed: Fatma is not in the borrowers list.");
        } else {
            System.out.println("Test Failed: Fatma should not be in the borrowers list.");
        }
    }

}
