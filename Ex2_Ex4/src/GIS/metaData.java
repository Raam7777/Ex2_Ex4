package GIS;

import Geom.Point3D;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Geom.Point3D;

public class metaData implements Meta_data {


//---------------------------private-------------------\\
	public String [] csvLine;
	public String mac;
	public String SSID;
	public String AuthMode;
	public String FirstSeen;
	public String Channel;
	public String RSSI;
	public String AccuracyMeters;
	public String Type;
	public String Color;
	
//-------------------------------------------------------\\	
	/**
	 * constructor default.
	 */
	/*public metaData(){
		this.csvLine = new String[11];
		this.mac=csvLine[0];
		this.SSID=csvLine[1];
		this.AuthMode=csvLine[2];
		this.FirstSeen=csvLine[3];
		this.Channel=csvLine[4];
		this.RSSI=csvLine[5];
		this.AccuracyMeters=csvLine[9];
		this.Type=csvLine[10];

	}*/
	
	/**
	 * 
	 * constructor that get a line from csv with a array
	 * @param s
	 */
	public metaData(String mac, String SSID,String AuthMode,String FirstSeen,String Channel,String RSSI,String AccuracyMeters, String Type)
	{
		this.mac=mac;
		this.SSID=SSID;
		this.AuthMode=AuthMode;
		this.FirstSeen=FirstSeen;
		this.Channel=Channel;
		this.RSSI=RSSI;
		this.AccuracyMeters=AccuracyMeters;
		this.Type=Type;

	}

//---------------------getter and setter-------------------\\
	
	public String[] getCsvLine() {
		return csvLine;
	}

	public String getMac() {
		return mac;
	}

	public String getSSID() {
		return SSID;
	}

	public String getAuthMode() {
		return AuthMode;
	}

	public String getFirstSeen() {
		return FirstSeen;
	}

	public String getChannel() {
		return Channel;
	}

	public String getRSSI() {
		return RSSI;
	}

	public String getAccuracyMeters() {
		return AccuracyMeters;
	}

	public String getType() {
		return Type;
	}

	public String getColor() {
		return Color;
	}

	public void setCsvLine(String[] csvLine) {
		this.csvLine = csvLine;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public void setSSID(String sSID) {
		SSID = sSID;
	}

	public void setAuthMode(String authMode) {
		AuthMode = authMode;
	}

	public void setFirstSeen(String firstSeen) {
		FirstSeen = firstSeen;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public void setRSSI(String rSSI) {
		RSSI = rSSI;
	}

	public void setAccuracyMeters(String accuracyMeters) {
		AccuracyMeters = accuracyMeters;
	}

	public void setType(String type) {
		Type = type;
	}

	public void setColor(String color) {
		Color = color;
	}

	
//-------------------------------------------------\\	
	@Override
	/**this function get a string and return it to time stamp.
	 * @return long = ("dd/MM/yyyy HH:mm:ss") 
	 */
	public long getUTC() {
		Long time = new Date().getTime();
		return time;
	}
	
	
	
	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString()
	{
		return "mac: "+this.mac+", SSID: "+this.SSID+", AuthMode: "+this.AuthMode+", FirstSeen:"+this.FirstSeen+", Channel: "+this.Channel+", RSSI: " + this.RSSI +", AccuracyMeters:" +this.AccuracyMeters+", type: "+this.Type;
	}


}
