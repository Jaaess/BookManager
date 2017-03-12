package dao;

import model.Magazine;

import java.util.List;

/**
 * Created by jaouhar.mbarek on 12.03.2017.
 */
public interface MagazineDao {

    List<Magazine> getAll();

    Magazine getByIsbn(String isbn);

    List<Magazine> getByAuthor(String authorEmail);

    List<Magazine> sortByTitle();
}
