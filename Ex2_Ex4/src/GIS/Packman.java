package GIS;

import Geom.Point3D;

public class Packman {

	private static final long serialVersionUID = 1L;
	private Point3D location;
	int Radius;
	int Speed;
	
	public Packman(Point3D p, int r , int s){
		this.location = p;
		this.Radius = r;
		this.Speed = s;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Point3D getLocation() {
		return location;
	}

	public int getRadius() {
		return Radius;
	}

	public int getSpeed() {
		return Speed;
	}

	public void setLocation(Point3D location) {
		this.location = location;
	}

	public void setRadius(int radius) {
		Radius = radius;
	}

	public void setSpeed(int speed) {
		Speed = speed;
	}
	
	
	
}
