package loop;

public class Looper implements Runnable{
	//===================================================================CONSTANTS
	private final long SEC_TO_NANOSEC = 1000000000;
	//===================================================================VARIABLES
	private long targetTimeBetweenTicks;
	private long lastNanoSecondTick;
	private long lastSecond;
	private long actualNanosecond;
	private int preTPS;
	private int TPS;
	private ILoopeable loopeable;
	//====================================================================CONSTRUCTORS
	public Looper(int targetTPS, ILoopeable loopeable){
		setTargetTPS(targetTPS);
		this.loopeable = loopeable;
	}
	//====================================================================FUNCTIONS
	public void setTargetTPS(int targetTPS){
		this.targetTimeBetweenTicks = SEC_TO_NANOSEC/targetTPS;
		this.lastNanoSecondTick = System.nanoTime();
		this.lastSecond = System.nanoTime();
		this.actualNanosecond = System.nanoTime();
		this.preTPS = 0;
		this.TPS = 0;
	}
	public int getTPS(){
		return TPS;
	}
	//runs the main loop executing loopeable.tick(deltaTime) trying to get targetTicksPerSecond
	public void run(){
		loopeable.tick(0);
		while(true){
			lastNanoSecondTick = System.nanoTime();
			preTPS++;
			if( actualNanosecond - lastSecond >= SEC_TO_NANOSEC ){
				lastSecond = System.nanoTime();
				TPS = preTPS;
				//System.out.println(TPS);
				preTPS = 0;
			}
			long timeLeftToNextTick;
			while(true){
				actualNanosecond = System.nanoTime();
				timeLeftToNextTick = targetTimeBetweenTicks - (actualNanosecond - lastNanoSecondTick);
				if(timeLeftToNextTick>0){
					Thread.yield();
				}else{
					break;
				}	
			}
			float deltaT = ((float)System.nanoTime()-(float)lastNanoSecondTick)/(float)SEC_TO_NANOSEC;
			loopeable.tick(deltaT);
			//se podria implementar con un sleep pero se logra menos rendimiento
			//y si se toma en cuenta que lo que se quiere es lograr
			//la mayor efciencia en TPS sin pensar en la concurrencia esto por ahora 
			//es suficientemente bueno a pesar del busy waiting con yield para amortiguar
			//igualmente si se hace el sleep de una forma inteligente se puede mejorar
			/*if(0 < timeLeftToNextTick){
				try {
					long milisecs = timeLeftToNextTick/1000000;
					long nanosecs = timeLeftToNextTick%1000000;
					Thread.sleep(milisecs,(int)nanosecs);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}*/
		}
	}
}
