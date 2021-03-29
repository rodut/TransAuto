package task_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UsingStreamsLessonTwo {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Book programming = new Book("Robert Lafore", "Data Structures and Algorithms in Java", 2002, 800, 4.5, BookCover.HARDCOVER, 10.99);
        Book firstHistory = new Book("Aleksandr Solzhenitsyn", "The Gulag Archipelago", 2002, 496, 4.9, BookCover.PAPERBACK, 29.00);
        Book secondHistory = new Book("Aleksandr Solzhenitsyn", "Warning to the West", 1986, 160, 4.8, BookCover.PAPERBACK, 17.99);
        Book education = new Book("Emmanuel Acho", "Uncomfortable Conversations with a Black Man", 2020, 256, 4.8, BookCover.HARDCOVER, 14.99);
        Book literature = new Book("Kristin Hannah", "The Nightingale", 2017, 608, 4.8, BookCover.PAPERBACK, 26.99);
        Book cookbook = new Book("Joanna Gaines", "Magnolia Table", 2018, 336, 4.2, BookCover.HARDCOVER, 34.99);
        books.add(programming);
        books.add(firstHistory);
        books.add(secondHistory);
        books.add(education);
        books.add(literature);
        books.add(cookbook);

        // 1
        books.stream().forEach(book -> book.setAuthorName("unidentified"));
        for (Book book: books) {
            System.out.println(book);
        }

        // 2
        Map<String, Book> result = books.stream().filter(book -> book.getYear() < 2010).collect(Collectors.toMap(Book::getBookName, Function.identity()));
        for (Map.Entry<String, Book> entry : result.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        // 3
        System.out.println(books.stream().filter(book -> book.getRating() > 4.9).findFirst().orElse(null));

        // 4.1
        OptionalDouble minPrice1 = books.stream().mapToDouble(Book::getPrice).min();
        System.out.println(minPrice1);
        // 4.2
        Optional<Book> minPrice2 = books.stream().min(Comparator.comparingDouble(Book::getPrice));
        System.out.println(minPrice2);
        // 4.3
        System.out.println(books.stream().min(((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()))));
    }
}

/**
 * + using stream() && forEach(), change the value of the author param to "unidentified" (with a setter)
 * + stream() & filter() the list (by any condition) and then collect the result as a map, having the book name as a key of the map, and the object itself as a value
 * +/- stream(), filter the list and return the first book or if none, then null
 * + add a price var for Book class. Using streams(), find the minimum price from the list of books.
 */
