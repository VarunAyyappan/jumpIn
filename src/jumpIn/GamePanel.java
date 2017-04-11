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
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener 
{
	// For frog image
	private Image frogImg;
	private String frogImgName;
	private int frogX, frogY, vx, vy;
	
	private int boundary;
	
	public GamePanel(int sizeXIn, int sizeYIn) 
	{
		frogImgName = "src/files/22494_Flipped.png";    // get rid of src/files/ in school
		getMyImage();
		
		frogX = 0;
		frogY = 0;
		vx = 5;
		vy = 5;
		
		boundary = sizeXIn;
		
		setLocation(0, 0);
		setSize(sizeXIn, (sizeYIn/3)*2);
		//setBackground(Color.LIGHT_GRAY);
	}
	
	public void getMyImage()
	{
		try
		{
			frogImg = ImageIO.read(new File(frogImgName));
		}
		catch(IOException e)
		{
			System.err.println("\n\nERROR: "+frogImgName+" can't be found.\n\n");
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(frogImg, frogX, frogY, frogX+95, frogY+65, 340, 0, 435, 65, this);
	}
	
	// KeyListener method
	public void keyPressed(KeyEvent e) 
	{
		int code = e.getKeyCode();
		
		if(code==e.VK_A && frogX>0)
			frogX-=vx;
		else if(code==e.VK_D && frogX+95<boundary)
			frogY+=vx;
		repaint();
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
}
