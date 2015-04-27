package ants;


public class WorkerAnt extends AntBaseClass {
		
	/** Thread that monitors current color below ant **/
	LookForColor colorSensor;
	
	/**
	 * Creates an instance of a worker ant and starts its color sensor
	 */
	public WorkerAnt(){        
		//Create color sensor thread
		colorSensor = new LookForColor();
        //Start color sensor thread
        colorSensor.start();
	}
	
	public String getCurrentColor(){
		return this.colorSensor.getCurrentColor();
	}
	
	/**
	 * Will follow a found color trail to a POI
	 */
	public void followTrail() {

	}

	/**
	 * Will draw a color trail back home to POI for other ants to follow
	 */
	public void makeTrail() {

	}

}

