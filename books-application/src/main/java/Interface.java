import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Interface {
    static Scanner inputScanner = new Scanner(System.in);

    static BookDAO bookDao = new BookDAO();

    public static void main(String[] args) {
        String userSelection;
        do {
            System.out.println("Choose an option: add book (1), show all books (2), exit (x)");
            userSelection = getUserInput();
            if (userSelection.equals("1")) {
                addBook();
            } else if (userSelection.equals("2")) {
                showBooks();
            }
        } while (!userSelection.equalsIgnoreCase("x"));
    }

    public static void addBook() {
        System.out.println("ADD BOOK:");
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

    public static void showBooks() {
        System.out.println("BOOKS LIST:");
        Book book;
        for (int i = 0; i < bookDao.getBooks().size(); i++) {
            book = bookDao.getBooks().get(i);
            System.out.println(i + ": " + book.getTitle());
        }

        Pattern numberRegex = Pattern.compile("[0-9]+");
        String numberInput;
        do {
            System.out.println("Which book do you want to know more about?");
            numberInput = getUserInput();
        } while (!numberRegex.matcher(numberInput).matches());

        Integer bookNumber = Integer.parseInt(numberInput);
        if (bookDao.getBooks().size() > bookNumber) {
            Book selectedBook = bookDao.getBooks().get(bookNumber);
            selectedBook.describe();
        } else {
            System.out.println("The book does not exist.");
        }
    }

    public static String getUserInput() {
        return inputScanner.nextLine();
    }

}