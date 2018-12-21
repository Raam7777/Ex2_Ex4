package GUI;

import org.omg.PortableServer.POA;

import Geom.Point3D;


public class Map {
	int StartingWidth =1377;
	int StartingHeiht = 642;
	double TopLeftLon =35.2;
	double TopLeftLat =32.1;
	double bottomRightLon = 35.12-TopLeftLon;
	double bottomRightLat = TopLeftLat- 32.06;
	
	public Map() {
		
	}
	public  double pixelDistance(Point3D pixX, Point3D pixY) {
		 int x1 =(int)CtP(pixX).x();
		 int y1 =(int)CtP(pixX).y();
		 int x2 =(int)CtP(pixY).x();
		 int y2 =(int)CtP(pixY).y();
		double res= Math.sqrt((Math.pow(x1-x2, 2))+(Math.pow(y1-y2, 2)));
		return res;
		
	}
	public  double pixelAngle(Point3D pixX, Point3D pixY) {
		 int x1 =(int)CtP(pixX).x();
		 int y1 =(int)CtP(pixX).y();
		 int x2 =(int)CtP(pixY).x();
		 int y2 =(int)CtP(pixY).y();
		 double rs = Math.toDegrees(Math.atan2(x2-x1, y2-y1));
		 if (rs<0) {
			 rs =rs +360;
			 
		 }
		 return rs;
	}
	
	public  Point3D PtC(int pixelX, int pixelY) {// coverting pixel to coords - source code borought from stackoverflow
		double latx =((pixelX/StartingWidth)*bottomRightLon);
		double lony= ((pixelY/StartingHeiht)*bottomRightLat);
		double coordsX =TopLeftLat-lony;
		double coordsY= TopLeftLon + latx;
		Point3D resault = new Point3D(coordsX,coordsY);
		return resault;
	}
	public Point3D CtP(Point3D ctp) { // coverting from coords to pixel - source code borought from stackoverflow
		
		double x =ctp.y()-TopLeftLon; 
		double y= TopLeftLat - ctp.x();
		int x1 =(int) ((StartingWidth)*(x)/bottomRightLon);
		int y1= (int) ((StartingHeiht)*(y)/bottomRightLat);
		if(x1<0)
			x1 = x1*(-1);
		if(y1<0)
			y1 = y1*(-1);
		Point3D resault2 = new Point3D(x1,y1);
		return resault2;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map m = new Map();
		Point3D p = new Point3D(35.2,32.1);
		System.out.println(m.CtP(p));
	}

}