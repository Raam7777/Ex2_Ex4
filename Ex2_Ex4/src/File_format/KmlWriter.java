package File_format;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;

import GIS.gisElement;
import GIS.gisLayer;
import GIS.gisProject;
import GIS.GIS_element;
import GIS.GIS_layer;
/**
 * Writes kml files.
 * @author Raam Banin
 *
 */
public class KmlWriter {

	private BufferedWriter BW;

	/**
	 * BW - Reading lines from the text file is long as strings.
	 * Collection of layers --> Passes each layer --> Focuses on one layer -->  Passing each of the elements.
	 * @param project - function of project.
	 * @param output - Write to a specific file.
	 */
	public void kml_writer(gisProject project,String output){
		
		Iterator<GIS_layer> CollectionOfLayers = project.iterator();
		
		try
		{
			BW = new BufferedWriter(new FileWriter(output));
			BW.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			BW.write("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"blue\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/blue-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\n");
			while(CollectionOfLayers.hasNext()){
				gisLayer PassesEachLayer = (gisLayer)CollectionOfLayers.next();
				Iterator<GIS_element> OneLayer = PassesEachLayer.iterator();
				while(OneLayer.hasNext())
				{
					gisElement OneElement = (gisElement)OneLayer.next();
					BW.write("<Placemark>\n");
					BW.write("<name>"+"<![CDATA["+OneElement.getmataData().getSSID()+"]]>"  +"</name>\n");
					BW.write("<description>"+"<![CDATA[BSSID: <b>"+OneElement.getmataData().getMac()+"</b><br/>Capabilities: <b>"+OneElement.getmataData().getAuthMode()+"</b><br/>Timestamp: <b>"+OneElement.getData().getUTC()+"</b><br/>Channel: <b>"+OneElement.getmataData().getChannel()+"</b><br/>RSSI: <b>"+OneElement.getmataData().getRSSI()+"</b><br/>AccuracyMeters: <b>"+OneElement.getmataData().getAccuracyMeters()+"</b><br/>Type: <b>"+OneElement.getmataData().getType()+"</b><br/>Date: <b>"+OneElement.getmataData().getFirstSeen()+"</b>]]>"+"</description><styleUrl>#blue</styleUrl>\n");
					BW.write("<Point>\n");
					BW.write("<coordinates>"+OneElement.getPoint().y()+","+OneElement.getPoint().x()+","+OneElement.getPoint().z()+"</coordinates></Point>\n");
					BW.write("</Placemark>\n");

				}
			}
			BW.write("</Folder>\n");
			BW.write("</Document></kml>");
			BW.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

}
