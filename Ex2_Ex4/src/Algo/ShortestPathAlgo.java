package Algo;

import java.util.ArrayList;
import java.util.Iterator;

import GIS.Fruits;
import GIS.Game;
import GIS.Packman;
import GIS.Path;
import Geom.Point3D;

public class ShortestPathAlgo {

	ArrayList<Path> paths;
	
	public ShortestPathAlgo(Game game){
		paths = new ArrayList<Path>();
		pathGame(game);
	}
	
	public void pathGame(Game game){
		
		ArrayList<Fruits> fruits = new ArrayList<Fruits>(game.getFruits());
		Iterator<Packman> itPackman = game.getPackmans().iterator();
		while(itPackman.hasNext()) {
			paths.add(new Path(itPackman.next()));
		}
		
		while(!fruits.isEmpty()){
			Iterator<Path> itPaths = paths.iterator();
			while(itPaths.hasNext()){
				Path thisPath = itPaths.next();
				
				
			}
		}
		
		
	}
	
	
	
}
