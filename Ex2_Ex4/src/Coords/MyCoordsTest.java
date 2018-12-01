package Coords;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import Geom.Point3D;

public class MyCoordsTest {
/*
	@Test
	public void testAdd() {
		MyCoords test = new MyCoords();
		Point3D gps0 = new Point3D(32.103315,35.209039,670);
		Point3D gps1 = new Point3D(337.6989921,-359.2492069,-20);
		Point3D gps2 = new Point3D(32.10635200000035,35.20580819426608,650.0);
		Point3D gps = test.add(gps0,gps1);
		if(gps!=gps2)
			fail("Not yet implemented");
	}
*/
	@Test
	public void testDistance3d() {
		MyCoords test = new MyCoords();
		Point3D gps0 = new Point3D(32.103315,35.209039,670);
		Point3D gps1 = new Point3D(32.106352,35.205225,650);
		double dist = test.distance3d(gps0,gps1);
		if(dist!=493.0474727777458)
			fail("Not yet implemented");
	}

	@Test
	public void testVector3D() {
		MyCoords test = new MyCoords();
		Point3D gps0 = new Point3D(32.103315,35.209039,670);
		Point3D gps1 = new Point3D(337.6989920612881,-359.24920693881893,-20.0);
		Point3D gps2 = new Point3D(32.106352,35.205225,650);;
		Point3D vec= (test.vector3D(gps0, gps2));
		assertEquals(vec.x(), gps1.x(), 1);
	}

	@Test
	public void testAzimuth_elevation_dist() {
		MyCoords test = new MyCoords();
		Point3D gps0 = new Point3D(32.103315,35.209039,670);
		Point3D gps1 = new Point3D(337.6989920612881,-359.24920693881893,-20.0);
		Point3D gps2 = new Point3D(32.106352,35.205225,650);
		assertEquals(test.azimuth_elevation_dist(gps0, gps2)[0], 128.52949903084226, 1);
		assertEquals(test.azimuth_elevation_dist(gps0, gps2)[1], -20, 1);
		assertEquals(test.azimuth_elevation_dist(gps0, gps2)[2], 493.0474727777458, 1);
	}

	@Test
	public void testIsValid_GPS_Point() {
		MyCoords test = new MyCoords();
		Point3D gps0 = new Point3D(32.103315,35.209039,670);
		assertThat(gps0.x(), true);
	}

	private void assertThat(double x, boolean b) {
		// TODO Auto-generated method stub

	}

}
