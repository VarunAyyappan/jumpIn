/*
 * Varun Ayyappan
 * 04/09/2017
 * Period 1
 * 
 * InfoPanel.java
 * 
 * The class that sets up graphics stuff.
 */

package jumpIn;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class InfoPanel extends JPanel 
{

	public InfoPanel() 
	{
		//setSize(sizeX, 300);
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(Color.LIGHT_GRAY);
	}

}
