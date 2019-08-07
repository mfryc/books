import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Interface {
    static Scanner inputScanner = new Scanner(System.in);

    static BookDAO bookDao = new BookDAO();

    public static String getUserInput() {
        return inputScanner.nextLine();
    }

    public static void main(String[] args) {
        Book book = new Book();

        System.out.println("Enter the author of the book:");
        book.setAuthor(getUserInput());

        System.out.println("Enter the title of the book:");
        book.setTitle(getUserInput());

        System.out.println("Enter the publisher of the book:");
        book.setPublisher(getUserInput());

        Pattern yearRegex = Pattern.compile("[0-9]{4}");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String yearInput;
        do {
            System.out.println("Enter the year the book was published:");
            yearInput = getUserInput();
            if (yearRegex.matcher(yearInput).matches()) {
                try {
                    book.setYearOfPublication(yearFormat.parse(yearInput));
                } catch (ParseException pe) {
                    System.out.println("Invalid year. Try again.");
                }
            }
        } while (book.getYearOfPublication() == null);

        bookDao.addBook(book);
    }
}