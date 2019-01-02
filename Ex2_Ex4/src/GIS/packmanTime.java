package GIS;

import java.util.ArrayList;

import Coords.MyCoords;
import GUI.Map;
import Geom.Point3D;

public class packmanTime {

	private ArrayList<Packman> packmans = new ArrayList<Packman>();
	private long totalTime=0;
	private Point3D location;
	private Packman packman;
	
	public long time(Point3D newLocation){
		
		Map m = new Map();
		double distance = m.pixelDistance(location, newLocation);
		long time = (long)(distance/packman.getSpeed());
		totalTime = totalTime + time;

		Packman packmanPoint = new Packman(location,totalTime);
		packmans.add(packmanPoint);
		this.location = newLocation;
		return time;

	}

	public ArrayList<Packman> getPackmans() {
		return packmans;
	}

	public long getTotalTime() {
		return totalTime;
	}

	public Point3D getLocation() {
		return location;
	}

	public Packman getPackman() {
		return packman;
	}

	public void setPackmans(ArrayList<Packman> packmans) {
		this.packmans = packmans;
	}

	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	public void setLocation(Point3D location) {
		this.location = location;
	}

	public void setPackman(Packman packman) {
		this.packman = packman;
	}
	
	

}
