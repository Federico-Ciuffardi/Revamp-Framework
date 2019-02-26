package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Set;
import javax.swing.JPanel;

//Provides the core control
@SuppressWarnings("serial")
class Panel extends JPanel{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	private core.Utils coreU = core.Utils.getInstace();
	private static Panel instance;
	//====================================================================CONSTRUCTORS
	private Panel(){}
	//==================================================================FUNCTIONS
	public static Panel getInstance() {
		if(instance == null) {
			instance = new Panel();
		}
		return instance;
	};
    @Override
    public void paintComponent(Graphics g) {
       super.paintComponent(g);     // paint parent's background
       Graphics2D g2D = (Graphics2D) g;
       //g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); 
       core.Room room =  coreU.getCurrentRoom();
       if(room instanceof RoomG) {
    	   RoomG rD = (RoomG) room;	
    	   rD.paint(g2D);
       }
       room.objMutex.acquire();
       Set<core.Object> objects =room.getObjects();
       for(Object o: objects) {
    	   if(o instanceof ObjectG) {
    		   ObjectG oD = (ObjectG) o;
    		   oD.paint(g2D);
    	   }
       }
       room.objMutex.release();
       getToolkit().sync();
    }
}
