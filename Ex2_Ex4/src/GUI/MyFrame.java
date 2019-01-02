package GUI;

/**
/**
 * this calss provide us option to create the myframe for the game
 * @author Raam Banin and sapir gofshtein
 */
 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Algo.ShortestPathAlgo;
import GIS.Fruits;
import GIS.Game;
import GIS.Packman;
import Geom.Point3D;
import GIS.packmanTime;

/**
 * 
 * @author Raam Banin and sapir gofshtein
 * 
 *
 */

public class MyFrame extends JFrame implements MouseListener {

	private BufferedImage myPicture;
	private BufferedImage IconPackman;
	private BufferedImage IconFruit;
	
	private boolean boolPackman = false;
	private boolean boolFruit = false;
	
	private int idPackman=0;
	private int idFruit=0;
	
	private Game game;
	private ShortestPathAlgo spa;
	

	
	public MyFrame() 
	{
		initGUI();
		this.game = new Game();
		this.spa = new ShortestPathAlgo(game);
		
		this.addMouseListener(this); 
	}
	
	private void initGUI() 
	{
		
		JFrame jf = new JFrame();
		
		MenuBar menuBar = new MenuBar();
		Menu add = new Menu("Add");
		Menu run = new Menu("Run");
		Menu clear = new Menu("Clear");
		
		MenuItem addPackman = new MenuItem("Add Packman");
		MenuItem addFruit = new MenuItem("Add Fruit");
		MenuItem runGame = new MenuItem("Run Game");
		MenuItem runCsv = new MenuItem("Run Csv");
		MenuItem clearGame = new MenuItem("Clear Game");
		
		menuBar.add(add);
		menuBar.add(run);
		menuBar.add(clear);
		
		add.add(addPackman);
		add.add(addFruit);
		run.add(runGame);
		run.add(runCsv);
		clear.add(clearGame);
		
		
		runGame.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				spa = new ShortestPathAlgo(game);
				spa.pathGame();
			}
		});
		
		runCsv.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				JButton open = new JButton();
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new java.io.File("þþDocuments"));
				fileChooser.setDialogTitle("run Csv");
				if(fileChooser.showOpenDialog(open)==JFileChooser.APPROVE_OPTION) {
					repaint();
				}
				if(fileChooser.getSelectedFile().getAbsolutePath().endsWith(".csv")) {
					game.Csv2Game(fileChooser.getSelectedFile().getAbsolutePath());
					repaint();
				}
				else JOptionPane.showMessageDialog(null, "Please try again");
			}
		});
		
		addPackman.addActionListener(new ActionListener() {	//Drawing pacmans.
			public void actionPerformed(ActionEvent e) {
				boolFruit = false ;
				if(boolPackman == true)
					boolPackman = false;
				else if(boolPackman == false)
					boolPackman = true ;
				repaint();
			}
		});

		addFruit.addActionListener(new ActionListener() {	//Drawing fruits
			public void actionPerformed(ActionEvent e) {
				
				boolPackman = false ;
				if(boolFruit == true)
					boolFruit = false ;
				else if(boolFruit == false)
					boolFruit = true ;
				repaint();
			}
		});
		
		clear.addActionListener(new ActionListener() {	//Clearing The screen from the Images
			public void actionPerformed(ActionEvent e) {
				game.getPackmans().clear();
				game.getFruits().clear();
				repaint();
			}
		});
		
		this.setMenuBar(menuBar);
		
		try {
			myPicture = ImageIO.read(new File("C:\\Users\\Raam Banin\\git\\Ex2_Ex4p\\Ex2_Ex4\\picture\\Ariel1.png"));}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			IconPackman=ImageIO.read(new File("C:\\Users\\Raam Banin\\git\\Ex2_Ex4p\\Ex2_Ex4\\picture\\packman.png"));}
		catch (Exception e) {
			e.printStackTrace();}

		try {
			IconFruit = ImageIO.read(new File("C:\\Users\\Raam Banin\\git\\Ex2_Ex4p\\Ex2_Ex4\\picture\\fruit.png"));}
		catch (Exception e) {
			e.printStackTrace();}
		
		
		
	}
	
	
	
	public void paint(Graphics g)
	{
		g.drawImage(myPicture, 8,53, this.getWidth()-16,this.getHeight()-61,this);
		if(game.getPackmans()!=null) {
			Iterator<Packman> itemPackman = game.getPackmans().iterator();
			
			if(game.getFruits()!=null) {
				Iterator<Fruits> itemFruit=game.getFruits().iterator();
				
				while(itemPackman.hasNext()) {
					Packman temp=itemPackman.next();
					g.drawImage(IconPackman, (int)temp.getPoint().x(), (int)temp.getPoint().y(),IconPackman.getWidth(),IconPackman.getHeight(), this);
				}
				while(itemFruit.hasNext()) {
					Fruits temp = itemFruit.next();
					g.drawImage(IconFruit, (int)temp.getPoint().x(), (int)temp.getPoint().y(),IconFruit.getWidth(),IconFruit.getHeight(), this);
				}
			}
		}
		
	}
	

	public void mouseClicked(MouseEvent e) {
		
		if(boolPackman == true)
			{
				Packman packman = new Packman(idPackman, e.getX(),e.getY() ,0 , 1 ,1);
				idPackman++;
				System.out.println("new pacman added with ID :  "+idPackman);
				System.out.println("(" +  e.getX()+","+e.getY()+")");
				game.getPackmans().add(packman);					
				repaint();
			}
			
			if(boolFruit == true)
			{
				Fruits fruit = new Fruits(idFruit,e.getX() ,e.getY(), 0,1);
				idFruit++;
				System.out.println("new fruit added with ID :  "+idFruit);
				System.out.println("(" +  e.getX()+","+e.getY()+")");
				game.getFruits().add(fruit);					
				repaint();
			}
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{
		MyFrame window = new MyFrame();
		window.setVisible(true);
		window.setSize(window.myPicture.getWidth(),window.myPicture.getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}