package GIS;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;



public class gisElement implements GIS_element {
	
	
	//--------------------private-------------------------\\
	private String [] csvLine;
	private Point3D point;
	private metaData data;
 
	//------------------------------------------------------\\
	
	
	/**
	 * constructor creates a point and metaData. 
	 * @param str - string.
	 */
	public gisElement(String str)
	{
		
		this.csvLine=str.split(",");
		this.data = new metaData(csvLine[0],csvLine[1],csvLine[2],csvLine[3],csvLine[4],csvLine[5],csvLine[9],csvLine[10]);
		this.point = new Point3D (Double.parseDouble(csvLine[6]),Double.parseDouble(csvLine[7]),Double.parseDouble(csvLine[8]));
		
	}
	
	//---------------------getter and setter----------------------\\
	
	public Point3D getPoint() {
		return point;
	}

	public metaData getmataData() {
		return data;
	}

	public void setPoint(Point3D point) {
		this.point = point;
	}



	public void setData(metaData data) {
		this.data = data;
	}

	//----------------------------------------------------------------\\

	/**
	 * @return point.
	 */
	public Geom_element getGeom(){
		return point;
	}
	
	/**
	 * @return metaData.
	 */
	public Meta_data getData(){
		return data;
	}
	
	/**
	 * convert the vector to the gps.
	 * @param vec - vector.
	 */
	public void translate(Point3D vec){
		MyCoords mc = new MyCoords();
		point = mc.add(point, vec);
	}

}
