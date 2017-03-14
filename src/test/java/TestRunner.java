import dao.*;
import dao.impl.*;
import db.CSVReader;
import model.*;
import org.junit.*;

import java.io.IOException;
import java.util.*;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by jaouhar.mbarek on 13.03.2017.
 */
public class TestRunner {

    // Initialize
    @BeforeClass
    public static void before() {

    }

    // Check if  buecher.csv file can be read properly.
    @Test
    public void readBooksFromCSVFileTest() {
        //Arrange
        // The header is composed from the column-names e.g. "Emailadresse;Vorname;Nachname"
        List<Book> booksWithHeader = null;
        //Act
        try {
            booksWithHeader = CSVReader.readBooksFromCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Assert
        assertNotNull("the response is null", booksWithHeader);
        assertTrue("the size of the returned Books is wrong", booksWithHeader.size() == 12);
        assertEquals(booksWithHeader.get(1).getTitle(), "titleTest");
        assertEquals(booksWithHeader.get(1).getDescription(), "added description to test");
        assertEquals(booksWithHeader.get(1).getIsbn(), "999-999-999");
        assertTrue("Field \"Authors\" is not like expected", booksWithHeader.get(1).getAuthorEmails().contains("test@test.de"));
    }

    // Check if zeitschriften.csv file can be read properly.
    @Test
    public void readMagazinesFromCSVFileTest() {
        //Arrange
        List<Magazine> magazinesWithHeader = null;
        //Act
        try {
            magazinesWithHeader = CSVReader.readMagazinesFromCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Assert
        assertNotNull("the response is null", magazinesWithHeader);
        assertTrue("the size of the returned magazines is wrong", magazinesWithHeader.size() == 9);
        assertEquals(magazinesWithHeader.get(7).getTitle(), "titleTest");
        assertEquals(magazinesWithHeader.get(7).getPublicationDate(), "12.03.2017");
        assertEquals(magazinesWithHeader.get(7).getIsbn(), "1234-1234-1234");
        assertTrue("Field \"Authors\" is not like expected", magazinesWithHeader.get(7).getAuthorEmails().contains("pr-AAaa@optivo.de"));
    }

    // Check if  authoren.csv file can be read properly.
    @Test
    public void readAuthorsFromCSVFileTest() {
        //Arrange
        List<Author> authorsWithHeader = null;
        //Act
        try {
            authorsWithHeader = CSVReader.readAuthorsFromCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Assert
        assertNotNull("the response is null", authorsWithHeader);
        assertTrue("the size of the returned Authors is wrong", authorsWithHeader.size() == 10);
        assertEquals(authorsWithHeader.get(1).getEmail(), "pr-walter@optivo.de");
        assertEquals(authorsWithHeader.get(1).getVorName(), "Paul");
        assertEquals(authorsWithHeader.get(1).getLastName(), "Walter");
    }

    // Check if the fetch of all books is working correctly
    @Test
    public void getAllBooksTest() {
        //Arrange
        BookDao bookDao = new BookDaoImpl();
        //Act
        List<Book> books = bookDao.getAll();
        //Assert
        assertNotNull("the returned books Object is null", books);
        assertTrue("the size of the returned Books is wrong", books.size() == 11);
        assertEquals(books.get(0).getTitle(), "titleTest");
        assertEquals(books.get(0).getDescription(), "added description to test");
        assertEquals(books.get(0).getIsbn(), "999-999-999");
        assertTrue("Field \"Authors\" is not like expected", books.get(0).getAuthorEmails().contains("test@test.de"));
    }

    // Check if the fetch of all magazines is working correctly
    @Test
    public void getAllMagazinesTest() {
        //Arrange
        MagazineDao magazineDao = new MagazineDaoImpl();
        //Act
        List<Magazine> magazines = magazineDao.getAll();
        //Assert
        assertNotNull("the returned magazines Object is null", magazines);
        assertTrue("the size of the returned magazines is wrong", magazines.size() == 8);
        assertEquals(magazines.get(6).getTitle(), "titleTest");
        assertEquals(magazines.get(6).getPublicationDate(), "12.03.2017");
        assertEquals(magazines.get(6).getIsbn(), "1234-1234-1234");
        assertTrue("Field \"Authors\" is not like expected", magazines.get(6).getAuthorEmails().contains("pr-AAaa@optivo.de"));
    }

    // Check if the fetch of a book by ISBN-number is working correctly
    @Test
    public void getBookByISBNTest() {
        //Arrange
        BookDao bookDao = new BookDaoImpl();
        //Act
        Book book = bookDao.getByIsbn("999-999-999");
        //Assert
        assertNotNull("the returned books Object is null", book);
        assertEquals(book.getTitle(), "titleTest");
        assertEquals(book.getDescription(), "added description to test");
        assertTrue("Field \"Authors\" is not like expected", book.getAuthorEmails().contains("test@test.de"));
    }

    // Check if the fetch of a magazine by ISBN-number is working correctly
    @Test
    public void getMagazineByISBNTest() {
        //Arrange
        MagazineDao magazineDao = new MagazineDaoImpl();
        //Act
        Magazine magazine = magazineDao.getByIsbn("1234-1234-1234");
        //Assert
        assertNotNull("the returned magazine Object is null", magazine);
        assertEquals(magazine.getTitle(), "titleTest");
        assertEquals(magazine.getPublicationDate(), "12.03.2017");
        assertTrue("Field \"Authors\" is not like expected", magazine.getAuthorEmails().contains("pr-AAaa@optivo.de"));
    }

    // Check if the fetch of the books & magazines for an author is working correctly
    @Test
    public void getBooksAndMagazinesByAuthorTest() {
        //Arrange
        MagazineDao magazineDao = new MagazineDaoImpl();
        BookDao bookDao = new BookDaoImpl();
        //Act
        List<Magazine> magazines = magazineDao.getByAuthor("pr-lieblich@optivo.de");
        List<Book> books = bookDao.getByAuthor("pr-lieblich@optivo.de");
        //Assert
        assertNotNull("the returned magazines Object is null", magazines);
        assertTrue("the size of the returned magazines is wrong", magazines.size() == 1);
        assertNotNull("the returned books Object is null", books);
        assertTrue("the size of the returned Books is wrong", books.size() == 3);
    }

    // Check if the sort of the books by title is working correctly
    @Test
    public void getBooksAfterSortingByTitleTest() {
        //Arrange
        BookDao bookDao = new BookDaoImpl();
        //Act
        List<Book> books = bookDao.sortByTitle();
        //Assert
        assertNotNull("the returned books Object is null", books);
        assertTrue("the size of the returned books is wrong", books.size() == 11);
        // First book should correspond to the book which has "AAaa" as title.
        assertEquals(books.get(0).getTitle(), "AAaa");
        assertEquals(books.get(0).getDescription(), "added to test 2");
        assertEquals(books.get(0).getIsbn(), "999-888-999");
        assertTrue("Field \"Authors\" is not like expected", books.get(0).getAuthorEmails().contains("test@test.de"));
    }

    // Check if the sort of the magazines by title is working correctly
    @Test
    public void getMagazinesAfterSortingByTitleTest() {
        //Arrange
        MagazineDao magazineDao = new MagazineDaoImpl();
        //Act
        List<Magazine> magazines = magazineDao.sortByTitle();
        //Assert
        assertNotNull("the returned magazines Object is null", magazines);
        assertTrue("the size of the returned magazines is wrong", magazines.size() == 8);
        // First magazine should correspond to the book which has "Aab" as title.
        assertEquals(magazines.get(0).getTitle(), "Aab");
        assertEquals(magazines.get(0).getIsbn(), "12345");
        assertTrue("Field \"Authors\" is not like expected", magazines.get(0).getAuthorEmails().contains("pr-AAab@optivo.de"));
        assertEquals(magazines.get(0).getPublicationDate(), "12.03.2017");
    }
}
