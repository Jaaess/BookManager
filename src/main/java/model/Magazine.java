package model;

import java.util.*;

/**
 * Created by jaouhar.mbarek on 11.03.2017.
 */
public class Magazine {

    public Magazine(String title, String isbn, List<String> authorEmails, String publicationDate) {
        this.title = title;
        this.isbn = isbn;
        this.authorEmails = authorEmails;
        this.publicationDate = publicationDate;
    }

    private String title;
    private String isbn;
    private List<String> authorEmails;
    private String publicationDate;

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<String> getAuthorEmails() {
        return authorEmails;
    }

    public String getPublicationDate() {
        return publicationDate;
    }
}
