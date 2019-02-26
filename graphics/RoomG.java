package graphics;

import java.awt.Graphics2D;

public abstract class RoomG extends core.Room{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	protected Utils graphics = Utils.getInstace();
	//====================================================================CONSTRUCTORS
	//====================================================================FUNCTIONS
	protected abstract void paint(Graphics2D g2d);
}
