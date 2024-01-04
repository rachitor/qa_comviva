import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LibraryCatalogTest {

    private LibraryCatalog library;

    @BeforeEach
    void setUp() {
        library = new LibraryCatalog();
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    void addBook_BookAddedSuccessfully() {
        Book newBook = new Book("1984", "George Orwell");
        library.addBook(newBook);

        List<Book> books = library.getBooks();
        assertEquals(3, books.size());
        assertTrue(books.contains(newBook));
    }

    @Test
    void borrowBook_BookBorrowedSuccessfully() {
        library.borrowBook("The Great Gatsby");

        List<Book> books = library.getBooks();
        assertEquals(2, books.size());

        for (Book book : books) {
            if (book.getTitle().equals("The Great Gatsby")) {
                assertFalse(book.isAvailable());
            }
        }
    }

    @Test
    void returnBook_BookReturnedSuccessfully() {
        library.borrowBook("The Great Gatsby");
        library.returnBook("The Great Gatsby");

        List<Book> books = library.getBooks();
        assertEquals(2, books.size());

        for (Book book : books) {
            if (book.getTitle().equals("The Great Gatsby")) {
                assertTrue(book.isAvailable());
            }
        }
    }
}
