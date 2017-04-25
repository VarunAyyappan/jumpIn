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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener 
{
	// For frog image
	private Image frogImg;
	private String frogImgName;
	private int frogX, frogY, vx, vy;
	
	// For Animation
	private int timeSlice; 
	private Timer timer;
	private int boundary;
	private Stage stage;
	
	// Initialize field variables, set up timer, and change panel settings
	public GamePanel(int sizeXIn, int sizeYIn) 
	{
		frogImgName = "src/files/22494_Flipped.png";// get rid of src/files/ in school
		getMyImage();
		frogX = 0;
		setFrogY(300);
		vx = 10;
		vy = 10;
		
		timeSlice = 50;
		timer = new Timer(timeSlice, this);
		timer.setInitialDelay(200);
		timer.start();
		
		boundary = sizeXIn;
		stage = new Stage(this);
		
		setLocation(0, 0);
		setSize(sizeXIn, (sizeYIn/3)*2);
		setBackground(Color.CYAN);
		addKeyListener(this);
	}
	
	// Gets image, sends error message it it failed
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
	
	// Resets Frogs position to the beginning position
	public void resetFrog() {
		frogX = 0;
		setFrogY(300);
		requestFocusInWindow();
	}
	
	public int getFrogY() {
		return frogY;
	}

	public void setFrogY(int frogYIn) {
		frogY = frogYIn;
	}
	
	public int getFrogX() {
		return frogX;
	}

	public void setFrogX(int frogXIn) {
		frogX = frogXIn;
	}

	// Graphics happens here
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(frogImg, frogX, getFrogY(), frogX+95, getFrogY()+65, 340, 0, 435, 65, this);
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 365, boundary, 300);
		
		g.setColor(Color.BLACK);
		g.fillRect(300, 365, 120, 300);
		
		stage.draw(g);
	}
	
	// KeyListener methods
	public void keyPressed(KeyEvent e) 
	{
		int code = e.getKeyCode();
		
		if(code==e.VK_A && frogX>0)
			frogX-=vx;
		else if(code==e.VK_D && frogX+95<boundary)
			frogX+=vx;
		else if(code==e.VK_W)
		{
			for(int num=0; num<150; num++)
			{
				frogX++;
				if(num%10==0)setFrogY(getFrogY() - 25);
			}
			for(int num=150; num>0; num--)
			{
				frogX++;
				if(num%10==0)setFrogY(getFrogY() + 25);
			}
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
	// ActionListener method
	public void actionPerformed(ActionEvent e) 
	{
		repaint();
	}
	
}
