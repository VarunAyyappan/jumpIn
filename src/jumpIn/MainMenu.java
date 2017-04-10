/*
 * Varun Ayyappan
 * 04/09/2017
 * Period 1
 * 
 * MainMenu.java
 * 
 * The class that sets up graphics stuff.
 */

package jumpIn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements ActionListener
{
	private JButton playButton;
	private JButton dirButton;
	
	public MainMenu() 
	{
		playButton = new JButton();
		dirButton = new JButton();
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(Color.LIGHT_GRAY);
	}

	public void actionPerformed(ActionEvent e) 
	{
				
	}
}

