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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InfoPanel extends JPanel implements ActionListener 
{
	private GamePanel gpRef;
	private JButton refresh;
	
	// Initialize field variables and change panel settings
	public InfoPanel(GamePanel gpRefIn, int sizeXIn, int sizeYIn) 
	{
		gpRef = gpRefIn;
		refresh = new JButton("Refresh");
		
		add(refresh);
		refresh.addActionListener(this);
		
		setLayout(null);
		setLocation(0, (sizeYIn/3)*2);
		setSize(sizeXIn, sizeYIn/3);
		setBackground(Color.LIGHT_GRAY);
		refresh.setLocation(10, 10);
		refresh.setSize(100, 50);
	}
	
	// Paints panel
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}

	// From ActionListener
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(refresh))
			gpRef.resetFrog();
	}

}
