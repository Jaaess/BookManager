package dao.impl;

import dao.AuthorDao;
import db.CSVReader;
import model.Author;

import java.io.IOException;
import java.util.List;

/**
 * Created by jaouhar.mbarek on 12.03.2017.
 */
public class AuthorDaoImpl implements AuthorDao {

    private List<Author> authors;

    public AuthorDaoImpl() {
        try {
            List<Author> authorsList = CSVReader.readAuthorsFromCSV();
            this.authors = authorsList.subList(1,authorsList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Author getByEmail(String email) {
        Author author = null;
        for (Author author1 : authors) {
            if (author1.getEmail().equals(email)) {
                author = author1;
            }
        }
        return author;
    }
}
