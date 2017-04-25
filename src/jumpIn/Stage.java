/*
 * Varun Ayyappan
 * 04/24/2016
 * Stage.java
 * 
 * Creates and draws the stage for the character to go through.
 */


package jumpIn;

import java.awt.Color;
import java.awt.Graphics;

public class Stage 
{	
	private int dotRadius;
	
	private boolean solved;
	
	private GamePanel gpRef;
	
	public Stage(GamePanel gpRefIn)
	{
		dotRadius = 10;
		solved = false;
		gpRef = gpRefIn;
	}
	
	public void draw(Graphics g) 
	{
		if(!solved)
		{
			g.setColor(Color.YELLOW);
			g.fillOval(290, 355, dotRadius, dotRadius);
			g.drawString("(10,0)", 300, 345);
			g.fillOval(350, 300, dotRadius, dotRadius);
			g.drawString("(5,5)", 360, 290);
			g.fillOval(420, 355, dotRadius, dotRadius);
			g.drawString("(15,0)", 420, 345);
			
			solved = true;
		}
		else
		{
			g.setColor(Color.YELLOW);
			g.drawArc(300, 310, 120, 100, 0, 180);
		}
		
	}
	
}
