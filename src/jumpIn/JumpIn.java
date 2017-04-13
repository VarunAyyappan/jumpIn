/*
 * Varun Ayyappan
 * 04/09/2017
 * Period 1
 * 
 * JumpIn.java
 * 
 * The class that sets up graphics. Has JFrame and main JPanel that shows
 * appropriate panel by selecting the necessary card.
 * 
 */

package jumpIn;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JumpIn 
{
	
	private JFrame jiFrame;      // The frame
	private JPanel jiPanel;      // Main Panel that holds other panel in cards
	private MainMenu mmPanel;      // In jiPanel
	private JPanel mgPanel;        // In jiPanel
	private InfoPanel iPanel;      // In mgPanel
	private GamePanel gPanel;      // In mgPanel
	private DirectionsPanel dPanel;   // In jiPanel
	private CardLayout cards;
	
	private final String MAIN_MENU, GAME_PANEL, DIRECTION_PANEL;  // For CardLayout
	private int sizeX, sizeY;   // Size of frame
	
	// Initialize field variables
	public JumpIn() 
	{
		sizeX = 1200;
		sizeY = 870;
		
		jiFrame = new JFrame();
		jiPanel = new JPanel();
		mmPanel = new MainMenu(this);
		mgPanel = new JPanel();
		iPanel = new InfoPanel(sizeX, sizeY);
		gPanel = new GamePanel(sizeX, sizeY);
		dPanel = new DirectionsPanel(this, sizeX, sizeY);
		cards = new CardLayout();
		
		MAIN_MENU = "Card with Main Menu";
		GAME_PANEL = "Card with GamePanel";
		DIRECTION_PANEL = "Card with Directions";
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
		
		jiPanel.setLayout(cards);
		jiPanel.add(mmPanel, MAIN_MENU);
		jiPanel.add(mgPanel, GAME_PANEL);
		jiPanel.add(dPanel, DIRECTION_PANEL);
		
		mgPanel.setLayout(null);
		mgPanel.add(gPanel);
		mgPanel.add(iPanel);
		
		jiFrame.setVisible(true);
	}
	
	// Call this when it is necessary to shift to another card
	public void shift(int selection) 
	{
		if(selection == 1)
			cards.show(jiPanel, MAIN_MENU);
		else if(selection == 2)
		{
			cards.show(jiPanel, GAME_PANEL);
			gPanel.requestFocus();
		}
		else if(selection == 3)
			cards.show(jiPanel, DIRECTION_PANEL);
	}
	
}
