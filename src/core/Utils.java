package core;

public class Utils{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	private static Utils instance; 
	protected core.Control core = Control.getInstance();
	//====================================================================CONSTRUCTORS
	protected Utils() {}
	//====================================================================FUNCTIONS
	public static Utils getInstace() {
		if(instance == null) {
			instance = new Utils();
		}
		return instance;
	}
	//changes the current room to room
	public void setCurrentRoom(Room room){
		MainLoop.getInstance().setCurrentRoom(room);
	}
	//gets current room
	public Room getCurrentRoom(){
		return MainLoop.getInstance().getCurrentRoom();
	}
	public int getTPS() {
		return MainLoop.getInstance().getTPS();
	}
}
