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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DirectionsPanel extends JPanel implements ActionListener
{
	// For the return to menu button
	private JumpIn jiRef;
	private JButton backToMM;
	
	// To receive instructions from text file
	private Scanner inputFromFile;
	private boolean ifScanFailed;

	//Initialize field variables and 
	public DirectionsPanel(JumpIn jiRefIn, int sizeXIn, int sizeYIn)
	{
		jiRef = jiRefIn;
		backToMM = new JButton("Back To Main Menu");
		
		ifScanFailed = false;
		
		add(backToMM);
		backToMM.addActionListener(this);
		
		setBackground(Color.GREEN);
		setLayout(null);
		backToMM.setSize(400, 100);
		backToMM.setLocation((sizeXIn/2)-(backToMM.getWidth()/2), sizeYIn-(backToMM.getHeight()+50));
		createScanner();
	}
	
	// Sets up scanner to read file with directions,
	// Sets boolean that will put error on GUI if it fails
	public void createScanner()
	{
		String inFileName = "src/files/Directions.txt";// get rid of src/files/ in school
		File inFile = new File(inFileName);
		
		try
		{
			inputFromFile = new Scanner(inFile);
		}
		catch(FileNotFoundException e)
		{
			ifScanFailed = true;
		}
	}
	
	// Paints panel
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Font font = new Font("SansSerif", Font.BOLD, 50);
		Font dirFont = new Font("SansSerif", Font.BOLD, 15);
		g.setFont(font);
		
		g.setColor(Color.BLUE);
		g.drawString("Directions: ", 0, 50);
		
		if(ifScanFailed)
		{
			g.setColor(Color.RED);
			g.drawString("ERROR: Directions file not found.", 50, 250);
			g.drawString("Directions cannot be displayed as a result...", 50, 300);
		}
		else
		{	
			int currentY = 250;
			g.setColor(Color.BLACK);
			g.setFont(dirFont);
			
			while(inputFromFile.hasNext())
			{
				g.drawString(inputFromFile.nextLine(), 5, currentY);
				currentY+=50;
			}
			
			inputFromFile.reset();
			createScanner();
		}
	}
	
	// From ActionListener
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(backToMM))
			jiRef.shift(1);
	}
	
}
