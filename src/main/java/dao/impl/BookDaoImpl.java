package dao.impl;

import dao.BookDao;
import db.CSVReader;
import model.Book;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jaouhar.mbarek on 12.03.2017.
 */
public class BookDaoImpl implements BookDao {

    private List<Book> books;

    public BookDaoImpl() {
        try {
            List<Book> booksList = CSVReader.readBooksFromCSV();
            this.books = booksList.subList(1, booksList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Book getByIsbn(String isbn) {
        Book book = null;
        for (Book book1 : books)
            if (book1.getIsbn().equals(isbn)) {
                book = book1;
            }
        return book;
    }

    @Override
    public List<Book> getByAuthor(String authorEmail) {
        return books.stream().filter(book1 -> book1.getAuthorEmails().contains(authorEmail)).collect(Collectors.toList());
    }

    @Override
    public List<Book> sortByTitle() {
        books.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
        return books;
    }
}
