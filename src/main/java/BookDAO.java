import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    List<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to the list.");
    }

    public List<Book> getBooks() {
        return books;
    }
}