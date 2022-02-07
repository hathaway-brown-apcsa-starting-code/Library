
/**
 * A class to test the Book and BookList classes
 */
public class Library
{
    public static void main(String[] args)
    {
        BookList books = new BookList("catalog.csv");
        System.out.println(books);
    }
}
