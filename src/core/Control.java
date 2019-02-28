package core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

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
		if(initialRoom == null) {
			  initialRoom = new misc.DefaultRoom();	
		}
		if(instance == null){
			instance = new Control(initialRoom);
		}else {
			MainLoop.getInstance().setCurrentRoom(initialRoom);
		}

	}
	//returns the instance
	//must start first! else it will return null
	public static Control getInstance(){
		return instance;
	}
	//====================================================================FUNCTIONS
	//main
	public static void main( String[] args ) throws InstantiationException, IllegalAccessException, MalformedURLException, ClassNotFoundException{
		Room initialRoom = null;
		if(args.length>=2) {
			URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file:///"+args[0])}, Thread.currentThread().getContextClassLoader());
			Class<?> myClass = Class.forName(args[1], true, classLoader);
			initialRoom = (Room)myClass.newInstance();
			System.out.println(myClass.getName());
		}
		start(initialRoom);//set the starting room here if running this as main
	}
}
