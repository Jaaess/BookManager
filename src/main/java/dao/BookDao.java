package dao;

import model.*;

import java.util.List;

/**
 * Created by jaouhar.mbarek on 12.03.2017.
 */
public interface BookDao {

    List<Book> getAll();

    Book getByIsbn(String isbn);

    List<Book> getByAuthor(String authorEmail);

    List<Book>  sortByTitle();
}
