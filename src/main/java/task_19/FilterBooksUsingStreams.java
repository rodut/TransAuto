package task_19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterBooksUsingStreams {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Book programming = new Book("Robert Lafore", "Data Structures and Algorithms in Java", 2002, 800, 4.5, BookCover.HARDCOVER);
        Book firstHistory = new Book("Aleksandr Solzhenitsyn", "The Gulag Archipelago", 2002, 496, 4.9, BookCover.PAPERBACK);
        Book secondHistory = new Book("Aleksandr Solzhenitsyn", "Warning to the West", 1986, 160, 4.8, BookCover.PAPERBACK);
        Book education = new Book("Emmanuel Acho", "Uncomfortable Conversations with a Black Man", 2020, 256, 4.8, BookCover.HARDCOVER);
        Book literature = new Book("Kristin Hannah", "The Nightingale", 2017, 608, 4.8, BookCover.PAPERBACK);
        Book cookbook = new Book("Joanna Gaines", "Magnolia Table", 2018, 336, 4.2, BookCover.HARDCOVER);
        books.add(programming);
        books.add(firstHistory);
        books.add(secondHistory);
        books.add(education);
        books.add(literature);
        books.add(cookbook);

        List<Book> firstList = books.stream()
                .filter(book -> book.getBookName().contains("res") && book.getYear() < 2010)
                .collect(Collectors.toList());
        System.out.println(firstList);

        List<Book> secondList = books.stream()
                .filter(book -> book.getAuthorName().contains("Aleksandr Solzhenitsyn"))
                .sorted(Comparator.comparing(Book::getYear))
                .collect(Collectors.toList());
        for (Book book : secondList) {
            System.out.println(book);
        }

        long numberOfBooksByAuthor = books.stream()
                .filter(book -> book.getAuthorName().contains("Aleksandr Solzhenitsyn"))
                .count();
        System.out.println("Number of books that have the same author: \n" + numberOfBooksByAuthor);

        System.out.println(books.stream().filter(book -> book.getAuthorName().contains("Aleksandr Solzhenitsyn")).collect(Collectors.toList()).size());
    }
}