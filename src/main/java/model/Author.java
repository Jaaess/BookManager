package model;

/**
 * Created by jaouhar.mbarek on 11.03.2017.
 */
public class Author {

    public Author(String email, String vorName, String lastName) {
        this.email = email;
        this.vorName = vorName;
        this.lastName = lastName;
    }

    private String email;
    private String vorName;
    private String lastName;

    public String getEmail() {
        return email;
    }

    public String getVorName() {
        return vorName;
    }

    public String getLastName() {
        return lastName;
    }
}
