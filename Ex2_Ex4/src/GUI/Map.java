package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.omg.PortableServer.POA;

import Geom.Point3D;

public class Map {
	private static final int StartingWidth =1377;
	private static final int StartingHeiht = 642;
	
	private static final double TopLeftLon =35.2;
	private static final double TopLeftLat =32.1;
	private static final double bottomRightLon = 35.12-TopLeftLon;
	private static final double bottomRightLat = TopLeftLat- 32.06;
	
	private BufferedImage image;
	
	public Map() throws IOException {
		File imageFile = new File("Ariel1.png");
		this.image = ImageIO.read(imageFile);	
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
		Point3D resault2 = new Point3D(x1,y1);
		return resault2;
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}