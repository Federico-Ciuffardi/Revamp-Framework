package test;

import java.awt.Graphics2D;

public class ButtonO extends graphics.ObjectG{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	int x;
	int y;
	int vX = (new java.util.Random()).nextInt(3)-1;
	int vY = (new java.util.Random()).nextInt(3)-1;
	boolean dir= true;
	int type;
	//====================================================================CONSTRUCTORS
	public ButtonO() {
		x = (new java.util.Random()).nextInt(graphics.getWidth());
		y = (new java.util.Random()).nextInt(graphics.getHeight());
	}
	//====================================================================FUNCTIONS
	protected void tick(float deltaT){
		if(x>graphics.getWidth() || x<0) {
		  vX = -vX;
		}
		if(y>graphics.getHeight() || y<0) {
			  vY = -vY;
		}
		x += vX;
		y += vY;
	}
	@Override
	protected void paint(Graphics2D g2D) {
		g2D.drawRect(x, y, 50, 70);
	}
}
