package GIS;

import java.util.ArrayList;
import java.util.Iterator;

import Geom.Point3D;



public class Path {

	private Packman packman;
	private ArrayList<Fruits> fruits;
	
	public Path(Packman p){
		packman = new Packman(p);
		fruits = new ArrayList<Fruits>();
	}
	
	public Path(Packman p, ArrayList<Fruits> fruit) {
		packman = new Packman(p);
		fruits = new ArrayList<Fruits>();
		Iterator<Fruits> itFruit = fruit.iterator();
		while(itFruit.hasNext()) {
			fruits.add(itFruit.next());
		}
	}
	
	public double Time( ArrayList<Fruits> fruit){
		fruits = new ArrayList<Fruits>();
		Iterator<Fruits> itFruit = fruit.iterator();
		double time= packman.getPoint().distance2D(itFruit.next().getFruit())/packman.getSpeed();
		double timeSmall=0;
		while(itFruit.hasNext()) {
			if(time<packman.getPoint().distance2D(itFruit.next().getFruit())/packman.getSpeed()){
				timeSmall = time;
			}
			else{
				time = packman.getPoint().distance2D(itFruit.next().getFruit())/packman.getSpeed();
				timeSmall=time;
			}
		}
		return timeSmall;
	}

	public Packman getPackman() {
		return packman;
	}

	public ArrayList<Fruits> getFruits() {
		return fruits;
	}

	public void setPackman(Packman packman) {
		this.packman = packman;
	}

	public void setFruits(ArrayList<Fruits> fruits) {
		this.fruits = fruits;
	}
	
	
}
