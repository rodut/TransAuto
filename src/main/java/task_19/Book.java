package task_19;

class Book {
    private String authorName;
    private String bookName;
    private int year;
    private int numberOfPages;
    private double rating;
    private BookCover cover;

    public Book(String authorName, String bookName, int year, int numberOfPages, double rating, BookCover cover) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.year = year;
        this.numberOfPages = numberOfPages;
        this.rating = rating;
        this.cover = cover;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public BookCover getCover() {
        return cover;
    }

    public void setCover(BookCover cover) {
        this.cover = cover;
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
                '}';
    }
}
