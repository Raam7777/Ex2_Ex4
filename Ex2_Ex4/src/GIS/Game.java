package GIS;

import java.io.File;
import java.io.FileNotFoundException;
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

	public ArrayList<Fruits> ReadCsvFileF(String input) {

		ArrayList<Fruits> Csv = new ArrayList<Fruits>();
		File files = new File(input);
		Scanner sc = null;
		try {
			sc = new Scanner(files);
		}
		catch (FileNotFoundException exc) {
			exc.printStackTrace();
		}
		String in = sc.nextLine();
		while(sc.hasNext()) {
			in = sc.nextLine();
			String[] arr = in.split(",");
			if(arr[0].equals("F")) {
				Point3D point = new Point3D(Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]));
				Fruits line = new Fruits(point, Double.parseDouble(arr[5]),Integer.parseInt(arr[1]));
				Csv.add(line);
			}
		}
		sc.close();
		return Csv;
	}




	public ArrayList<Packman> ReadCsvFileP(String input) {

		ArrayList<Packman> Csv = new ArrayList<Packman>();
		File files = new File(input);
		Scanner sc = null;
		try {
			sc = new Scanner(files);
		}
		catch (FileNotFoundException exc) {
			exc.printStackTrace();
		}
		String in = sc.nextLine();
		while(sc.hasNext()) {
			in = sc.nextLine();
			String[] arr = in.split(",");
			if(arr[0].equals("P")) {
				Point3D point = new Point3D(Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]));
				Packman line = new Packman(point,Double.parseDouble(arr[5]),Double.parseDouble(arr[6]),Integer.parseInt(arr[1]));
				Csv.add(line);
			}
		}
		sc.close();
		return Csv;
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


}
