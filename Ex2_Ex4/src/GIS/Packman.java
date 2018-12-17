package GIS;

import Geom.Point3D;

public class Packman {

	
	private Point3D point;
	private double Radius;
	private double Speed;
	private int ID;
	
	public Packman(Point3D p, double r , double s,int id){
		this.point = p;
		this.Radius = r;
		this.Speed = s;
		this.ID = id;
	}

	public Packman(Packman other) {
		this.point = other.point;
		this.Radius = other.Radius;
		this.Speed = other.Speed;
		this.ID = other.ID;
	}


	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Point3D getLocation() {
		return point;
	}

	public double getRadius() {
		return Radius;
	}

	public double getSpeed() {
		return Speed;
	}

	public void setLocation(Point3D location) {
		this.point = location;
	}

	public void setRadius(int radius) {
		Radius = radius;
	}

	public void setSpeed(int speed) {
		Speed = speed;
	}
	
	
	
}
