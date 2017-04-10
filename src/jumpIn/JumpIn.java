package jumpIn;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JumpIn 
{
	
	private JFrame jiFrame;
	private JPanel jiPanel;
	private InfoPanel iPanel;
	private GamePanel gPanel;
	private BorderLayout bl;
	
	private boolean gameOver;
	private int sizeX, sizeY;
	
	// Initialize field variables
	public JumpIn() 
	{
		jiFrame = new JFrame();
		jiPanel = new JPanel();
		iPanel = new InfoPanel();
		gPanel = new GamePanel();
		bl = new BorderLayout(5, 5);
		gameOver = false;
		sizeX = 1200;
		sizeY = 870;
	}
	
	// Instantiates instance of class and calls run
	public static void main(String[] args) 
	{
		JumpIn ji = new JumpIn();
		ji.run();
	}
	
	// Sets up basic graphics backbone
	public void run() 
	{
		jiFrame.setSize(sizeX, sizeY);
		jiFrame.setLocation(0, 0);
		jiFrame.setDefaultCloseOperation(jiFrame.EXIT_ON_CLOSE);
		jiFrame.setResizable(false);
		jiFrame.getContentPane().add(jiPanel);
		
		jiPanel.setLayout(bl);
		jiPanel.add(gPanel, bl.CENTER);
		jiPanel.add(iPanel, bl.SOUTH);
		
		jiFrame.setVisible(true);
	}
}
