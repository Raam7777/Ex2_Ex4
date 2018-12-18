package Algo;

import java.util.ArrayList;
import java.util.Comparator;

import Coords.MyCoords;
import GIS.Fruits;
import Geom.Point3D;

public class ShortestPathComperator implements Comparator<Fruits>{

	MyCoords coords = new MyCoords();

	public void ShortestPathC(ArrayList<Fruits> fruits,Point3D location){

		fruits.sort(new Comparator<Fruits>() {

			@Override
			public int compare(Fruits f0, Fruits f1) {
				double distanceF1 = coords.distance3d(location, f0.getFruit());
				double distanceF2 = coords.distance3d(location, f1.getFruit());

				if(distanceF1 - distanceF2 < 0) {
					return -1;
				}else if(distanceF1 - distanceF2 > 0){
					return 1;
				}else {
					return 0;
				}
			}
		});



	}

	@Override
	public int compare(Fruits o1, Fruits o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
