package dao;

import model.Author;

/**
 * Created by jaouhar.mbarek on 12.03.2017.
 */
public interface AuthorDao {
    Author getByEmail(String email);
}
