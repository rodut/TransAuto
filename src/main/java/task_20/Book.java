package task_20;

class Book {
    private String authorName;
    private String bookName;
    private int year;
    private int numberOfPages;
    private double rating;
    private BookCover cover;
    private double price;

    public Book(String authorName, String bookName, int year, int numberOfPages, double rating, BookCover cover, double price) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.year = year;
        this.numberOfPages = numberOfPages;
        this.rating = rating;
        this.cover = cover;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCover(BookCover cover) {
        this.cover = cover;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public int getYear() {
        return year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public double getRating() {
        return rating;
    }

    public BookCover getCover() {
        return cover;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", year=" + year +
                ", numberOfPages=" + numberOfPages +
                ", rating=" + rating +
                ", cover=" + cover +
                ", price=" + price +
                '}';
    }
}
