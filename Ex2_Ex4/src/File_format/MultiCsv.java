package File_format;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import GIS.gisLayer;
import GIS.gisProject;
/**
 * The algorithm returns a data structure of a collection of layers of geographic information.
 * @author Raam Banin and sapir.
 * 
 */
public class MultiCsv {
	
	private ArrayList<String> files;
	private gisProject project; 
	
	
	public MultiCsv()
	{
		files = new ArrayList<String>();
	}
	
	/**
	 * Moves to the folder and checks if the file denoted by this abstract path name exists.
	 * @param path - The address of the file
	 * https://www.java-tips.org/java-se-tips/java.io/how-to-read-file-in-java.html
	 */
	public void readfiles(String path){
		File file = new File(path);
		for(File file2 : file.listFiles()){
			if(file2.isDirectory())
				readfiles(file2.toString());
		}
	}


	/**
	 * Creates a new project with all the files and layers together.
	 * Creates a new project and defines layer and creates a new iterator moves to any folder.
	 * The layer picks up file after file and add to project.
	 * @return - A collection of layers...
	 */
	public gisProject CreatesProject(){
		this.project = new gisProject();
		gisLayer layer;
		Iterator<String> iter = this.files.iterator();
		CsvReader csv;
		while(iter.hasNext())
		{
			String s = iter.next();
			csv = new CsvReader();
			layer = new gisLayer(csv.csv_reader(s));
			project.add(layer);
		}
		return project;
	}
	
	public static void main(String[] args) {

		MultiCsv multi = new MultiCsv();
		multi.readfiles("C:\\Users\\Raam Banin\\git\\Ex2_Ex4\\Ex2_Ex4\\csv");
		
		gisProject project = new gisProject();
		project = multi.CreatesProject();
		KmlWriter kmlwriter = new KmlWriter();
		String s = "C:\\Users\\Raam Banin\\git\\Ex2_Ex4\\Ex2_Ex4\\kml\\path.kml";
		kmlwriter.kml_writer(project,s);
	}
}
