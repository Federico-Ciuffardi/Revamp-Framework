package graphics;

import java.util.prefs.Preferences;
import javax.swing.JFrame;

//Provides the core control
@SuppressWarnings("serial")
class Frame extends JFrame{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	private int height;
	private int width;
	private Panel panel;
	//====================================================================CONSTRUCTORS
	Frame(){
		super("Revamp Framework");
		Preferences prefs = Preferences.userRoot().node("revamp-framework");
		width = prefs.getInt("width", 800);
		height = prefs.getInt("height", 600);
	    setDefaultCloseOperation( EXIT_ON_CLOSE);
	    setResizable(false);
	    setLayout(null);
	    panel = Panel.getInstance();
	    
	    panel.setBounds(0, 0, width, height);
	    add(panel);
	    //this.addMouseListener(new MouseHandler());
	    //this.addKeyListener(new KeyHandler());
	    setSize(width, height);
	    setVisible(true);
	}
	//==================================================================FUNCTIONS
	void nextFrame() {
		panel.repaint();
	}
}
