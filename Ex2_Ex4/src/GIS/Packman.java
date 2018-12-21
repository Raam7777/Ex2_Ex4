package GIS;


import Geom.Point3D;

public class Packman {


	private Point3D point;
	private double Radius;
	private double Speed;
	private long time;
	private int ID;

	public Packman(int id, double lat ,double lon , double alt, double speed ,double radius) {
		this.point = new Point3D(lat,lon,alt);
		this.ID=id;
		this.Speed=speed;
		this.Radius=radius;
	}
	
	public Packman(Point3D p, long t){
		this.point = p;
		this.time = t;
	}

	public Packman(int id, Point3D p, double r , double s){
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

	public Point3D getPoint() {
		return point;
	}

	public double getRadius() {
		return Radius;
	}

	public double getSpeed() {
		return Speed;
	}

	public void setPoint(Point3D point) {
		this.point = point;
	}

	public void setRadius(int radius) {
		Radius = radius;
	}

	public void setSpeed(int speed) {
		Speed = speed;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	public String toString() {
		return "Packman ( "+"Point: "+this.getPoint()+" ID:"+this.getID()+" Speed:"+this.getSpeed()+" Radius:"+this.getRadius()+")";
	}

}
