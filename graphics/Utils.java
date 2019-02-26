package graphics;

public class Utils{
	//===================================================================CONSTANTS
	//===================================================================VARIABLES
	private static Utils instance;
	private Panel panel = Panel.getInstance();
	//====================================================================CONSTRUCTORS
	protected Utils() {}
	//====================================================================FUNCTIONS
	public static Utils getInstace() {
		if(instance == null) {
			instance = new Utils();
		}
		return instance;
	}
	//====================================================================FUNCTIONS
	public int getWidth() {
		if(panel.getWidth()<50) {
			return 1;
		}else {
			return panel.getWidth()-50;
		}
	}
	public int getHeight() {
		if(panel.getHeight()<102) {
			return 1;
		}else {
			return panel.getHeight()-102;
		}
		
	}
}
