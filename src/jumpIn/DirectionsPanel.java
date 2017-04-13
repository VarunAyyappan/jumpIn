/*
 * Varun Ayyappan
 * 04/09/2017
 * Period 1
 * 
 * DirectionsPanel.java
 * 
 * The class that sets up and holds the direction panel.
 */

package jumpIn;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DirectionsPanel extends JPanel implements ActionListener
{
	private JumpIn jiRef;
	private JButton backToMM;

	//Initialize field variables and 
	public DirectionsPanel(JumpIn jiRefIn, int sizeXIn, int sizeYIn)
	{
		jiRef = jiRefIn;
		backToMM = new JButton("Back To Main Menu");
		
		add(backToMM);
		backToMM.addActionListener(this);
		
		setBackground(Color.GREEN);
		setLayout(null);
		backToMM.setSize(400, 100);
		backToMM.setLocation((sizeXIn/2)-(backToMM.getWidth()/2), sizeYIn-(backToMM.getHeight()+50));
	}
	
	// Paints panel
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Font font = new Font("SansSerif", Font.BOLD, 50);
		g.setFont(font);
		
		g.setColor(Color.BLUE);
		g.drawString("Directions: ", 0, 50);
	}
	
	// From ActionListener
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(backToMM))
			jiRef.shift(1);
	}
	
	
	
}
