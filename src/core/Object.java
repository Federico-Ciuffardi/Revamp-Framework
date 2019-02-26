package core;

public abstract class Object {
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	protected Utils core = Utils.getInstace();
	//====================================================================CONSTRUCTORS
	//====================================================================FUNCTIONS
	//executes periodically, deltaT is the time on seconds since the last tick
	void tickBase(float deltaT){
		tick(deltaT);
	}
	//============================================================user defined
	//for the user to implement what's happening each tick
	protected abstract void tick(float deltaT);
}
