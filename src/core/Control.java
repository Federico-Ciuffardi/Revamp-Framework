package core;

//Provides the core control
public class Control{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	private static Control instance = null;
	//====================================================================CONSTRUCTORS
	private Control(Room initialRoom){
		MainLoop.start(initialRoom, graphics.Control.getInstance());	 
	}
	//creates the first instance of control with it required parameter
	public static void start(Room initialRoom){
		if(instance == null){
			instance = new Control(initialRoom);
		}
	}
	//returns the instance
	//must start first! else it will return null
	public static Control getInstance(){
		return instance;
	}
	//====================================================================FUNCTIONS
	//main
	public static void main( String[] args ){
		start(new test.MainScreenR());//set the starting room here if running this as main
	}
}
