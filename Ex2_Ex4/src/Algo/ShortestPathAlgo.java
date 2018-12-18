package Algo;

import java.util.ArrayList;

import GIS.Fruits;
import GIS.Game;
import GIS.Packman;
import GIS.Path;
import GIS.packmanTime;
import Geom.Point3D;

public class ShortestPathAlgo {

	private Game game;
	private Path path;
	private long time;

	public ShortestPathAlgo(Game game){
		this.game = game;
		pathGame();
	}

	public void pathGame(){
		
		path = new Path(game);		
		ArrayList<Fruits> fruits = game.addAllFruits();
		ShortestPathComperator spc = new ShortestPathComperator();
		packmanTime pt = new packmanTime();
		
		while(fruits.size() > 0) {
		
			for(int i=0; i<path.getSize() && fruits.size()>0 ;i++) {
				Packman packman = path.getPathPackman(i); //���� ����� ������ �� ��������
				Point3D location = path.getLocation();//������ �� ������
				spc.ShortestPathC(fruits, location);//���� �� �������� �� ������ ����� ������ ������ �����
				packman.setTime(pt.time(fruits.get(0).getFruit()));//���� �� ���� ������ ����� �� ���� ������ ������ �����
				fruits.remove(0);//���� �� ���� ������ ���� ����� �� ��� ������ ����� ���� ������
			}
		}
		/*
		for(int i=0; i<path.getSize(); i++) {
			Packman packman = path.getPathPackman(i);		
			time = Math.max(time, packman.getTime());
		}
		*/
	}

	public Game getGame() {
		return game;
	}

	public Path getPath() {
		return path;
	}

	public long getTime() {
		return time;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	
	
	
}
