/** Reprsents a book in a library
 *
 * @author  APCS-A at Hathaway Brown School
 * @version 2021-01
 */

//biblionumber,copyrightdate,itemcallnumber,title,author,ccode,itemnumber


public class Book
{
  private int copyrightDate;
  private String callNumber;
  private String title;
  private String author;
  private String ccode;
  private int itemNumber;
  
  
  public Book (String str)
  {
    InputLine bookInfo = new InputLine(str);

    String temp = bookInfo.nextToken();
    copyrightDate = new Integer(temp);

    temp = bookInfo.nextToken();
    callNumber = temp;
    
    temp = bookInfo.nextToken();
    title = temp;

    temp = bookInfo.nextToken();
    author = temp;

    temp = bookInfo.nextToken();
    ccode = temp;

    temp = bookInfo.nextToken();
    itemNumber = new Integer(temp);
  }
    


  public int getCopyrightDate()
  {
    return copyrightDate;
  }
  
  public String getCallNumber()
  {
    return callNumber;
  }

  public String getTitle()
  {
    return title;
  }
  
  public String getAuthor()
  {
    return author;
  }


//copyrightdate,itemcallnumber,title,author,ccode,itemnumber,status
  public String toCSV()
  {
    String result = "";
    result += copyrightDate + "," + callNumber + ",";
    result += withQuotes(title) + ","+ withQuotes(author) + ",";
    result += ccode + "," + itemNumber;
    return result;
  }

  // If there is a comma in the string,
  // surrounds it with withQuotes
  private String withQuotes (String s)
  {
    if (s.indexOf(',') >= 0)
    {
      return "\"" + s + "\"";
    }
    else
    {
      return s;
    }
  }
}

