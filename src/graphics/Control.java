package graphics;

//Provides the core control
public class Control implements core.IGraphics{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	private Frame frame;
	private static Control instance = null;
	//====================================================================CONSTRUCTORS
	private Control(){
		frame = new Frame();
		
	}
	//returns the instance
	public static Control getInstance(){
		if(instance == null){
			instance = new Control();
		}
		return instance;
	}
	//====================================================================FUNCTIONS
	public void nextFrame() {
		frame.nextFrame();
	}
}
