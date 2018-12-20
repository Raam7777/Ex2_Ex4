package GIS;

import Geom.Point3D;

public class Fruits {

	
	private Point3D point;
	private double weight;
	private int ID;
	
	public Fruits(int id,double lat,double lon,double alt,double weight ) {
		this.ID=id;
		this.point=new Point3D(lat,lon,alt);
		this.weight=weight;
	}
	
	public Fruits(int id,Point3D p, double w){
		this.ID = id;
		this.point = p;
		this.weight = w;
		
	}

	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public Point3D getFruit() {
		return point;
	}


	public double getWeight() {
		return weight;
	}


	public void setFruit(Point3D fruit) {
		this.point = fruit;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
