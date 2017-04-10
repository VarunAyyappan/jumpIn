/*
 * Varun Ayyappan
 * 04/09/2017
 * Period 1
 * 
 * MainMenu.java
 * 
 * The class that holds and sets up the main menu.
 */

package jumpIn;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements ActionListener
{
	private JumpIn jiRef;
	private JButton playButton;
	private JButton dirButton;
	
	public MainMenu(JumpIn jiRefIn) 
	{
		jiRef = jiRefIn;
		playButton = new JButton("Play Game");
		dirButton = new JButton("Directions");
		
		add(playButton);
		add(dirButton);
		
		playButton.addActionListener(this);
		dirButton.addActionListener(this);
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		playButton.setLocation(200, 200);
		playButton.setSize(100, 50);
		dirButton.setLocation(200, 400);
		dirButton.setSize(100, 50);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Font font = new Font("SansSerif", Font.BOLD, 50);
		g.setFont(font);
		
		g.drawString("Jump In!", 50, 50);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(playButton))
			jiRef.shift(2);
		else if(e.getSource().equals(dirButton))
			jiRef.shift(3);
	}
}

