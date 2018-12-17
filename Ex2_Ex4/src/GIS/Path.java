package GIS;

import java.util.ArrayList;
import java.util.Iterator;



public class Path {

	private Packman packman;
	private ArrayList<Fruits> fruits;
	

	public Path(Packman p, ArrayList<Fruits> fruit) {
		packman = new Packman(p);
		fruits = new ArrayList<Fruits>();
		Iterator<Fruits> itFruit = fruit.iterator();
		while(itFruit.hasNext()) {
			fruits.add(itFruit.next());
		}
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
