package model;

import java.util.List;

/**
 * Created by jaouhar.mbarek on 11.03.2017.
 */
public class Book {

    public Book(String title, String isbn, List<String> authorEmails, String description) {
        this.title = title;
        this.isbn = isbn;
        this.authorEmails = authorEmails;
        this.description = description;
    }

    private String title;
    private String isbn;
    private List<String> authorEmails;
    private String description;

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<String> getAuthorEmails() {
        return authorEmails;
    }

    public String getDescription() {
        return description;
    }

}
