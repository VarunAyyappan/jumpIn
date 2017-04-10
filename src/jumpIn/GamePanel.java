/*
 * Varun Ayyappan
 * 04/09/2017
 * Period 1
 * 
 * GamePanel.java
 * 
 * The class that sets up top portion of main game panel.
 * This is where the player will see the character in a stage and directly
 * control it.
 */

package jumpIn;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel 
{

	public GamePanel(int sizeXIn, int sizeYIn) 
	{
		setLocation(0, 0);
		setSize(sizeXIn, (sizeYIn/3)*2);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//setBackground(Color.LIGHT_GRAY);
	}
	
}
