package ants;

import lejos.hardware.Sound;
import lejos.utility.Delay;

public class FoodFinderAnt extends WorkerAnt {

	/** What color this robot considers valid food **/
	private final static String FOOD_COLOR = "Blue";

	/**
	 * Creates a nest finder Ant
	 */
	public FoodFinderAnt() {
		super();
	}

	/**
	 * Will evaluate current location and see if it is edible
	 */
	public void evauluateSiteForFood(String currentColor) {

		// Check if on top of food
		if (currentColor.equals(FOOD_COLOR)) {
			// Stop navigation
			this.stopNavigation();

			// Notify audience that it found food
			for (int i = 0; i < 10; i++) {
				//Beep
				Sound.setVolume(10);
				Sound.beep();
				
				//Ant returns to nest
				goHome();
				
				//Spin wait till ant gets home
				while(isAntStillNavigating()){}
				
				//Exit program
				System.exit(0);
			}
			Delay.msDelay(2000);
			System.exit(0);
		}
	}

	/**
	 * Will make this food finder ant return home
	 */
	public void goHome() {
		this.navigateToPoint(0, 0);
	}
}
