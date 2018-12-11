package GIS;

import Geom.Point3D;

public class Fruits {

	private static final long serialVersionUID = 1L;
	private Point3D fruit;
	private int weight;
	
	
	public Fruits(Point3D p, int w){
		this.fruit = p;
		this.weight = w;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Point3D getFruit() {
		return fruit;
	}


	public int getWeight() {
		return weight;
	}


	public void setFruit(Point3D fruit) {
		this.fruit = fruit;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
