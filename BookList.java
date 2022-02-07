/** Reprsents a list of books in a library
 *
 * @author  APCS-A at Hathaway Brown School
 * @version 2022-02
 */

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class BookList
{

  private ArrayList<Book> books;

  // Creates an empty list of Books
  public BookList()
  {
    books = new ArrayList<Book>();
    
  }

  // Loads a list of Books from fileName
  public BookList(String fileName)
  {
    books = new ArrayList<Book>();
    //String fileName = "catalog.csv";
    
    // Open the file for input
    File file = new File(fileName);
    Scanner sourceFile = null;
    try
    {
        sourceFile = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
        System.out.println("*** Cannot open " + fileName + " ***");
        System.exit(1);        // quit the program
    } 
    String dummy = sourceFile.nextLine();

    // Fill the Collection from the input file
    while (sourceFile.hasNext())
    {
      String str = sourceFile.nextLine();
      books.add(new Book(str));
    }

    sourceFile.close();

     
  }

  public void writeToFile (String fileName)
  {
    // Open the file for output
    File file = new File (fileName);
    PrintWriter outputFile = null;

    try
    {
      outputFile = new PrintWriter(file); 
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("*** Cannot create " + fileName);
    }
    
    // print the header
    outputFile.println("copyrightdate,itemcallnumber,title,author,ccode,itemnumber");
    for (Book b : books)
    {
      outputFile.println(b.toCSV());
    }
    
    outputFile.close();  // crucial to clse the file when you're done 
  }

  /** Writes the BookList with a new line between each Book */
  public String toString()
  {
    String result = "";
    for (Book b : books)
    {
      result += b + "\n";
    }
    return result;
  }
}