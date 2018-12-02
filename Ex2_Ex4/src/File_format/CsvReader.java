package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import GIS.gisElement;
/**
 * Reads csv files.
 * https://alvinalexander.com/blog/post/java/how-open-read-file-java-string-array-list
 */
public class CsvReader {
	
	private BufferedReader BR;
	
	/**
	 * BR - Reading characters from a long text file. str - if the line not null read thr line and add to array list. 
	 * @param input - Source reading files
	 * @return - ArrayList on the basis of elements.
	 */
	public ArrayList<gisElement> csv_reader(String input){
		try {
			String str; 
			gisElement element;
			ArrayList<gisElement> arrayElement = new ArrayList<>();
			
			BR = new BufferedReader(new FileReader(input));
			BR.readLine(); 
			BR.readLine();
			while ((str = BR.readLine()) != null)
			{
				element = new gisElement(str);
				arrayElement.add(element);
			}
			return arrayElement;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}