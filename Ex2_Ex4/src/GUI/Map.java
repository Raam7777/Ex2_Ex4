package GUI;

import javax.swing.JFrame;

import org.omg.PortableServer.POA;

import Geom.Point3D;


public class Map 
{

	final int StartingWidth = 1433, StartingHeiht = 642;

	final double TopLeftLon =35.20238  , TopLeftLat = 32.106046;

	final double bottomRightLon = 35.21236-TopLeftLon; 

	double bottomRightLat = TopLeftLat-32.101658;
	Point3D RightDown = new Point3D(32.101073, 35.211922);
	Point3D LeftUp    = new Point3D(32.106199,35.201708);

	/**
	 * default constructor
	 */
	public Map()
	{

	}
	/**
	 * default constructor 
	 * @param StartingWidth - received width of the map
	 * @param StartingHeiht - received height of the map
	 */
	public Map(int StartingWidth,int StartingHeiht)
	{

	}
	/**
	 * 
	 * @param ctp - A point on the surface which will be received with coordinate values.
	 * @return the value of the point - in pixel, calculated with a mathematical formula.
	 */
	public Point3D CtP(Point3D ctp)//The source code:https://stackoverflow.com/questions/38748832/convert-longitude-and-latitude-ctp-to-image-of-a-map-pixels-x-and-y-coor
	{
		double x,y;
		x=ctp.y() - TopLeftLon;

		y = TopLeftLat-ctp.x();

		int x1 = (int) (StartingWidth*(x/bottomRightLon));
		int y1 = (int) (StartingHeiht*(y/bottomRightLat));
		if(x1<0) {
			x1+=360;
		}
		if(y1<0) {
			y1+=360;
		}
		return new Point3D(x1,y1);

	}
	/**
	 * 
	 * @param PointWidth - the X value of the point in pixels
	 * @param PointHeight - the Y value of the point in pixels
	 * @param widthMap - the width of the map we will receive
	 * @param hightMap - the height of the map we will receive
	 * @return - after making the convert with the requested calculations, we will return the point with suitable 
	 *           coordinate values.
	 */
	public Point3D PtC(int PointWidth, int PointHeight,int widthMap,int hightMap) {
		double coordsY = (((hightMap-(double)PointHeight)*RightDown.y())+((double)PointHeight*LeftUp.y()))/hightMap;
		double coordsX = (((widthMap-(double)PointWidth)*RightDown.x())+((double)PointWidth*LeftUp.x()))/widthMap;
		Point3D result =new Point3D(coordsX,coordsY);

		return result;
	}

	/**
	 * 
	 * @param p1 - first point we will receive (GPS)
	 * @param p2 - second point we will receive (GPS)
	 * @return - distance in meters between the points 
	 */

	public  double pixelDistance(Point3D pixX, Point3D pixY) {
		 int x1 =(int)CtP(pixX).x();
		 int y1 =(int)CtP(pixX).y();
		 int x2 =(int)CtP(pixY).x();
		 int y2 =(int)CtP(pixY).y();
		double res= Math.sqrt((Math.pow(x1-x2, 2))+(Math.pow(y1-y2, 2)));
		return res;
	}
	/**
	 * 
	 * @param point1 - first point we will receive (GPS)
	 *
	 * @param point2 - second point we will receive (GPS)
	 * @return - The angle values located between the points   
	 */
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
	
	public static void main(String[] args)
	{
		Map m = new Map();
		Point3D p = new Point3D(32,30,0);
		Point3D p1 = new Point3D(32,30,0);
		System.out.println(m.CtP(p));
	}

}