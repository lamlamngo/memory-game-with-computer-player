import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that takes a text file and parses it into individual words,
 * which are either words (separated by spaces or other punctuation)
 * or the # symbol, indicating a page break.
 *
 * @author Diego Bazan
 * @version 03/06/2017
 */
public class FileRead
{
    private Scanner sc;

    /**
     * Constructor specifying the file to read from.
     *
     * @param filename The absolute or relative path to the desired file.
     *        Examples: "input.txt" or "C:/input.txt"
     */
    public FileRead(String filename)
    {
    	try
    	{
    		File file = new File(filename);
			try{
				if (!file.exists()) {
					file.createNewFile();
				}
			} catch (IOException ioe){

			}
    		sc = new Scanner(file);
    		sc.useDelimiter(",");

    	}
    	catch (FileNotFoundException e)
    	{
    		System.out.println(filename + " not found");
    	}
    }

    /**
     * Gets the next token of the file
     *
     * @return the next Token if there is one and null otherwise.
     */
    public String nextToken()
    {
    	if (sc.hasNext())
    	{
    		return sc.next();
    	}
    	else
    	{
    		return null;
    	}
    }

    /**
     * Checks whether the file has a next token
     *
     * @return hasNext True if the file has a next token and false otherwise
     */
    public Boolean hasNextToken()
    {
    	Boolean hasNext;
    	if (sc.hasNext())
    	{
    		hasNext = true;
    	}
    	else
    	{
    		hasNext = false;
    	}
    	return hasNext;
    }
}