import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that writes to a file
 *
 * @author Diego Bazan
 * @version 03/09/2017
 */
public class FileWrite 
{
	private String fileNamePath;
	private boolean editFile; //true if you want to edit the file
	//false if you want to make a new file
	
	/**
	 * Constructor that initializes the instance variables
	 *
	 * @param filePath The path to the file
	 */
	public FileWrite(String filePath)
	{
		fileNamePath = filePath;
	}

	/**
	 * Constructor that initializes the instance variables
	 *
	 * @param filePath The path of the file
	 * @param edit True if the file should be edited and False otherwise
	 */
	public FileWrite(String filePath , boolean edit) 
	{
		fileNamePath = filePath;
		editFile = edit;
	}

	/**
	 * Writes into the file, given the appropriate username
	 *
	 * @param userName The 3 character username of the user
	 */
	public void write(String userName) throws IOException 
	{ 
		FileWriter writeToFile = new FileWriter(fileNamePath, editFile);
		PrintWriter textLine = new PrintWriter(writeToFile);
		textLine.printf(userName + ",");
		textLine.close();
	}

	/**
	 * Checks the username and sorts his/her high scores
	 */
	public void sortHighScore() throws IOException
	{
		ArrayList<Integer> highScores = new ArrayList<Integer>();
		FileRead readHighScore = new FileRead(fileNamePath);
		String nextToken;
		while (readHighScore.hasNextToken())
		{
			nextToken= readHighScore.nextToken();
			int intNextToken = Integer.parseInt(nextToken);
			highScores.add(intNextToken);
		}
		Integer highScoresSorted []= new Integer[highScores.size()];
		highScoresSorted = highScores.toArray(highScoresSorted);
		Arrays.sort(highScoresSorted);
		for (int i = 0; i < highScoresSorted.length;i++){
			System.out.println(highScoresSorted[i]);
		}
		FileWrite rewrite = new FileWrite(fileNamePath, false);
		for (Integer i: highScoresSorted)
		{
			String j = i.toString();
			rewrite.write(j);
			rewrite = new FileWrite(fileNamePath, true);
		}
	}
}