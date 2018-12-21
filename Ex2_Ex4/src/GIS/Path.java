package GIS;

import java.util.ArrayList;
import Geom.Point3D;



public class Path {

	private Packman packman;
	private Point3D location;
	private long totalTime=0;
	private ArrayList<Packman> packmans = new ArrayList<Packman>();
	private Packman [] pathPackman;
	
	
	public Path(Packman p){
		this.packman = p;
		this.location = p.getPoint();
		Packman packmanPoint = new Packman(location,totalTime);
		packmans.add(packmanPoint);
	}
	
	public Path(Game game){
		pathPackman = new Packman[game.sizePackman()];
		for(int i=0; i<pathPackman.length; i++)
			pathPackman[i] = new Packman(game.getPackmen(i));
	}
	
	public Packman[] getPathPackman() {
		return pathPackman;
	}

	public void setPathPackman(Packman[] pathPackman) {
		this.pathPackman = pathPackman;
	}
	
	public Packman getPathPackman(int index) {
		return pathPackman[index];
	}
	
	public int getSize(){
		return pathPackman.length;
	}

	public Packman getPackman() {
		return packman;
	}

	public void setPackman(Packman packman) {
		this.packman = packman;
	}

	public Point3D getLocation() {
		return location;
	}

	public long getTotalTime() {
		return totalTime;
	}

	public ArrayList<Packman> getPackmans() {
		return packmans;
	}

	public void setLocation(Point3D location) {
		this.location = location;
	}

	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	public void setPackmans(ArrayList<Packman> packmans) {
		this.packmans = packmans;
	}
	
	
	
	
}
