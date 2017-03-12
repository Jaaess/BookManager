package dao.impl;

import dao.MagazineDao;
import db.CSVReader;
import model.Magazine;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jaouhar.mbarek on 12.03.2017.
 */
public class MagazineDaoImpl implements MagazineDao {
    private List<Magazine> magazines;

    public MagazineDaoImpl() {
        try {
            List<Magazine> magazinesList = CSVReader.readMagazinesFromCSV();
            this.magazines = magazinesList.subList(1,magazinesList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Magazine> getAll() {
        return magazines;
    }

    @Override
    public Magazine getByIsbn(String isbn) {
        Magazine magazine = null;
        for (Magazine magazine1 : magazines)
            if (magazine1.getIsbn().equals(isbn)) {
                magazine = magazine1;
            }
        return magazine;
    }

    @Override
    public List<Magazine> getByAuthor(String authorEmail) {
        return magazines.stream().filter(magazine1 -> magazine1.getAuthorEmails().contains(authorEmail)).collect(Collectors.toList());
    }

    @Override
    public List<Magazine> sortByTitle() {
        magazines.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
        return magazines;
    }
}
