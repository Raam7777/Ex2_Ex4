package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter {

	private final int radius = 6371*1000;
	
	
	/**
	 *  computes a new point which is the gps point transformed by a 3D vector (in meters)
	 * @param Point3D gps - point in degree. Point3D local_vector_in_meter -point in meter
	 * @return new point in degree
	 */
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {	
		
		double gps2_x = latMeterToRadian(local_vector_in_meter.x());
		double gps2_x1 = local_vector_in_meter.r2d(gps2_x);
		
		double Lon_Norm = Math.cos(gps2_x1*Math.PI/180);
		
		double gps2_y = lonMeterToRadian(local_vector_in_meter.y(),Lon_Norm);
		double gps2_y1 = local_vector_in_meter.r2d(gps2_y);
		
		Point3D gps2 = new Point3D(gps2_x1,gps2_y1,local_vector_in_meter.z());
		
		gps.add(gps2);
		
		return gps;
		
	}

	public double latMeterToRadian(double x){ // this function convert lattitude meter to radian
		double latRad = Math.asin(x/radius);
		return latRad;
	}
	
	public double lonMeterToRadian(double x,double y){ // this function convert lontitude meter to radian
		double lonRad = Math.asin(x/radius*y);
		return lonRad;
	}

	/**
	 * computes the 3D distance (in meters) between the two gps like points
	 * @param gps0 ,gps1 - both two point that we calculate distance between them 
	 * @return distance
	 */
	public double distance3d(Point3D gps0, Point3D gps1) {
		
		Point3D gps_new = new Point3D(gps1.x()-gps0.x(),gps1.y()-gps0.y());
		return gps_new.distance2D(angles_meter(gps_new,gps0));
		
	}
	
	private Point3D angles_meter(Point3D gps0,Point3D gps1){ // this function calculate degree to radian
		double gps0_x = gps0.d2r(gps0.x());
		double gps0_x1 = latRadianToMeter(gps0_x);
		
		double Lon_Norm = Math.cos(gps1.x()*Math.PI/180);

		double gps0_y = gps0.d2r(gps0.y());
		double gps0_y1 = lonRadianToMeter(gps0_y,Lon_Norm);

		return new Point3D(gps0_x1,gps0_y1);
	}
	
	public double latRadianToMeter(double x){
		double latRad = Math.sin(x)*radius;
		return latRad;
	}
	
	public double lonRadianToMeter(double x,double y){
		double lonRad = Math.sin(x)*radius*y;
		return lonRad;
	}
	

	/**
	 * computes the 3D vector (in meters) between two gps like points
	 * @param gps1, gps - vecton between two points
	 * @retrun vector
	 * 
	 */
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		
		Point3D gps2 = new Point3D(gps1.x()-gps0.x(),gps1.y()-gps0.y());
		Point3D gps_new = new Point3D(angles_meter(gps2,gps0).x(),angles_meter(gps2,gps0).y(),gps1.z()-gps0.z());
		
		
		return gps_new;
	}

	/**
	 * computes the polar representation of the 3D vector be gps0-->gps1 
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance*
	 * @param gps0 gps1
	 * @return array  with yaw pitch distance
	 */
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		
		double [] aed = new double[3];

		double a = gps1.north_angle(gps0);
		if(a<=90) a = 90;
		else a = 450-a;
		aed[0] = a;
		aed[1]=gps1.z()-gps0.z();
		aed[2]=distance3d(gps0,gps1);
		return aed;
	}

	/**
	 * return true iff this point is a valid lat, lon , alt coordinate: [-180,+180],[-90,+90],[-450, +inf]
	 * @param p - piont inn test for validness
	 * return boolean
	 */
	public boolean isValid_GPS_Point(Point3D p) {
		 	boolean flag = true;
		 	if(p.x()>180||p.x()<-180){
		 		flag=false;
		 		
		 	}
		 	if(p.y()>90||p.y()<-90){
		 		flag= false;
		 			
		 	}
		 	if(p.z()<-450){
		 		flag=false;
		 	}
		return flag;
	}
	
	

}
