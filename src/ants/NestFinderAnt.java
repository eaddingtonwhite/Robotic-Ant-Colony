package ants;

import lejos.hardware.Sound;
import lejos.utility.Delay;

public class NestFinderAnt extends WorkerAnt {

	/**
	 * The amount of leverage this ant has in vote TODO are we going to use
	 * this? EAW
	 **/
	int influence;

	private final static String NEST_COLOR = "Green";

	/**
	 * Creates a nest finder Ant
	 */
	public NestFinderAnt() {
		super();
	}

	public void startSearchPath() {

		// Initialize Search Path
		float currentX = 0;
		float currentY = 0;
		float baseMoveAmmount = 20;
		int currentSide = 0;

		for (int i = 0; i < 1000; i++) {

			// Check if we should increase base move amount
			if (i % 2 == 0) {
				baseMoveAmmount += 10;
			}

			// Figure out location of next way point
			switch (currentSide) {
			case 0:
				currentX += baseMoveAmmount;
				break;
			case 1:
				currentY += baseMoveAmmount;
				break;
			case 2:
				currentX -= baseMoveAmmount;
				break;
			case 3:
				currentY -= baseMoveAmmount;
				break;
			}

			// Add calculated waypoint
			this.addWayPoint(currentX, currentY);

			// increment side count
			currentSide++;

			// Check if we should reset current side
			if (currentSide > 3) {
				currentSide = 0;
			}
		}

		// Start Searching
		this.startNavigation();
	}

	/**
	 * Will evaluate current location and see if it is suitable for nesting
	 */
	public void evauluateNestSite(String currentColor) {
		if (currentColor.equals(NEST_COLOR)) {
			System.out.println("Found a good nesting site!");
			for(int i = 0; i < 10; i++){				
				Sound.beep();
			}
			Delay.msDelay(2000);
			System.exit(0);
		}
	}
}
