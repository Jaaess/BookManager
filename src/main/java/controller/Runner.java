package controller;

import dao.AuthorDao;
import dao.impl.*;
import model.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jaouhar.mbarek on 11.03.2017.
 */
public class Runner {


    public static void printAuthor(Author author) {
        System.out.println("| \"Vorname\" : " + author.getVorName() + " | \"Lastname\" : " + author.getLastName() + " | \"Email\" : " + author.getEmail() + "|");
    }

    public static void printBook(Book book, List<Author> authors) {
        System.out.println("\"Title\" : " + book.getTitle());
        System.out.println("\"ISBN-Nummer\" : " + book.getIsbn());
        System.out.println("\"Authors\" : ");
        authors.forEach(Runner::printAuthor);
        System.out.println("\"Description\" : " + book.getDescription() + "\n");
    }

    public static void printMagazine(Magazine magazine, List<Author> authors) {
        System.out.println("\"Title\" : " + magazine.getTitle());
        System.out.println("\"ISBN-Nummer\" : " + magazine.getIsbn());
        System.out.println("\"Authors\" : ");
        authors.forEach(Runner::printAuthor);
        System.out.println("\"Publication Date\" : " + magazine.getPublicationDate() + "\n");
    }

    public static void main(String[] args) {
        BookDaoImpl bookDao = new BookDaoImpl();
        MagazineDaoImpl magazineDao = new MagazineDaoImpl();
        AuthorDao authorDao = new AuthorDaoImpl();

        if (args[0].equals("PrintAllBooks")) {
            // print all books with their details
            List<Book> books = bookDao.getAll();
            System.out.println("\t\t\t\tList of all Books: \n");
            int i = 0;
            for (Book book : books) {
                i++;
                System.out.println("\t\tBook " + i + ":\n");
                List<String> authorEmails = book.getAuthorEmails();
                List<Author> authors = authorEmails.stream().map(authorDao::getByEmail).collect(Collectors.toList());
                printBook(book, authors);
            }

        } else if (args[0].equals("PrintAllMagazines")) {
            // print all magazines with their details
            List<Magazine> magazines = magazineDao.getAll();
            System.out.println("\t\t\t\tList of all magazines: \n");
            int j = 0;
            for (Magazine magazine : magazines) {
                j++;
                System.out.println("\t\tMagazine " + j + ":\n");
                List<String> authorEmails = magazine.getAuthorEmails();
                List<Author> authors = authorEmails.stream().map(authorDao::getByEmail).collect(Collectors.toList());
                printMagazine(magazine, authors);
            }
        } else if (args[0].equals("PrintBookByISBN")) {
            // using ISBN-number find and print a book
            String isbn = args[1]; //e.g. "5554-5545-4518"
            System.out.println("The book with the ISBN-number: " + isbn + ":\n");
            List<String> authorEmails = bookDao.getByIsbn(isbn).getAuthorEmails();
            List<Author> authors = authorEmails.stream().map(authorDao::getByEmail).collect(Collectors.toList());
            printBook(bookDao.getByIsbn(isbn), authors);
        } else if (args[0].equals("PrintMagazineByISBN")) {
            // using ISBN-number to find and print a magazine
            String isbn = args[1];
            System.out.println("The magazine with the ISBN-number: " + isbn + ":\n");
            List<String> authorEmails = magazineDao.getByIsbn(isbn).getAuthorEmails();
            List<Author> authors = authorEmails.stream().map(authorDao::getByEmail).collect(Collectors.toList());
            printMagazine(magazineDao.getByIsbn(isbn), authors);
        } else if (args[0].equals("PrintByAuthor")) {
            // print all books & magazines for author
            String authorEmail = args[1]; //e.g. "pr-lieblich@optivo.de"
            System.out.println("\t\t\t\tAuthor Details:\n");
            printAuthor(authorDao.getByEmail(authorEmail));
            List<Book> authorBooks = bookDao.getByAuthor(authorEmail);
            List<Magazine> authorMagazines = magazineDao.getByAuthor(authorEmail);
            System.out.println("\t\t\t\tList of his Books:\n");
            int i = 0;
            for (Book book : authorBooks) {
                i++;
                System.out.println("\t\tBook " + i + ":\n");
                List<String> authorEmails = book.getAuthorEmails();
                List<Author> authors = authorEmails.stream().map(authorDao::getByEmail).collect(Collectors.toList());
                printBook(book, authors);
            }
            System.out.println("\t\t\t\tList of his Magazines:\n");
            int j = 0;
            for (Magazine magazine : authorMagazines) {
                j++;
                System.out.println("\t\tMagazine " + j + ":\n");
                List<String> authorEmails = magazine.getAuthorEmails();
                List<Author> authors = authorEmails.stream().map(authorDao::getByEmail).collect(Collectors.toList());
                printMagazine(magazine, authors);
            }
        } else if (args[0].equals("SortBooksByTitle")) {
            // sort all books by title
            List<Book> booksToDisplay = bookDao.sortByTitle();
            System.out.println("\t\t\t\tList of all Books sorted by title:\n ");
            int i = 0;
            for (Book book : booksToDisplay) {
                i++;
                System.out.println("\t\tBook " + i + ":\n");
                List<String> authorEmails = book.getAuthorEmails();
                List<Author> authors = authorEmails.stream().map(authorDao::getByEmail).collect(Collectors.toList());
                printBook(book, authors);
            }
        } else if (args[0].equals("SortMagazinesByTitle")) {
            // sort all magazines by title
            List<Magazine> magazinesToDisplay = magazineDao.sortByTitle();
            System.out.println("\t\t\t\tList of all magazines sorted by title: \n");
            int j = 0;
            for (Magazine magazine : magazinesToDisplay) {
                j++;
                System.out.println("\t\tMagazine " + j + ":\n");
                List<String> authorEmails = magazine.getAuthorEmails();
                List<Author> authors = authorEmails.stream().map(authorDao::getByEmail).collect(Collectors.toList());
                printMagazine(magazine, authors);
            }
        }
    }
}
