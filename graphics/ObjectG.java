package graphics;

import java.awt.Graphics2D;


public abstract class ObjectG extends core.Object{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	protected Utils graphics = Utils.getInstace();
	//====================================================================CONSTRUCTORS
	//====================================================================FUNCTIONS
	protected abstract void paint(Graphics2D g2d);
	
}
