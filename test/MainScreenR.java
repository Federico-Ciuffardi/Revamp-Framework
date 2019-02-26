package test;


public class MainScreenR extends core.Room{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	int i = 0;
	int j = 0;
	//====================================================================CONSTRUCTORS
	public MainScreenR(){
	}
	//====================================================================FUNCTIONS
	//executes periodically, deltaT is the time on seconds since the last tick
	protected void tick(float deltaT){
		System.out.println("TPS: " +core.getTPS()+" Instances: "+ j);
		i++;
		if(i==1) {
			this.addObject(new ButtonO());
			i=0;
			j++;
		}
	}	
}
