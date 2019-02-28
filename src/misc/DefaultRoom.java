package misc;

import java.awt.Graphics2D;

public class DefaultRoom extends graphics.RoomG{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	int x;
	int y;
	int vX = 1;
	int vY = 1;
	boolean dir= true;
	int type;
	//====================================================================CONSTRUCTORS
	public DefaultRoom() {
		x = 0;
		y = 0;
	}
	//====================================================================FUNCTIONS
	protected void tick(float deltaT){
		if(x+150>=graphics.getWidth() || x<0) {
		  vX = -vX;
		}
		if(y+150>=graphics.getHeight() || y<0) {
			  vY = -vY;
		}
		x += vX;
		y += vY;
	}
	@Override
	protected void paint(Graphics2D g2D) {
		g2D.drawRect(x, y, 150, 150);
		g2D.drawString("Revamp Framework",x+10, y+40);
		g2D.drawString("DEFAULT ROOM",x+10, y+80);
		g2D.drawString("TPS:"+core.getTPS(),x+10, y+130);
		
	}
}

