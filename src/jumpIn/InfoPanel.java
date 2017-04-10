/*
 * Varun Ayyappan
 * 04/09/2017
 * Period 1
 * 
 * InfoPanel.java
 * 
 * The class that sets up the bottom portion of the main game panel.
 * This will hold the variety of info the player needs in game and
 * the input for the math problems.
 */

package jumpIn;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class InfoPanel extends JPanel 
{

	public InfoPanel(int sizeXIn, int sizeYIn) 
	{
		setLocation(0, (sizeYIn/3)*2);
		setSize(sizeXIn, sizeYIn/3);
		setBackground(Color.LIGHT_GRAY);
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}

}
