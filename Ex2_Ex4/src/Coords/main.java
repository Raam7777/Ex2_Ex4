package Coords;

import java.util.Arrays;

import Geom.Point3D;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Point3D gps0 = new Point3D(32.103,35.209,670);
		Point3D gps1 = new Point3D(337.699,-359.249,-20);
		MyCoords p1 = new MyCoords();
		System.out.println(p1.add(gps0, gps1));
		
		
		Point3D gps2 = new Point3D(32.103315 , 35.209039 , 670);
		Point3D gps3 = new Point3D(32.106352 , 35.205225 , 650);
		MyCoords p2 = new MyCoords();
		System.out.println(p2.distance3d(gps2, gps3));
		
		
		Point3D gps4 = new Point3D(32.103315 , 35.209039 , 670);
		Point3D gps5 = new Point3D(32.106352 , 35.205225 , 650);
		MyCoords p3 = new MyCoords();
		System.out.println(p3.vector3D(gps4, gps5));
		
		
		Point3D gps6 = new Point3D(32.103315 , 35.209039 , 670);
		Point3D gps7 = new Point3D(32.106352 , 35.205225 , 650);
		MyCoords p4 = new MyCoords();
		System.out.println(Arrays.toString(p4.azimuth_elevation_dist(gps6, gps7)));
		
	}

	

}
