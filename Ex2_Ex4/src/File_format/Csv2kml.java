package File_format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Csv2kml 
{
	
	/**
	 * The function takes the csv file and translates it into a kml file. 
	 * @param path - The address of the csv file.
	 */
	public static void readCsv2kml(String path)
	{
		try 
		{
			FileReader FR = new FileReader(path);
			FileWriter FW = new FileWriter("C:\\Users\\Raam Banin\\git\\Ex2_Ex4\\Ex2_Ex4\\kml\\path1.kml");
			
			BufferedReader BR = new BufferedReader(FR);
			BufferedWriter BW = new BufferedWriter(FW);
			StringBuilder SB = new StringBuilder();
			
			String line = "";
			String[] str = new String[11];
			str = line.split(",");
			
			SB.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			SB.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\r\n" + "");
			
			line = BR.readLine();
			line = BR.readLine();
			while((line = BR.readLine())!=null)
			{
				str = line.split(",") ;
				SB.append("<Placemark>\n");
				SB.append("<name>"+"<![CDATA["+str[1]+"]]>"  +"</name>\n");
				SB.append("<description>"+"<![CDATA[BSSID: <b>"+str[0]+"</b><br/>Capabilities: <b>"+str[2]+"</b><br/>Channel: <b>"+str[4]+"</b><br/>RSSI: <b>"+str[5]+"</b><br/>AccuracyMeters: <b>"+str[9]+"</b><br/>Type: <b>"+str[10]+"</b><br/>Date: <b>"+str[3]+"</b>]]>"+"</description><styleUrl>#red</styleUrl>\n");
				SB.append("<Point>\n");
				SB.append("<coordinates>"+str[7]+","+str[6]+","+str[8]+"</coordinates></Point>\n");
				SB.append("</Placemark>\n");
				
			}
			SB.append("\n</Folder>\n");
			SB.append("</Document></kml>");
			
			BW.write(SB.toString());
			BW.close();
			
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void main(String[] args) 
	{
		Csv2kml h = new Csv2kml();
		h.readCsv2kml("C:\\Users\\Raam Banin\\git\\Ex2_Ex4\\Ex2_Ex4\\csv\\WigleWifi_20171203085618.csv");
		
	}
}