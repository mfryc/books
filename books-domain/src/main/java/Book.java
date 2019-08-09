import java.util.Date;

public class Book {
    private String author;
    private String title;
    private String publisher;
    private Date yearOfPublication;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Date yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public void describe() {
        System.out.println("Author: " + getAuthor() + ", title: " + getTitle() + ", publisher: " + getPublisher() + ", year of publication: " + getYearOfPublication());
    }
}