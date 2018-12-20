package GIS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Geom.Point3D;

public class Game {

	private ArrayList<Fruits> fruits;
	private ArrayList<Packman> packmans;	

	public Game() {
		fruits = new ArrayList<Fruits>();
		packmans = new ArrayList<Packman>();
	}

	public Game(ArrayList<Packman> p, ArrayList<Fruits> f) {
		Iterator<Packman> it_p = p.iterator();
		while(it_p.hasNext()) {
			packmans.add(it_p.next());
		}

		Iterator<Fruits> it_f = f.iterator();
		while(it_f.hasNext()) {
			fruits.add(it_f.next());
		}
	}
	
	public static Game Csv2Game(String input) {
		
		Game game = new Game(); 
		String line = "";		
		 
		try {
			BufferedReader br = new BufferedReader(new FileReader(input));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				String name = arr[0];
				
				if(name.equals("P")) {
					int id = Integer.parseInt(arr[1]);
					Point3D point = new Point3D(Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]));
					double speed = Integer.parseInt(arr[5]);
					double radius = Integer.parseInt(arr[6]);
		
					Packman packman = new Packman(point,radius,speed,id);
					game.addPackman(packman);
					
				}else if(name.equals("F")) {
					int id = Integer.parseInt(arr[1]);
					Point3D point = new Point3D(Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]));
					double weight = Integer.parseInt(arr[5]);
					
					
					Fruits fruit = new Fruits( id,point,weight);
					game.addFruits(fruit);
					
				}
			}
			
			br.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return game;
	}
	

	public void addFruits(Fruits f){
		fruits.add(f);
	}
	
	public void addPackman(Packman p){
		packmans.add(p);
	}
	
	public Iterator<Fruits> iteratorFruit(){
		return fruits.iterator();
	}
	
	public Iterator<Packman> iteratorPackman(){
		return packmans.iterator();
	}
	
	public int sizeFruits(){
		return fruits.size();
	}
	
	public int sizePackman(){
		return packmans.size();
	}
	
	public Fruits getFruits(int index) {
		return fruits.get(index);
	}
	
	public Packman getPackmen(int index) {
		return packmans.get(index);
	}

	public ArrayList<Fruits> getFruits() {
		return fruits;
	}

	public ArrayList<Packman> getPackmans() {
		return packmans;
	}

	public void setFruits(ArrayList<Fruits> fruits) {
		this.fruits = fruits;
	}

	public void setPackmans(ArrayList<Packman> packmans) {
		this.packmans = packmans;
	}
	
	public ArrayList<Fruits> addAllFruits(){
		ArrayList<Fruits> listF = new ArrayList<Fruits>();
		listF.addAll(fruits);
		return listF;
	}
	
	public ArrayList<Packman> addAllPackmans(){
		ArrayList<Packman> listPack = new ArrayList<Packman>();
		listPack.addAll(packmans);
		return listPack;
	}


}
