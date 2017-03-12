package db;

import model.*;

import java.io.*;
import java.util.*;

/**
 * Created by jaouhar.mbarek on 12.03.2017.
 */
public class CSVReader {

    // method to read CVS file using BufferedReader and String split()
    public static List<Book> readBooksFromCSV() throws IOException {
        List<Book> books = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("data/buecher.csv"));
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(";");
            String title = fields[0];
            String isbn = fields[1];
            String description = fields[3];
            List<String> authorEmails = new ArrayList<>();
            String[] authors = fields[2].split(",");
            Collections.addAll(authorEmails, authors);
            Book book = new Book(title, isbn, authorEmails, description);
            books.add(book);
        }
        br.close();
        return books;
    }

    public static List<Author> readAuthorsFromCSV() throws IOException {
        List<Author> authors = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("data/autoren.csv"));
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(";");
            String email = fields[0];
            String vorName = fields[1];
            String lastName = fields[2];
            Author author = new Author(email, vorName, lastName);
            authors.add(author);
        }
        br.close();
        return authors;
    }

    public static List<Magazine> readMagazinesFromCSV() throws IOException {
        List<Magazine> magazines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("data/zeitschriften.csv"));
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(";");
            String title = fields[0];
            String isbn = fields[1];
            String publicationDate = fields[3];
            List<String> authorEmails = new ArrayList<>();
            String[] authors = fields[2].split(",");
            Collections.addAll(authorEmails, authors);
            Magazine magazine = new Magazine(title, isbn, authorEmails, publicationDate);
            magazines.add(magazine);
        }
        br.close();
        return magazines;
    }
}
