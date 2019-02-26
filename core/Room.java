package core;

import java.util.HashSet;
import java.util.Set;

import com.github.federico_ciuffardi.util.BinSemaphore;

public abstract class Room{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	public BinSemaphore objMutex = new BinSemaphore();
	protected Utils core = Utils.getInstace();
	private Set<Object> objects = new HashSet<Object>();
	private Set<Object> objectsToAdd = new HashSet<Object>();
	private Set<Object> objectsToRemove = new HashSet<Object>();
	//====================================================================CONSTRUCTORS

	//====================================================================FUNCTIONS
	//executes periodically, deltaT is the time on seconds since the last tick
	void tickBase(float deltaT) {
		//first the ticks are processed
		tick(deltaT);
		for(Object obj:objects){
			obj.tickBase(deltaT);
		}
		//then the active objects are updated (added or removed)
		objMutex.acquire();
		for(Object obj:objectsToAdd){
			objects.add(obj);
		}
		objMutex.release();
		objectsToAdd.clear();
		for(Object obj:objectsToRemove){
			objects.remove(obj);
		}
		objectsToRemove.clear();
	}
	//add an object to the room
	public void addObject(Object obj){
		objectsToAdd.add(obj);		
	}
	//removes an object from the room
	public void removeObject(Object obj){
		objectsToRemove.remove(obj);		
	}

	public Set<Object> getObjects(){
		return objects;
	}
	//============================================================user defined
	//for the user to implement what's happening each tick
	protected abstract void tick(float deltaT);
}
