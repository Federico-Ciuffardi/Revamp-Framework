package loop;

//A Looper must be created with a Loopeable object so it can run the tick operation each time
public interface ILoopeable{
	//====================================================================FUNCTIONS
	public abstract void tick(float deltaT);
}
