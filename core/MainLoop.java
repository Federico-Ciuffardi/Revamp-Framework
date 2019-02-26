package core;
import loop.Looper;
import java.util.prefs.Preferences;

class MainLoop implements loop.ILoopeable{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	private int targetTPS;
	private Thread loopThread;
	private Room currentRoom;
	private static MainLoop instance;
	private IGraphics graphics = null;
	private Looper looper;
	//====================================================================CONSTRUCTORS
	private MainLoop(Room initialRoom, IGraphics g){
		if(initialRoom == null) {
			throw new IllegalArgumentException("initialRoom is null");
		}
		Preferences prefs =  Preferences.userRoot().node("revamp-framework");
		targetTPS = prefs.getInt("targetTPS", 60);
		
		setCurrentRoom(initialRoom);
		graphics = g;
		
		looper = new Looper(targetTPS,this);
		loopThread = new Thread(looper);
		loopThread.start();
	}
	//creates the first instance of MainLoop with it required parameter
	static void start(Room initialRoom,IGraphics g){
		if(instance == null){
			instance = new MainLoop(initialRoom,g);
		}
	}
	//returns the instance
	//must start first! else it will return null
	static MainLoop getInstance(){
		return instance;
	}
	//====================================================================FUNCTIONS
	//executes periodically, deltaT is the time on seconds since the last tick
	public void tick(float deltaT){
		currentRoom.tickBase(deltaT);
		if(graphics !=null) {
			graphics.nextFrame();
		}
	}
	//current tick per second
	int getTPS() {
		return looper.getTPS();
	}
	//changes the currentRoom to room
	void setCurrentRoom(Room room){
		currentRoom = room;
		//TODO maybe add something for the room to run before deleting
	}
	Room getCurrentRoom(){
		return currentRoom;
	}
}
