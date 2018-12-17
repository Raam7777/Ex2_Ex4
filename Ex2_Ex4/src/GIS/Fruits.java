package GIS;

import Geom.Point3D;

public class Fruits {

	
	private Point3D point;
	private double weight;
	private int ID;
	
	public Fruits(Point3D p, double w, int id){
		this.point = p;
		this.weight = w;
		this.ID = id;
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
