package ants;

import lejos.hardware.Sound;
import lejos.utility.Delay;

public class NestFinderAnt extends WorkerAnt {

	/** What color this robot considers a valid nest **/
	private final static String NEST_COLOR = "Blue";

	/**
	 * Creates a nest finder Ant
	 */
	public NestFinderAnt() {
		super();
	}

	/**
	 * Will evaluate current location and see if it is suitable for nesting
	 */
	public void evauluateNestSite(String currentColor) {
		
		// Check if on top of a nest
		if (currentColor.equals(NEST_COLOR)) {
			
			//Stop navigation
			this.stopNavigation();
			
			//Notify audience that it found nest and exit program
			System.out.println("Found a good nesting site!");			
			for(int i = 0; i < 10; i++){	
				Sound.setVolume(10);
				Sound.beep();
			}
			Delay.msDelay(2000);
			System.exit(0);
		}
	}
}
